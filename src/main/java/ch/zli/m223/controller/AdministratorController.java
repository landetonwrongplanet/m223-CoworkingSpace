package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import java.util.List;
import javax.annotation.security.RolesAllowed;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Administrator;

import ch.zli.m223.service.AdministratorService;


@Path("/administrator")
@Tag(name = "Administrators", description = "Administratorss and their handling")
@RolesAllowed({  "Admin" })
public class AdministratorController {
    
    @Inject
    AdministratorService administratorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all administrators.", 
        description = "Returns a list of all administrators."
    )
    public List<Administrator> index() {
        return administratorService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new Admin.", 
        description = "Creates a new Admin and returns the newly added admin."
    )
    public Administrator create(Administrator administrator) {
       return administratorService.createAdministrator(administrator);
    }





}




