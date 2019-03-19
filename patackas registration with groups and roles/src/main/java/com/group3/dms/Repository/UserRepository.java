package com.group3.dms.Repository;

import com.group3.dms.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
