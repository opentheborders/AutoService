package com.auto.autoservice.model.data;


import com.auto.autoservice.model.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Generated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Component
@Document(collection = "autos")
public class Auto {

        @Id
        String id;

        @NotBlank
        @Size(max = 20)
        private String autoName;

        @DBRef
        private Set<TechWork> techWorks = new HashSet<>();


        public Auto(String autoName) {
                this.autoName = autoName;
        }

        public Auto(String autoName, Set<TechWork> techWorks) {
                this.autoName = autoName;
                this.techWorks = techWorks;

        }

        public Set<TechWork> getTechWorks() {
                return techWorks;
        }

        public void setTechWorks(Set<TechWork> techWorks) {
                this.techWorks = techWorks;
        }
}

