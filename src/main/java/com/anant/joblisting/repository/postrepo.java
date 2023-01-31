package com.anant.joblisting.repository;
import com.anant.joblisting.model.post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface postrepo extends MongoRepository<post, String>
{
    // this mongorepository is used for curd ie create read update delete
}
