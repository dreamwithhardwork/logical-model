package org.models.core.dao;


import org.models.core.domain.Otp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OtpRepository extends MongoRepository<Otp,String> {

    List<Otp> findByUsername(String username);

    @Query( sort = "{date:-1}" )
    Otp findFirstByUsername(String username);

}
