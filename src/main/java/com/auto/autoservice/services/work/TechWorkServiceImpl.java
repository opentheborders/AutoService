package com.auto.autoservice.services.work;

import com.auto.autoservice.model.data.TechWork;
import com.auto.autoservice.repository.work.TechWorkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechWorkServiceImpl implements TechWorkService{


    private final TechWorkRepository techWorkRepository;

    @Override
    public List<TechWork> findAll(){
        return techWorkRepository.findAll();
    }

    @Override
    public TechWork save(TechWork techwork) {
        return techWorkRepository.save(techwork);
    }

    @Override
    public TechWork update(TechWork techwork) {
        return techWorkRepository.save(techwork);
    }

    @Override
    public void delete(String id) {

    }
}
