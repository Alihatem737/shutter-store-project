package com.shutterstore.services.impl;

import com.shutterstore.dto.Orderitemresponsedto;
import com.shutterstore.dto.Orderresponsedto;
import com.shutterstore.entity.*;
import com.shutterstore.repository.Cartrepo;
import com.shutterstore.repository.Orderrepo;
import com.shutterstore.repository.Productrepo;
import com.shutterstore.repository.Userrepo;
import com.shutterstore.services.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class Orderserviceimpl implements Orderservice {


    @Autowired
    private Orderrepo orderrepo;

    @Autowired
    private Cartrepo cartrepo;


    @Autowired
    private Userrepo userrepo;


    @Autowired
    private Productrepo productrepo;


    @Override
    public Orderresponsedto createorder(Long userid , String shippingAddress) {

        Userentity user = userrepo.findById(userid).orElseThrow();

        Cartentity cart = user.getCart();



        if (cart.getItems().isEmpty()){

            throw new RuntimeException("Cart is empty");
        }
        else {



            List<OrderItementity> items = new ArrayList<>();




            BigDecimal totalprice = BigDecimal.ZERO;
            for (Cartitementity item : cart.getItems()){

                Productentity product = item.getProduct();

                if (product.getStock() < item.getQuantity()) {


                    throw new RuntimeException("Insufficient stock for " + product.getName());

                }
                else {
                    BigDecimal subtotal = item.getProduct()
                            .getPrice()
                            .multiply(BigDecimal.valueOf(item.getQuantity()));

                    totalprice = totalprice.add(subtotal);






                    OrderItementity orderitem = OrderItementity.builder()
                            .product(product)
                            .quantity(item.getQuantity())
                            .unitprice(product.getPrice())
                            .build();


                    items.add(orderitem);



                    product.setStock(product.getStock() - item.getQuantity());
                    productrepo.save(product);
                }




            }

            Orderentity order  = Orderentity.builder()
                    .user(user)
                    .totalprice(totalprice)
                    .status("PENDING")
                    .createdat(LocalDateTime.now())
                    .shippingaddress(shippingAddress)
                    .items(items)
                    .build();





            for (OrderItementity oi : items) {
                oi.setOrder(order);    // كل item يعرف هو تابع لأي order
            }
            Orderentity saveorder = orderrepo.save(order);





            cart.getItems().clear();
            cartrepo.save(cart);




            return  Orderresponsedto.builder()
                    .id(saveorder.getId())
                    .userId(user.getId())
                    .status(saveorder.getStatus())
                    .totalPrice(saveorder.getTotalprice())
                    .createdAt(saveorder.getCreatedat())
                    .build();


        }


    }

    @Override
    public Orderresponsedto orderdetails(Long orderId) {
        Orderentity order = orderrepo.findById(orderId).orElseThrow();


        List<Orderitemresponsedto> orderitems = new ArrayList<>();
        for (OrderItementity items : order.getItems()) {
            Orderitemresponsedto item = Orderitemresponsedto.builder()
                    .id(items.getId())
                    .productid(items.getProduct().getId())
                    .productname(items.getProduct().getName())
                    .quantity(items.getQuantity())
                    .unitprice(items.getUnitprice())
                    .build();

            orderitems.add(item);

        }



        return Orderresponsedto.builder()
                .id(order.getId())
                .userId(order.getUser().getId())
                .totalPrice(order.getTotalprice())
                .status(order.getStatus())
                .createdAt(order.getCreatedat())
                .shippingAddress(order.getShippingaddress())
                .items(orderitems)
                .build();
    }





    @Override
    public List<Orderresponsedto> userordershistory(Long userid) {
        Userentity user = userrepo.findById(userid).orElseThrow();

        List<Orderentity> orderslist= orderrepo.findByUserId(userid);

        if (orderslist.isEmpty()){
            throw new RuntimeException("Ordes is empty");
        }
        else {

            List<Orderresponsedto> orders = new ArrayList<>();
            for (Orderentity order : orderslist) {



                List<Orderitemresponsedto> items = new ArrayList<>();
                for (OrderItementity orderitem : order.getItems()) {
                    Orderitemresponsedto response = Orderitemresponsedto
                            .builder()
                            .id(orderitem.getId())
                            .productid(orderitem.getProduct().getId())
                            .productname(orderitem.getProduct().getName())
                            .quantity(orderitem.getQuantity())
                            .unitprice(orderitem.getUnitprice())
                            .build();

                    items.add(response);

                }

                Orderresponsedto orderresponse = Orderresponsedto
                        .builder()
                        .id(order.getId())
                        .userId(order.getUser().getId())
                        .totalPrice(order.getTotalprice())
                        .status(order.getStatus())
                        .createdAt(order.getCreatedat())
                        .shippingAddress(order.getShippingaddress())
                        .items(items)
                        .build();

                orders.add(orderresponse);

            }

            return orders;


        }

    }

    @Override
    public Orderresponsedto updatestatusorder(Long orderId, String newStatus) {

        Orderentity order = orderrepo.findById(orderId).orElseThrow();

        order.setStatus(newStatus);

        orderrepo.save(order);

        List<Orderitemresponsedto> items = new ArrayList<>();

        for (OrderItementity orderitem : order.getItems())
        {
            Orderitemresponsedto respone =Orderitemresponsedto.builder()
                    .id(orderitem.getId())
                    .productid(orderitem.getProduct().getId())
                    .productname(orderitem.getProduct().getName())
                    .quantity(orderitem.getQuantity())
                    .unitprice(orderitem.getUnitprice())
                    .build();

            items.add(respone);
        }



        return Orderresponsedto.builder()
                .id(order.getId())
                .userId(order.getUser().getId())
                .totalPrice(order.getTotalprice())
                .status(order.getStatus())
                .createdAt(order.getCreatedat())
                .shippingAddress(order.getShippingaddress())
                .items(items)
                .build();


    }

    @Override
    public Orderresponsedto cancelorder(Long orderId) {
        Orderentity order = orderrepo.findById(orderId).orElseThrow();



        if (!order.getStatus().equals("PENDING")){
            throw new RuntimeException("Cannot cancel an order that is already " + order.getStatus());
        }
        else {

            List<Orderitemresponsedto> items = new ArrayList<>();
            for (OrderItementity item : order.getItems()){
                Productentity product=item.getProduct();

                product.setStock(product.getStock() + item.getQuantity());

                productrepo.save(product);


                Orderitemresponsedto response = Orderitemresponsedto.builder()
                        .id(item.getId())
                        .productid(product.getId())
                        .productname(product.getName())
                        .quantity(item.getQuantity())
                        .unitprice(item.getUnitprice())
                        .build();

                items.add(response);
            }

            order.setStatus("CANCELLED");
            orderrepo.save(order);


            return Orderresponsedto.builder()
                    .id(order.getId())
                    .userId(order.getUser().getId())
                    .totalPrice(order.getTotalprice())
                    .status(order.getStatus())
                    .createdAt(order.getCreatedat())
                    .shippingAddress(order.getShippingaddress())
                    .items(items)
                    .build();
        }


    }
}





























