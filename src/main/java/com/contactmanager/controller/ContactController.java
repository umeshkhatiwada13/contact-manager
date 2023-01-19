package com.contactmanager.controller;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.GlobalApiResponse;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 9:37 PM
 **/

@RestController
@RequestMapping("contact")
@Slf4j
@RequiredArgsConstructor
public class ContactController extends BaseController {

    private final ContactService contactService;

    @PostMapping("save")
    public ResponseEntity<GlobalApiResponse> save(@RequestBody ContactPojo contactPojo) {
        log.info("Contact Controller : Save Contact");
        boolean success = false;
        try {
            contactService.save(contactPojo);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                successResponse(success ? "Data saved Successfully" : "Something went wrong", null));
    }

    @GetMapping("find-all")
    public ResponseEntity<GlobalApiResponse> findAll() {
        log.info("Contact Controller : Find all Contacts ");
        boolean success = false;
        List<ContactProjection> data = null;
        try {
            data = contactService.findAll();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                successResponse(success ? "Data fetched successfully" : "Something went Wrong", data));
    }

    @DeleteMapping("delete")
    public ResponseEntity<GlobalApiResponse> delete(@RequestParam UUID id) throws Exception {
        log.info("Contact Controller : Delete Contact with id {}", id);
        boolean success = false;
        try {
            contactService.delete(id);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                successResponse(success ? "Data deleted Successfully" : "Something went Wrong", null));
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<GlobalApiResponse> findById(@PathVariable UUID id) {
        log.info("Contact Controller : Find by Id {} ",id);
        boolean success = false;
        Contact contact = null;
        try {
            contact = contactService.findById(id);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                successResponse(success ? "Data fetched successfully" : "Something went Wrong", contact));
    }
}
