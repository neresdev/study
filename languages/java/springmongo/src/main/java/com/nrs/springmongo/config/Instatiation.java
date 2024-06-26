package com.nrs.springmongo.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.nrs.springmongo.domain.Post;
import com.nrs.springmongo.domain.User;
import com.nrs.springmongo.repository.PostRepository;
import com.nrs.springmongo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@DependsOn("documentDbConfig")
@RequiredArgsConstructor
public class Instatiation implements CommandLineRunner{

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Maria Brown", "maria@hotmail.com"); 
        User user2 = new User(null, "Alex Green", "alex@gmail.com"); 
        User user3 = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!", user1);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", user1);


        userRepository.saveAll(List.of(user1, user2, user3));
        postRepository.saveAll(List.of(post1, post2));
    }
    
}
