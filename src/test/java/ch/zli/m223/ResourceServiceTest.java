package ch.zli.m223;

import ch.zli.m223.model.Resource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;
import ch.zli.m223.service.ResourceService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class ResourceServiceTest {

    @Inject
    ResourceService resourceService;

    @Test
    @Transactional
    public void testCreateResource() {
     
        Resource resource = new Resource();
        resource.setName("Test Resource");
        resource.setDescription("Test Description");

        Resource createdResource = resourceService.createResource(resource);

     
        assertNotNull(createdResource.getId());
        assertEquals("Test Resource", createdResource.getName());
        assertEquals("Test Description", createdResource.getDescription());
    }

    @Test
    @Transactional
    public void testDeleteResource() {
      
        Resource resource = new Resource();
        resource.setName("Test Resource");
        resource.setDescription("Test Description");


        Resource createdResource = resourceService.createResource(resource);

      
        resourceService.deleteResource(createdResource.getId());

        Resource deletedResource = resourceService.getResourceById(createdResource.getId());

  
        assertNull(deletedResource);
    }

    @Test
    public void testGetAllResources() {
  
        List<Resource> resources = resourceService.getAllResources();

        assertNotNull(resources);
    }
}
