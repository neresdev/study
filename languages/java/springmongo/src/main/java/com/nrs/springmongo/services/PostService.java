package com.nrs.springmongo.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springmongo.domain.Post;
import com.nrs.springmongo.repository.PostRepository;
import com.nrs.springmongo.services.exception.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final String OBJECT_NOT_FOUND_MESSAGE = "Post with id %s not found";
    private final PostRepository postRepository;

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format(OBJECT_NOT_FOUND_MESSAGE, id)));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
       
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSeach(text, minDate, maxDate);
    }

}
