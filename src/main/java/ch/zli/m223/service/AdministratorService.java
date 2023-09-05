package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Administrator;
import ch.zli.m223.model.Booking;

@ApplicationScoped
public class AdministratorService {

    public List<Administrator> getAllAdministrators() {
        return null;
    }
    
    @Inject
    EntityManager entityManager;

    @Transactional
    public Administrator createAdministrator(Administrator administrator) {
        return entityManager.merge(administrator);
    }



 public List<Administrator> findAll() {
     var query = entityManager.createQuery("FROM Administrator", Administrator.class);
    return query.getResultList();
    }
    

    public Booking getAdministratorById(Long id) {
        return null;
    }


}
