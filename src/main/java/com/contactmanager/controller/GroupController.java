package com.contactmanager.controller;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.GlobalApiResponse;
import com.contactmanager.entity.Group;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.pojo.GroupProjection;
import com.contactmanager.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 11:13 PM
 **/

@RestController
@RequestMapping("group")
@Slf4j
@RequiredArgsConstructor
public class GroupController extends BaseController {

    private final GroupService groupService;

    @GetMapping("find-all")
    public ResponseEntity<GlobalApiResponse> findAll() {
        log.info("Group Controller : Find all Groups ");
        boolean success = false;
        List<GroupProjection> data = null;
        try {
            data = groupService.findAll();
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                successResponse(success ? "Data fetched successfully" : "Something went Wrong", data));
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<GlobalApiResponse> findById(@PathVariable UUID id) {
        log.info("Contact Controller : Find by Id {} ",id);
        boolean success = false;
        Group group = null;
        try {
            group = groupService.findById(id);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(
                successResponse(success ? "Data fetched successfully" : "Something went Wrong", group));
    }
}
