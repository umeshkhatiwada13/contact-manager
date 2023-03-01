package com.contactmanager.repo;

import com.contactmanager.entity.Contact;
import com.contactmanager.entity.Group;
import com.contactmanager.pojo.ContactProjection;
import com.contactmanager.pojo.GroupProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:48 PM
 **/
public interface GroupRepo extends JpaRepository<Group, String> {
    @Override
    Optional<Group> findById(String uuid);

    @Query(value = "select Cast(id as varchar) id,name from tbl_group", nativeQuery = true)
    List<GroupProjection> findAllV2();
}
