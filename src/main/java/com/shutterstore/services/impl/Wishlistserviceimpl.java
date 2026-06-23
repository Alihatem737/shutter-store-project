package com.shutterstore.services.impl;

import com.shutterstore.dto.Wishlistrequestdto;
import com.shutterstore.dto.Wishlistresponsedto;
import com.shutterstore.entity.Productentity;
import com.shutterstore.entity.Userentity;
import com.shutterstore.entity.Wishlistentity;
import com.shutterstore.mapper.Wishlistmapper;
import com.shutterstore.repository.*;
import com.shutterstore.services.Wishlistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class Wishlistserviceimpl implements Wishlistservice {


    @Autowired
    private Userrepo userrepo;


    @Autowired
    private Productrepo productrepo;

    @Autowired
    private Wishlistrepo wishlistrepo;


    @Autowired
    private Wishlistmapper wishlistmapper;


    @Override
    public Wishlistresponsedto addwishlist(Wishlistrequestdto request) {
        Userentity user = userrepo.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Productentity product = productrepo.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));


        if (wishlistrepo.findByUser_IdAndProduct_Id(user.getId(), product.getId()).isPresent()){


            throw new RuntimeException("Product already exists in wishlist");



        }
        else {


            Wishlistentity wish = Wishlistentity.builder()
                    .user(user)
                    .product(product)
                    .createdAt(LocalDateTime.now())
                    .build();
            Wishlistentity savedwish = wishlistrepo.save(wish);


            return wishlistmapper.torespone(savedwish);
        }



    }




    @Override
    public List<Wishlistresponsedto> getwishlistbyuser(Long userId) {

        Userentity user = userrepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));


       List<Wishlistentity> wishlist = wishlistrepo.findByUser_Id(userId);

       List<Wishlistresponsedto> response = new ArrayList<>();
       if (wishlist.isEmpty()){
           throw new RuntimeException("Wishlist is empty");
       }
       else {

          for (Wishlistentity wish : wishlist){

              Wishlistresponsedto newwish = wishlistmapper.torespone(wish);

              response.add(newwish);


          }

          return response;


       }




    }





    @Override
    public void removewishlist(Long whishlistId) {


        Wishlistentity wish = wishlistrepo.findById(whishlistId)
                .orElseThrow(() ->new RuntimeException("Wishlist not found") );

        wishlistrepo.delete(wish);
    }



    @Override
    public boolean checkwishlist(Long userId, Long productId) {

        Optional<Wishlistentity> wishlist = wishlistrepo.findByUser_IdAndProduct_Id(userId , productId);

        return wishlist.isPresent();


    }

    @Override
    public void clearallwishlist(Long userId) {
        Userentity user = userrepo.findById(userId)
                .orElseThrow(() ->new RuntimeException("User not found") );


        List<Wishlistentity> wishlist = wishlistrepo.findByUser_Id(user.getId());



        if (wishlist.isEmpty()){
            throw new RuntimeException("Wishlist is empty");
        }
        else {
            for (Wishlistentity wish : wishlist) {
                wishlistrepo.delete(wish);
            }
        }
    }
}
