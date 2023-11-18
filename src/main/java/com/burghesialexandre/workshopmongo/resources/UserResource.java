package com.burghesialexandre.workshopmongo.resources;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.burghesialexandre.workshopmongo.domain.User;
import com.burghesialexandre.workshopmongo.dto.UserDTO;
import com.burghesialexandre.workshopmongo.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        // User maria = new User("1", "maria", "maria@gmail.com");
        // User alex = new User("2", "Alex", "alex@gmail.com");
        // List<User> list = new ArrayList<User>();
        // list.addAll(Arrays.asList(maria, alex));
        List<User> list = service.findAll();
        final List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        // return ResponseEntity.ok().body(list);
        return ResponseEntity.ok().body(listDto);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
            User obj = service.fromDTO(objDto);
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

}
