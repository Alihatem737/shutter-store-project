package com.shutterstore.services.impl;

import com.shutterstore.dto.Reviewrequestdto;
import com.shutterstore.dto.Reviewresponsedto;
import com.shutterstore.entity.Productentity;
import com.shutterstore.entity.Reviewentity;
import com.shutterstore.entity.Userentity;
import com.shutterstore.repository.*;
import com.shutterstore.services.Reviewservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class Reviewserviceimpl implements Reviewservice {


    @Autowired
    private Userrepo userrepo;


    @Autowired
    private Productrepo productrepo;

    @Autowired
    private Reviewrepo reviewrepo;


    @Override
    public Reviewresponsedto addreview(Reviewrequestdto request) {

        if (request.getRating()< 1 || request.getRating() > 5 ){
            throw new RuntimeException("incorrect rate");
        }
        else{
            Userentity user = userrepo.findById(request.getUserid())
                    .orElseThrow(() -> new RuntimeException("User not found"));


            Productentity product = productrepo.findById(request.getProductid())
                    .orElseThrow(() -> new RuntimeException("Product not found"));


            Reviewentity review = Reviewentity.builder()
                    .rating(request.getRating())
                    .comment(request.getComment())
                    .user(user)
                    .product(product)
                    .createdAt(LocalDateTime.now())
                    .build();


            Reviewentity savedreview =  reviewrepo.save(review);


            return Reviewresponsedto.builder()
                    .id(savedreview.getId())
                    .rating(savedreview.getRating())
                    .comment(savedreview.getComment())
                    .createdAt(savedreview.getCreatedAt())
                    .productid(savedreview.getProduct().getId())
                    .productname(savedreview.getProduct().getName())
                    .userid(savedreview.getUser().getId())
                    .username(savedreview.getUser().getName())
                    .build();
        }






    }



    @Override
    public List<Reviewresponsedto> getreviewsByproduct(Long productId) {
        Productentity product = productrepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<Reviewentity> reviews = reviewrepo.findByProduct_id(product.getId());

        List<Reviewresponsedto> response = new ArrayList<>();


        for (Reviewentity review : reviews){
            Reviewresponsedto addreview = Reviewresponsedto.builder()
                    .id(review.getId())
                    .rating(review.getRating())
                    .comment(review.getComment())
                    .productid(review.getProduct().getId())
                    .productname(review.getProduct().getName())
                    .userid(review.getUser().getId())
                    .createdAt(review.getCreatedAt())
                    .username(review.getUser().getName())
                    .build();

            response.add(addreview);
        }

        return response ;



    }



    @Override
    public List<Reviewresponsedto> getreviewsByuser(Long userId) {

        Userentity user = userrepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Reviewentity> reviews = reviewrepo.findByUser_id(userId);

        List<Reviewresponsedto> response = new ArrayList<>();

        for (Reviewentity review : reviews){
            Reviewresponsedto dto = Reviewresponsedto.builder()
                    .id(review.getId())
                    .rating(review.getRating())
                    .comment(review.getComment())
                    .createdAt(review.getCreatedAt())
                    .productid(review.getProduct().getId())
                    .productname(review.getProduct().getName())
                    .userid(review.getUser().getId())
                    .username(review.getUser().getName())
                    .build();

            response.add(dto);

        }
        return response;


    }



    @Override
    public Reviewresponsedto updatereview(Long reviewId, Reviewrequestdto requst) {


        Reviewentity review = reviewrepo.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));


        if (requst.getRating() < 1 || requst.getRating() > 5  ){

            throw new RuntimeException("Rating must be between 1 and 5");
        }
        else {

            review.setRating(requst.getRating());
            review.setComment(requst.getComment());

            Reviewentity savedreview =  reviewrepo.save(review);


            return Reviewresponsedto.builder()
                    .id(savedreview.getId())
                    .rating(savedreview.getRating())
                    .comment(savedreview.getComment())
                    .createdAt(savedreview.getCreatedAt())
                    .productid(savedreview.getProduct().getId())
                    .productname(savedreview.getProduct().getName())
                    .userid(savedreview.getUser().getId())
                    .username(savedreview.getUser().getName())
                    .build();

        }





    }




@Override
public void deletereview(Long reviewId) {

    Reviewentity review = reviewrepo.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));


    reviewrepo.delete(review);
}
}
