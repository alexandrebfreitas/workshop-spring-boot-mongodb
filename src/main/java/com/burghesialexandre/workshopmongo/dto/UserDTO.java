package com.burghesialexandre.workshopmongo.dto;

import java.io.Serializable;

import com.burghesialexandre.workshopmongo.domain.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private String id;
    private String name;
    private String email;

    public  UserDTO(){

    }
    public UserDTO(User x){
        id = x.getId();
        name = x.getName();
        email = x.getEmail();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDTO other = (UserDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
