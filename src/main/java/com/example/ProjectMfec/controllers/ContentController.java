package com.example.ProjectMfec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectMfec.Model.Content;
import com.example.ProjectMfec.Model.ContentRepository;




@RestController
@RequestMapping("/content")
public class ContentController {

	@Autowired
	ContentRepository repo;
	
	
	// Get All
		//@GetMapping("/getAllContent")
	@CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/getAllContent")
		public List<Content> getAllContent() {

			List<Content> Contents = repo.getAll();

			for (Content content : Contents) {

				System.out.print(content.getTitle());
			}

			return Contents;
		}
		
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/getByid/{content_user_id}")
	public List<Content> getbyUserId(@PathVariable long content_user_id){
		
		
		List<Content> Contents = repo.getbyUserId(content_user_id);
		
		return Contents;
		
	}
	
	//GET BY CONTENT ID
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET,path = "/geteditByContent/{content_id}")
	public List<Content> geteditByContent(@PathVariable long content_id){
		
		
		List<Content> Contents = repo.geteditByContent(content_id);
		
		return Contents;
		
	}
	
	//PUT EditConTent
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT, path="/edit_content")
	public void edit_content(@RequestBody Content content) {
		
		System.out.print(content.getId());
		repo.edit_content(content);
	}
	
//	@CrossOrigin
//	@RequestMapping(method = RequestMethod.POST, path = "/addContent")
//	public void addContent(@RequestBody Content content) {
//		System.out.print(content);
//		this.repo.addContent(content);
//	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,path = "/addContent")
	public void addContent(@RequestBody Content content) {
		
		System.out.print(content.getTitle());
		this.repo.addContent(content);
		
	}
	
	
	//DELETE CONTENT
	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE,path = "/deleteContent/{content_id}")
	public void deleteContent(@PathVariable long content_id) {
		System.out.print(content_id);
		
		this.repo.deleteContent(content_id);
		
	}
	
	
	
	
}
