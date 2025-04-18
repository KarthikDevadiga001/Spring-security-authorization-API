package com.androidventures.UniMealServer.springboot.repo;

import com.androidventures.UniMealServer.springboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Text;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, String> {
    User findByUsername(String username);
}
