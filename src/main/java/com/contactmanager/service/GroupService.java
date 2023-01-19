package com.contactmanager.service;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.pojo.GroupProjection;

import java.util.List;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:49 PM
 **/
public interface GroupService {
    List<GroupProjection> findAll();

    Group findById(UUID id) throws Exception;

}
