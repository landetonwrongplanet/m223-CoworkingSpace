package ch.zli.m223;

import ch.zli.m223.service.BookingService;

import ch.zli.m223.model.Booking;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class BookingServiceTest {

    @Inject
    BookingService bookingService;



  

    @Test
    public void testGetAllBookings() {
    
        List<Booking> bookings = bookingService.getAllBookings();

        assertNotNull(bookings);
    }
}
