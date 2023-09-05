package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import ch.zli.m223.model.Resource;
import ch.zli.m223.service.ResourceService;

@Path("/resources")
@Tag(name = "Resources", description = "Rescources and their handling")
@RolesAllowed({ "User", "Admin" })
public class ResourceController {
  
  @Inject
  ResourceService resourceService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Index all rescources.", 
      description = "Returns a list of all resources."
  )
  public List<Resource> index() {
      return resourceService.findAll();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Creates a new Resource.", 
      description = "Creates a new resource and returns the newly added resource."
  )
  @PermitAll
  public Resource create(Resource resource) {
     return resourceService.createResource(resource);
  }

  @Path("/{id}")
  @DELETE
  @Operation(
      summary = "Deletes an resource.",
      description = "Deletes an resource by its id."
  )
  public void delete(@PathParam("id") Long id) {
      resourceService.deleteResource(id);
  }

  @Path("/{id}")
  @PUT
  @Operation(
      summary = "Updates a resource.",
      description = "Updates an resource by its id."
  )
  public Resource update(@PathParam("id") Long id, Resource resource) {
      return resourceService.updateResource(id, resource);
  }
}