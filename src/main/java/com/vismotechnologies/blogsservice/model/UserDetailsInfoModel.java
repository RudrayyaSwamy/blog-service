package com.vismotechnologies.blogsservice.model;

import com.vismotechnologies.blogsservice.entity.UserDetailsInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDetailsInfoModel {

    private String name;
    private String email;

    public UserDetailsInfoModel(UserDetailsInfo userDetailsInfo){
        name=userDetailsInfo.getName();
        email=userDetailsInfo.getEmail();
    }

}
