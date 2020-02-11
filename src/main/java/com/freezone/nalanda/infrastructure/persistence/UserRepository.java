package com.freezone.nalanda.infrastructure.persistence;

import com.freezone.nalanda.infrastructure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
