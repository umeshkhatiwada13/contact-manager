package com.contactmanager.service;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;
import com.contactmanager.pojo.ContactPojo;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.pojo.GroupProjection;
import com.contactmanager.repo.ContactRepo;
import com.contactmanager.repo.GroupRepo;
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
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;

    @Override
    public List<GroupProjection> findAll() {
        return groupRepo.findAllV2();
    }

    @Override
    public Group findById(String id) throws Exception {
        Optional<Group> groupOptional = groupRepo.findById(id);
        if (groupOptional.isEmpty()) {
            throw new Exception();
        }
        return groupOptional.get();
    }
}
