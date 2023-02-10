package com.xloop.resourceloop.createJob.ServiceInterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xloop.resourceloop.createJob.Model.GenericDropDownModel;

public class GenericDropDown< T extends GenericDropDownModel , S extends JpaRepository<T,Long>>{
    
    private final S repository ;
    

    public GenericDropDown(S repository) {
        this.repository = repository;
    }

    public T add(T t) {
        return repository.save(t);
    }

    public T update(T t) {
        return repository.save(t);
    }

    public void deactivate(Long id) {
        T t = repository.findById(id).get();
        // assume there's a method setActive in the model class
        t.setActive(false);
        repository.save(t);
    }

    public void reactive(Long id) {
        T t = repository.findById(id).get();
        t.setActive(true);
        repository.save(t);
    }

    public List<T> viewAll() {
        return repository.findAll();
    }

}
