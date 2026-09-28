package com.project.StudyNova.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.project.StudyNova.Modal.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

	boolean existsByEmail(String email);

	Users findByEmail(String email);
	List<Users> findByRole(Users.UserRole role);



}
