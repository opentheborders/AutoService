package com.auto.autoservice.model.data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "techworks")
public class TechWork {

    @Id
    String id;

    @NotBlank
    @Size(max = 20)
    private String techWorkName;

    public TechWork(Set<TechWork> techWorks) {

    }

    public TechWork(String techWorkName) {
    }

    public String getTechWorkName() {
        return techWorkName;
    }

}
