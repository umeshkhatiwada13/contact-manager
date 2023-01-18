package com.contactmanager.repo;

import com.contactmanager.entity.Contact;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:48 PM
 **/
public interface ContactRepo extends JpaRepository<Contact, UUID> {

    @Override
    Optional<Contact> findById(UUID uuid);

    @Query(value = "select Cast(id as varchar) id,company, email, mobile,name, photo_url as photoUrl,title from contact", nativeQuery = true)
    List<ContactProjection> findAllV2();
}
