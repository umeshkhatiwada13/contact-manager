package com.contactmanager.service;

import com.contactmanager.entity.Contact;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;

import java.util.List;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:49 PM
 **/
public interface ContactService {
    List<ContactProjection> findAll();

    void save(ContactPojo contactPojo) throws Exception;

    Contact findById(String id) throws Exception;

    void delete(String id) throws Exception;
}
