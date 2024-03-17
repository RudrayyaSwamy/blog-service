package com.vismotechnologies.blogsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResp {

    private String username;
    private String tocken;
}
