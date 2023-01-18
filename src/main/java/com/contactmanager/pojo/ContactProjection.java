package com.contactmanager.pojo;

import javax.persistence.Column;
import java.util.UUID;

/**
 * @author Umeshkhatiwada13
 * @created 18/01/2023 10:51 PM
 **/
public interface ContactProjection {
    UUID getId();

    String getName();

    String getCompany();

    String getEmail();

    String getTitle();

    String getMobile();

    String getPhotoUrl();
}
