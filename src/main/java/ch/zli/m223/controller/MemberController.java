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

import ch.zli.m223.model.Member;
import ch.zli.m223.service.MemberService;

@Path("/members")
@Tag(name = "Members", description = "Members and their handling")
@RolesAllowed({ "User", "Admin" })
public class MemberController {
  
  @Inject
  MemberService memberService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Index all members.", 
      description = "Returns a list of all users."
  )
  public List<Member> index() {
      return memberService.findAll();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Creates a new user. Also known as registration.", 
      description = "Creates a new user and returns the newly added user."
  )
  @PermitAll
  public Member create(Member member) {
     return userService.createUser(user);
  }

  @Path("/{id}")
  @DELETE
  @Operation(
      summary = "Deletes an user.",
      description = "Deletes an user by its id."
  )
  public void delete(@PathParam("id") Long id) {
      memberService.deleteMember(id);
  }

  @Path("/{id}")
  @PUT
  @Operation(
      summary = "Updates a member.",
      description = "Updates an member by its id."
  )
  public Member update(@PathParam("id") Long id, Member member) {
      return memberService.updateUser(id, member);
  }
}