package springApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springApp.controller.dto.UserDTO;
import springApp.domain.Users;

@Component
public class UsersService {
    UserRepository repository;

    @Autowired
    public UsersService (UserRepository userRepository){
        this.repository = userRepository;
    }
    @Transactional
    public void saveNewUser(UserDTO dto){
        Users user = new Users(dto);

        repository.save(user);
    }
    @Transactional (readOnly = true)
    public List<Users> findAllUsers() {
    	return repository.findAll();
    }
}
