package com.contactmanager.service;

import com.contactmanager.entity.Contact;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.repo.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        } else {
            contact = this.findById(contactPojo.getId());
            contact.setName(contactPojo.getName());
            contact.setCompany(contactPojo.getCompany());
            contact.setEmail(contactPojo.getEmail());
            contact.setTitle(contactPojo.getTitle());
            contact.setMobile(contactPojo.getMobile());
            contact.setPhotoUrl(contactPojo.getPhotoUrl());
        }
        contactRepo.save(contact);
    }

    @Override
    public Contact findById(UUID id) throws Exception {
        Optional<Contact> contactOptional = contactRepo.findById(id);
        if (contactOptional.isEmpty()) {
            throw new Exception();
        }
        return contactOptional.get();
    }

    @Override
    public void delete(UUID id) throws Exception {
        Contact contact = this.findById(id);
        contactRepo.delete(contact);
    }
}
