package com.shutterstore.controller;

import com.shutterstore.dto.Wishlistrequestdto;
import com.shutterstore.dto.Wishlistresponsedto;
import com.shutterstore.services.Wishlistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class Wishlistcontroller {

    @Autowired
    private Wishlistservice wishlistservice;

    @PostMapping("/add")
    public Wishlistresponsedto addwishlist(@RequestBody Wishlistrequestdto request) {

        return wishlistservice.addwishlist(request);
    }

    @GetMapping("/user/{userId}")
    public List<Wishlistresponsedto> getwishlistbyuser(@PathVariable Long userId) {

        return wishlistservice.getwishlistbyuser(userId);
    }

    @DeleteMapping("/remove/{wishlistId}")
    public void removewishlist(@PathVariable Long wishlistId) {

        wishlistservice.removewishlist(wishlistId);
    }

    @GetMapping("/check")
    public boolean checkwishlist(@RequestParam Long userId, @RequestParam Long productId) {
        return wishlistservice.checkwishlist(userId, productId);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearallwishlist(@PathVariable Long userId) {

        wishlistservice.clearallwishlist(userId);
    }
}