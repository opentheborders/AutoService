package com.auto.autoservice.payload.response;

import com.auto.autoservice.model.data.Auto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> roles;
    private String auto;



    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles, String auto) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.auto =  auto;
    }
}