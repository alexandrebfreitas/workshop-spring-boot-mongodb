package com.burghesialexandre.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.burghesialexandre.workshopmongo.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burghesialexandre.workshopmongo.domain.User;
import com.burghesialexandre.workshopmongo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
