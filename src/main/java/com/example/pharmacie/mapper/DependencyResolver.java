package com.example.pharmacie.mapper;

import com.example.pharmacie.model.Medicament;
import com.example.pharmacie.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class DependencyResolver {
    public static DependencyResolver instance;
    @PostConstruct
    public void init(){
        instance = this;
    }
    @Autowired
    private MedicamentRepository medicamentRepository;
    public Collection<Medicament> resolveByIds(Collection<Long> ids) {
        return ids.stream()
                .map(id -> medicamentRepository.findById(id).orElseThrow(() ->
                        new IllegalArgumentException(String.format("Medicamenent with id %d does not exist", id))
                )).collect(Collectors.toList());
    }
}
