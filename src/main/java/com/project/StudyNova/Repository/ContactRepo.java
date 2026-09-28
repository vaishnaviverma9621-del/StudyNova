package com.project.StudyNova.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.StudyNova.Modal.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}