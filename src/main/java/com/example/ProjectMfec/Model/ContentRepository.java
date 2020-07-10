package com.example.ProjectMfec.Model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ContentRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Content> getAll() {

		Query q = em.createQuery("from content");

		return q.getResultList();
	}
	
	
	
	public List<Content> getbyUserId(long content_user_id){
		
		Query q = em.createQuery("from content where content_user_id = '" + content_user_id +"'");
		
		return q.getResultList();
	}

	
	
	public List<Content> geteditByContent(long content_id){
		
		Query q = em.createQuery("from content where content_id = '" + content_id +"'");
		
		return q.getResultList();
	}
	
	
	@Transactional
	public void addContent(Content content) {
				System.out.print("Hello");
				System.out.print(content);
		
		Query q = em.createNativeQuery(
				"insert into content(content_user_id,content_title,content_detail) values(?,?,?) ")
				.setParameter(1,content.getUser_id())
				.setParameter(2,content.getTitle())
				.setParameter(3,content.getDetail());
				
		//content.getUser_id(),content.getTitle(),content.getDetail()
		int x = q.executeUpdate();

		if (x > 0) {
			System.out.println("Add Succress");
		}


	}
	
	@Transactional
	public void deleteContent(long content_id) {
		 
		
		
		
		Query q = em.createQuery("delete from content where content_id = '" + content_id +"'");

		q.executeUpdate();
		
	}
	
	
	//EDIR CONTENT
	@Transactional
	public void edit_content(Content content) {
		Query q = em.createNativeQuery("update content set content_user_id=?,content_title=?,content_detail=? where content_id =?")
				.setParameter(1,content.getUser_id())
				.setParameter(2,content.getTitle())
				.setParameter(3,content.getDetail())
				.setParameter(4,content.getId());
				
		q.executeUpdate();
	}
	
}
