package com.example.socialnetwork.socialnetwork.repos;

import com.example.socialnetwork.socialnetwork.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {

}
