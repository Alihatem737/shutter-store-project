package com.shutterstore.controller;

import com.shutterstore.dto.Reviewrequestdto;
import com.shutterstore.dto.Reviewresponsedto;
import com.shutterstore.services.Reviewservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class Reviewcontroller {

    @Autowired
    private Reviewservice reviewservice;

    @PostMapping("/add")
    public Reviewresponsedto addreview(@Valid  @RequestBody Reviewrequestdto request) {
        return reviewservice.addreview(request);
    }

    @GetMapping("/product/{productId}")
    public List<Reviewresponsedto> getreviewsbyproduct(@PathVariable Long productId) {
        return reviewservice.getreviewsByproduct(productId);
    }

    @GetMapping("/user/{userId}")
    public List<Reviewresponsedto> getreviewsbyuser(@PathVariable Long userId) {
        return reviewservice.getreviewsByuser(userId);
    }

    @PutMapping("/update/{reviewId}")
    public Reviewresponsedto updatereview(@Valid @PathVariable Long reviewId, @RequestBody Reviewrequestdto request) {

        return reviewservice.updatereview(reviewId, request);
    }

    @DeleteMapping("/delete/{reviewId}")
    public void deletereview(@PathVariable Long reviewId) {
        reviewservice.deletereview(reviewId);
    }
}