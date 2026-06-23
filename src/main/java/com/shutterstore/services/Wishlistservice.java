package com.shutterstore.services;

import com.shutterstore.dto.Wishlistrequestdto;
import com.shutterstore.dto.Wishlistresponsedto;

import java.util.List;

public interface Wishlistservice {



    Wishlistresponsedto addwishlist (Wishlistrequestdto request);

    List<Wishlistresponsedto>  getwishlistbyuser (Long userId);

    void removewishlist (Long whishlistId);

    boolean checkwishlist(Long userId , Long productId);

    void clearallwishlist(Long userId);




}
