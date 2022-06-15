package com.auto.autoservice.model.auth;


import com.auto.autoservice.model.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private ERole name;


    public Role(ERole name) {
        this.name = name;
    }

}