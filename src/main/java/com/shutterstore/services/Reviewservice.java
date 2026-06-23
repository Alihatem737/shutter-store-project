package com.shutterstore.services;

import com.shutterstore.dto.Reviewrequestdto;
import com.shutterstore.dto.Reviewresponsedto;

import java.util.List;

public interface Reviewservice {

    Reviewresponsedto addreview(Reviewrequestdto request);

    List<Reviewresponsedto> getreviewsByproduct(Long productId);

    List<Reviewresponsedto> getreviewsByuser(Long userId);

    Reviewresponsedto updatereview(Long reviewId , Reviewrequestdto requst);

    void deletereview(Long reviewId);

}
