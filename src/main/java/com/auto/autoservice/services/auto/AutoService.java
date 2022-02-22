package com.auto.autoservice.services.auto;

import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.model.data.Auto;

import java.util.List;

public interface AutoService {

    List<Auto> findAll();

    Auto save(Auto techwork);

    void creation(User user, Auto auto);

    Auto update(Auto techwork);

    void delete(String id);

}
