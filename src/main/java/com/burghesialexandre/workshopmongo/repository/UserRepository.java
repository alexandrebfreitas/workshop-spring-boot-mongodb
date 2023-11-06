package com.burghesialexandre.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.burghesialexandre.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
