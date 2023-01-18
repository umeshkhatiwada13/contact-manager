package com.contactmanager.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
public class Contact {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String company;

    private String email;

    private String title;

    private String mobile;

    @Column(name = "photo_url")
    private String photoUrl;
}
