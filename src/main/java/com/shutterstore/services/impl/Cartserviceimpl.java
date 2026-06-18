package com.shutterstore.services.impl;

import com.shutterstore.dto.Cartitemresponsedto;
import com.shutterstore.dto.Cartrequestdto;
import com.shutterstore.dto.Cartresponsedto;
import com.shutterstore.dto.Updatecartitemdto;
import com.shutterstore.entity.Cartentity;
import com.shutterstore.entity.Cartitementity;
import com.shutterstore.entity.Productentity;
import com.shutterstore.entity.Userentity;
import com.shutterstore.repository.Cartitemrepo;
import com.shutterstore.repository.Cartrepo;
import com.shutterstore.repository.Productrepo;
import com.shutterstore.repository.Userepo;
import com.shutterstore.services.Cartservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class Cartserviceimpl implements Cartservice {



    @Autowired
    private Productrepo productrepo;

//----


    @Autowired
    private Userepo userepo;


    @Autowired
    private Cartrepo cartrepo;


    @Autowired
    private Cartitemrepo cartitemrepo;



    @Override
    public Cartresponsedto addtocart(Cartrequestdto request) {


        Userentity user = userepo.findById(request.getUserId()).orElseThrow();
        Productentity product = productrepo.findById(request.getProductId()).orElseThrow();

        Optional<Cartentity> cartOptional = cartrepo.findByUser(user);
        Cartentity cart;

        //check cart
        if (cartOptional.isPresent()){
             cart = cartOptional.get();
        }
        else {
            cart = new Cartentity();
            cart.setUser(user);
            cart = cartrepo.save(cart);

        }


        Optional<Cartitementity> cartItemOptional =
                cartitemrepo.findByCartAndProduct(cart, product);

        Cartitementity cartItem;

        if (cartItemOptional.isPresent()) {

            cartItem = cartItemOptional.get();

            cartItem.setQuantity(
                    cartItem.getQuantity() + request.getQuantity()
            );

        } else {

            cartItem = new Cartitementity();

            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
        }

        cartitemrepo.save(cartItem);


        List<Cartitemresponsedto> items = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;


        cart = cartrepo.findById(cart.getId()).orElseThrow();
        for (Cartitementity item : cart.getItems()){
            //5000
            BigDecimal price = item.getProduct().getPrice();

            //5000*3
            BigDecimal subtotal = price.multiply(
                    BigDecimal.valueOf(item.getQuantity())
            );


            Cartitemresponsedto itemResponse =
                    Cartitemresponsedto.builder()
                            .productId(item.getProduct().getId())
                            .productName(item.getProduct().getName())
                            .quantity(item.getQuantity())
                            .price(price)
                            .subtotal(subtotal)
                            .build();


            items.add(itemResponse);

            totalPrice = totalPrice.add(subtotal);
        }


        Cartresponsedto response =
                Cartresponsedto.builder()
                        .cartId(cart.getId())
                        .userId(user.getId())
                        .items(items)
                        .totalPrice(totalPrice)
                        .build();




        return response;




    }

    @Override
    public Cartresponsedto getcart(Long id) {
        Optional<Cartentity> usercart = cartrepo.findByUserId(id);



        if (usercart.isPresent()){
            Cartentity cart = usercart.get();

            List<Cartitemresponsedto> items = new ArrayList<>();
            BigDecimal totalprice = BigDecimal.ZERO;

            for (Cartitementity item : cart.getItems() ){

                //5000
                BigDecimal price = item.getProduct().getPrice();
                //5000*quantity
                BigDecimal subtotal = price.multiply(
                        BigDecimal.valueOf(item.getQuantity())
                );
                Cartitemresponsedto itemResponse =
                        Cartitemresponsedto.builder()
                                .productId(item.getProduct().getId())
                                .productName(item.getProduct().getName())
                                .quantity(item.getQuantity())
                                .price(price)
                                .subtotal(subtotal)
                                .build();

                items.add(itemResponse);


                totalprice = totalprice.add(subtotal);


            }


            return Cartresponsedto.builder()
                    .cartId(cart.getId())
                    .userId(id)
                    .items(items)
                    .totalPrice(totalprice)
                    .build();
        }
        else {
            return Cartresponsedto.builder()
                    .userId(id)
                    .cartId(null)
                    .items(new ArrayList<>())
                    .totalPrice(BigDecimal.ZERO)
                    .build();
        }
    }

    @Override
    public Cartresponsedto updatequantity(Updatecartitemdto dto) {

        Optional<Cartitementity> optionalitem = cartitemrepo.findById(dto.getId());


        if (optionalitem.isPresent()){
            Cartitementity item = optionalitem.get();

            item.setQuantity(dto.getQuantity());

            cartitemrepo.save(item);

            Long userid =
                    item.getCart()
                            .getUser()
                            .getId();

            return getcart(userid);
        }
        throw new RuntimeException("Cart item not found");
    }

    @Override
    public Cartresponsedto deleteitem(Long id) {



        Cartitementity item = cartitemrepo.findById(id).orElseThrow();
        Long userId = item.getCart()
                        .getUser()
                        .getId();

        cartitemrepo.delete(item);

        return getcart(userId);
    }

    @Override
    public Cartresponsedto clearcart(Long id) {
        Cartentity cart = cartrepo.findByUserId(id).orElseThrow();

       List<Cartitementity> items = cart.getItems();


       cartitemrepo.deleteAll(items);

       return getcart(id);

    }


}







