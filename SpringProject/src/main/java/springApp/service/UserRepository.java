package springApp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import springApp.domain.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
}
