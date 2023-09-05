package ch.zli.m223.controller;

import javax.inject.Inject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.hibernate.MappingException;


import ch.zli.m223.model.Member;
import ch.zli.m223.service.MemberService;

@Path("/members")
public class MemberController {
    @Inject
    MemberService memberService;
    @POST
    @Path("/register")
    public Response registerMember(MemberRegistrationRequest request) {
        Member registeredMember = memberService.register(request.getName(), request.getEmail(), request.getPassword());
        return Response.status(Response.Status.CREATED).entity(registeredMember).build();
    }

    private Object getMessage() {
        return null;
    }

    @POST
    @Path("/login")
    public Response loginMember(MemberRegistrationRequest request) {
        try{
            Member loggedInMember = memberService.login(request.getEmail(), request.getPassword());
            return Response.ok(loggedInMember).build();
        } catch (MappingException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(getMessage()).build();
        }
    }
}
