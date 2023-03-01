package com.contactmanager.entity;

import com.corechoes.base.dto.BaseDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 11:11 PM
 **/
@Entity
@Table(name = "tbl_group")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group extends BaseDTO {
//    @Id
//    @GeneratedValue
//    private UUID id;

    private String name;
}
