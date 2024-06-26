package com.nrs.springmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springmongo.domain.User;
import com.nrs.springmongo.dto.UserDTO;
import com.nrs.springmongo.repository.UserRepository;
import com.nrs.springmongo.services.exception.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final String OBJECT_NOT_FOUND_MESSAGE = "User with id %s not found";
    private final UserRepository userRepository;

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(String.format(OBJECT_NOT_FOUND_MESSAGE, id)));
    }

    public UserDTO insert(UserDTO user){
        return new UserDTO(userRepository.insert(fromDTO(user)));
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(UserDTO userDTO){
        var newUser = findById(userDTO.getId());
        updateData(newUser, userDTO);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, UserDTO userDTO) {
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(null, userDTO.getName(), userDTO.getEmail());
    }

    
}
