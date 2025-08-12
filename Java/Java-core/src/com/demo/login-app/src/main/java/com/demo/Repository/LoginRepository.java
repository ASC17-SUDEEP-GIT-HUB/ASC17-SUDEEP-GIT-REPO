package com.demo.Repository;

import com.demo.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsernameAndPassword(String username, String password);
}
