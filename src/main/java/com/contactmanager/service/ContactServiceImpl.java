package com.contactmanager.service;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.repo.ContactRepo;
import com.contactmanager.repo.GroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:51 PM
 **/

@RequiredArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepo contactRepo;
    private final GroupRepo groupRepo;

    @Override
    public List<ContactProjection> findAll() {
        return contactRepo.findAllV2();
    }

    @Override
    public void save(ContactPojo contactPojo) throws Exception {
        Contact contact;
        if (contactPojo.getId() == null) {
            contact = Contact.builder()
                    .name(contactPojo.getName())
                    .company(contactPojo.getCompany())
                    .email(contactPojo.getEmail())
                    .title(contactPojo.getTitle())
                    .mobile(contactPojo.getMobile())
                    .photoUrl(contactPojo.getPhotoUrl())
                    .build();
            contact.setCreatedBy("SYSTEM");
            contact.setCreatedDate(LocalDateTime.now());
        } else {
            contact = this.findById(contactPojo.getId());
            contact.setName(contactPojo.getName());
            contact.setCompany(contactPojo.getCompany());
            contact.setEmail(contactPojo.getEmail());
            contact.setTitle(contactPojo.getTitle());
            contact.setMobile(contactPojo.getMobile());
            contact.setPhotoUrl(contactPojo.getPhotoUrl());
            contact.setUpdatedBy("SYSTEM");
            contact.setUpdatedDate(LocalDateTime.now());
        }
        if (StringUtils.hasLength(contactPojo.getGroupId())) {
            Optional<Group> groupOpt = groupRepo.findById(contactPojo.getGroupId());
            groupOpt.ifPresent(contact::setGroup);
        }
        contactRepo.save(contact);
    }

    @Override
    public Contact findById(String id) throws Exception {
        Optional<Contact> contactOptional = contactRepo.findById(id);
        if (contactOptional.isEmpty()) {
            throw new Exception();
        }
        return contactOptional.get();
    }

    @Override
    public void delete(String id) throws Exception {
        Contact contact = this.findById(id);
        contactRepo.delete(contact);
    }
}
