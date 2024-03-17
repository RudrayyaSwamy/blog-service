package com.vismotechnologies.blogsservice.model;

import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDetailsInfoAdminModel {

    private String name;
    private String email;
    private String role;
    private byte[] profile;
    public UserDetailsInfoAdminModel(UserDetailsInfo userDetailsInfo){
        name=userDetailsInfo.getName();
        email=userDetailsInfo.getEmail();
        role=userDetailsInfo.getRole();
        profile=userDetailsInfo.getProfile();
    }

}
