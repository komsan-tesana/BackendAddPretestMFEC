package com.example.ProjectMfec.Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager em;

	public List<User> getAll() {

		Query q = em.createQuery("from user");

		return q.getResultList();
	}

	@Transactional
	public List<User> getUserById(long id) {

		Query q = em.createQuery("from user where user_id = '" + id +"'");

		return q.getResultList();
	}
	
	
	
	public List<User> getUserByUsername(String username) {

		Query q = em.createQuery("from user where user_username = '" + username + "'");

		return q.getResultList();
	}
	
	
	//ADD USER
	@Transactional
	public void addUser(User user) {
		
		
		Query q = em.createNativeQuery(
				"insert into user(user_name,user_username,user_password,user_email,user_address) values(?,?,?,?,?) ")
				.setParameter(1, user.getName()).setParameter(2, user.getUsername()).setParameter(3, user.getPassword())
				.setParameter(4, user.getEmail()).setParameter(5, user.getAddress());

		int x = q.executeUpdate();

		if (x > 0) {
			System.out.println("Add Succress");
		}


	}
	
	//EDITPROFILE
	@Transactional
	public void editUserDetail(User user) {
		
		Query q = em.createNativeQuery("update user set user_name=?,user_email=?,user_address=? where user_id=?")
				.setParameter(1,user.getName())
				.setParameter(2,user.getEmail())
				.setParameter(3,user.getAddress())
				.setParameter(4,user.getId());
		
		
		int x = q.executeUpdate();

		if (x > 0) {
			System.out.println("Edit Succress");
		}

	}
	
	
	
	
	

}
