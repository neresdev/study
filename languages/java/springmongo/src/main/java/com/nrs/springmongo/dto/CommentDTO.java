package com.nrs.springmongo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDTO implements Serializable{
    
    private String text;
    
    private Date date;
    
    private AuthorDTO authorDTO;

    
}
