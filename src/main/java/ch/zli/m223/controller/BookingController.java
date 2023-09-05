package ch.zli.m223.controller;
import javax.inject.Inject;
import javax.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import java.util.List;
import javax.annotation.security.RolesAllowed;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/booking")
@Tag(name = "Bookings", description = "Bookings and their handling")
@RolesAllowed({ "Member", "Admin" })
public class BookingController {
    
    @Inject
    BookingService bookingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all categories.", 
        description = "Returns a list of all categories."
    )
    public List<Booking> index() {
        return bookingService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new booking.", 
        description = "Creates a new booking and returns the newly added booking."
    )
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes a booking.",
        description = "Deletes a booking by its id."
    )
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates a booking.",
        description = "Updates a booking by its id."
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }



}




