

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
import ch.zli.m223.model.Message;

import ch.zli.m223.service.MessageService;

@Path("/messages")
@Tag(name = "Message", description = "Messages and their handling")
@RolesAllowed({ "User", "Admin" })
public class MessageController {
  
  @Inject
  MessageService messageService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Index all messages.", 
      description = "Returns a list of all messages."
  )
  public List<Message> index() {
      return messageService.findAll();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Operation(
      summary = "Creates a new message. Also known as chatting.", 
      description = "Creates a new message and returns the newly addeded message."
  )
  @PermitAll
  public Message create(Message message) {
     return messageService.createMessage(message);
  }

  @Path("/{id}")
  @DELETE
  @Operation(
      summary = "Deletes an message.",
      description = "Deletes an message by its id."
  )
  public void delete(@PathParam("id") Long id) {
      messageService.deleteMessage(id);
  }

  @Path("/{id}")
  @PUT
  @Operation(
      summary = "Updates a message.",
      description = "Updates an message by its id."
  )
  public Message update(@PathParam("id") Long id, Message message) {
      return messageService.updateMessage(id, message);
  }
}