package com.nrs.springmongo.dto;

import java.io.Serializable;

import com.nrs.springmongo.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthorDTO implements Serializable{
    
    private String id;
    
    private String name;
    
    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }



    
}
