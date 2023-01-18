package com.contactmanager.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 8:53 PM
 **/

@Getter
@Setter
public class ContactPojo {
    private UUID id;
    private String name;
    private String company;
    private String email;
    private String title;
    private String mobile;
    private String photoUrl;
}
