package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

public class BookingService {

    public List<Booking> getAllBookings() {
        return null;
    }
    @ApplicationScoped
    @Inject
    EntityManager entityManager;

    @Transactional
    public Booking createBooking(Booking booking) {
        return entityManager.merge(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking booking) {
        booking.setId(id);
        return entityManager.merge(booking);
    }

 public List<Booking> findAll() {
     var query = entityManager.createQuery("FROM Category", Booking.class);
    return query.getResultList();
    }
    

    public Booking getBookingById(Long id) {
        return null;
    }


}
