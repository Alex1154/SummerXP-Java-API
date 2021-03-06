package com.users.api.userapi.Services;

import java.util.List;

import java.util.UUID;

import com.users.api.userapi.Model.User;
import com.users.api.userapi.Repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Object getUser(UUID id) {
    return userRepository.findById(id);
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(UUID id, User user) {
    User actualUser = userRepository.getById(id);
    BeanUtils.copyProperties(user, actualUser, "id");
    return userRepository.save(actualUser);
  }

  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }

  public boolean equalUsers(User user) {
    List<User> users = getAllUsers();
    for (User i : users) {
      if (i.getCpf().equals(user.getCpf()) || i.getEmail().equals(user.getEmail())) {
        return false;
      }
    }
    return true;
  }

}
