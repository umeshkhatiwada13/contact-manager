package com.contactmanager.entity;

import com.corechoes.base.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:36 PM
 **/

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends BaseDTO {

//    @Id
//    @GeneratedValue
//    private UUID id;

    private String name;

    private String company;

    private String email;

    private String title;

    private String mobile;

    @Column(name = "photo_url")
    private String photoUrl;

    //    @JsonIgnore
    @OneToOne/*(fetch = FetchType.LAZY)*/
    @JoinColumn(name = "group_id")
    private Group group;
}
