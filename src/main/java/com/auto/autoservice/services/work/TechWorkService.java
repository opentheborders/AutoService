package com.auto.autoservice.services.work;

import com.auto.autoservice.model.data.TechWork;

import java.util.List;

public interface TechWorkService {
    List<TechWork> findAll();

    TechWork save(TechWork techwork);

    TechWork update(TechWork techwork);

    void delete(String id);

}
