package org.sid.dao;

import org.sid.Entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepositry extends JpaRepository<Contact, Long> {

	@Query("select c from contact c where c.nom = :x")
	public Page<Contact> chercher(@Param("x") String mc,Pageable pageable);
}
