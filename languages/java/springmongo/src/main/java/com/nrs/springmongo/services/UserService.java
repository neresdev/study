package com.nrs.springmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springmongo.domain.User;
import com.nrs.springmongo.dto.UserDTO;
import com.nrs.springmongo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }
}
