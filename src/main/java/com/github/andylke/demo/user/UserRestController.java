package com.github.andylke.demo.user;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserRestController {

  @Autowired private UserRepository userRepository;

  @Autowired private UserCredentialsRepository userCredentialsRepository;

  @GetMapping("/{username}")
  public FindUserResponse findUser(@PathVariable String username) {
    final Optional<User> userResult = userRepository.findByUsername(username);
    if (userResult.isEmpty()) {
      throw new EntityNotFoundException("User not found");
    }

    final User user = userResult.get();
    return new ModelMapper().map(user, FindUserResponse.class);
  }

  @PostMapping("/{username}/change-credentials")
  @Transactional
  public ChangeCredentialsResponse changeCredentials(
      @PathVariable String username, @RequestBody ChangeCredentialsRequest request) {

    final Optional<User> userResult = userRepository.findByUsername(username);
    if (userResult.isEmpty()) {
      throw new EntityNotFoundException("User not found");
    }

    final User user = userResult.get();
    final Optional<UserCredentials> userCredentialsResult =
        userCredentialsRepository.findByUsername(username);
    if (userCredentialsResult.isEmpty()) {
      throw new EntityNotFoundException("User credentials not found");
    }

    final UserCredentials userCredentials = userCredentialsResult.get();
    userCredentials.setPassword(request.getNewPassword());
    userCredentials.setLastChangeDateTime(LocalDateTime.now());

    user.setLastCredentialsChangeDateTime(userCredentials.getLastChangeDateTime());

    userRepository.save(user);
    userCredentialsRepository.save(userCredentials);

    final ChangeCredentialsResponse response = new ChangeCredentialsResponse();
    response.setLastCredentialsChangeDateTime(userCredentials.getLastChangeDateTime());
    return response;
  }
}
