package com.codewithtalha.contactapp.repository;

import com.codewithtalha.contactapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
