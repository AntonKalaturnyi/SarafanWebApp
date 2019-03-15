package com.example.socialnetwork.socialnetwork.repos;

import com.example.socialnetwork.socialnetwork.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}
