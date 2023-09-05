package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Resource;

@ApplicationScoped
public class ResourceService {

    public List<Resource> getAllResources() {
        return null;
    }
 
    @Inject
    EntityManager entityManager;

    @Transactional
    public Resource createBooking(Resource resource) {
        return entityManager.merge(resource);
    }

    @Transactional
    public void deleteResource(Long id) {
        var entity = entityManager.find(Resource.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Resource updateResource(Long id, Resource resource) {
        resource.setId(id);
        return entityManager.merge(resource);
    }

 public List<Resource> findAll() {
     var query = entityManager.createQuery("FROM Resource", Resource.class);
    return query.getResultList();
    }
    

    public Resource getResourceById(Long id) {
        return null;
    }

    public Resource createResource(Resource resource) {
        return null;
    }


}
