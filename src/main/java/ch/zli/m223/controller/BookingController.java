package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.jdbc.BatchFailedException;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

import java.util.List;

@Path("/admin/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingController {

    @Inject
    BookingService bookingService;

    @POST
    public Response createBooking(BookingRequest request) {
        try {
            Booking createdBooking = bookingService.createBooking(request.getMemberId(), request.getResourceId(), request.getDate());
            return Response.status(Response.Status.CREATED).entity(createdBooking).build();
        } catch (BatchFailedException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return bookings;
    }

    @GET
    @Path("/{id}")
    public Response getBookingById(@PathParam("id") Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking != null) {
            return Response.ok(booking).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateBooking(@PathParam("id") Long id, BookingRequest request) {
        try {
            Booking updatedBooking = bookingService.updateBooking(id, request.getMemberId(), request.getResourceId(), request.getDate());
            return Response.ok(updatedBooking).build();
        } catch (BatchFailedException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") Long id) {
        try {
            bookingService.deleteBooking(id);
            return Response.noContent().build();
        } catch (BatchFailedException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
