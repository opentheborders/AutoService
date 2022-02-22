package com.auto.autoservice.services.auto;


import com.auto.autoservice.model.auth.User;
import com.auto.autoservice.model.data.Auto;

import com.auto.autoservice.repository.auth.UserRepository;
import com.auto.autoservice.repository.work.AutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class AutoServiceImpl implements AutoService {


    private final AutoRepository autoRepository;

    @Override
    public List<Auto> findAll(){
        List<Auto> autos = autoRepository.findAll();
        return autos;
    }

    @Override
    public void creation(User user, Auto auto) {

    }

    @Override
    public Auto save(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public Auto update(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public void delete(String id) {

    }
}
