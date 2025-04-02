/*package com.kums.ecomdummy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kums.ecomdummy.model.Users;



@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>  {

	
	//@Query("Select u1 from Users u1 where u1.name = :username")
	Users findByUsername(String username);
	
}
*/
