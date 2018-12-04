package org.sid.web;

import java.util.List;

import org.sid.Entity.Contact;
import org.sid.dao.ContactRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ContactRestService {
	@Autowired
	private ContactRepositry contactRepositry;
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getAllContact(){
		return  contactRepositry.findAll();}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return  contactRepositry.findOne(id);}
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact saveContact(@RequestBody Contact c) {
		return contactRepositry.save(c);
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean deleteContact(@PathVariable Long id) {
		contactRepositry.delete(id);
		return true;
	}
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact updateContact(@PathVariable Long id,@RequestBody Contact c) {
		c.setId(id);
		return contactRepositry.save(c);
	}
	@RequestMapping(value="/chercheContacts",method=RequestMethod.GET)
	public Page<Contact> chercherContact(@RequestParam (name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size){
		return contactRepositry.chercher("%"+mc+"%", new PageRequest(page, size));
	}
		
	}
	

