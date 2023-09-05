package ch.zli.m223.service;



import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import ch.zli.m223.model.Member;

import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;

@IfBuildProfile("dev")
@ApplicationScoped
public class TestDataService {

  @Inject
  EntityManager entityManager;

  @Transactional
  void generateTestData(@Observes StartupEvent event) {


    var newMember = new Member();
    newMember.setName("Ilenia");
    entityManager.persist(newMember);
  

   
  }
}
