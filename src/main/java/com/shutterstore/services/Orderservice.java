package com.shutterstore.services;


import com.shutterstore.dto.Orderresponsedto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Orderservice {


    Orderresponsedto createorder (Long userid , String shippingAddress);

    Orderresponsedto orderdetails(Long orderId);

    List<Orderresponsedto> userordershistory(Long userid);

    Orderresponsedto updatestatusorder(Long orderId , String newStatus);

    Orderresponsedto cancelorder (Long orderId);



}
