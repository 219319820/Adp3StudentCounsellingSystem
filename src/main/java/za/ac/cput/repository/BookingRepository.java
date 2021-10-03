package za.ac.cput.repository;

import za.ac.cput.entity.Booking;

import java.util.HashSet;
import java.util.Set;

public class BookingRepository implements IBookingRepository {

    private static BookingRepository repository = null;
    private Set<Booking> bookingDB = null;       //data structure as our data store

    public BookingRepository() {
        bookingDB = new HashSet<Booking>();
    }

    public static BookingRepository getRepository(){
        if(repository == null)
        {
            repository = new BookingRepository();
        }
        return repository;
    }

    @Override
    public Booking create(Booking booking) {
        boolean success = bookingDB.add(booking);
        if(!success){
            return null;
        }
        return booking;
    }

    @Override
    public Booking read(String bookingId) {
        for(Booking b : bookingDB){
            /**if(b.getUserId().equals(bookingId)){
                return b;
            }**/
        }
        return null;
    }

    @Override
    public Booking update(Booking booking) {
        Booking oldBooking = read(booking.getUserId());
        if(oldBooking != null){
            bookingDB.remove(oldBooking);
            bookingDB.add(booking);
            return booking;
        }

        return null;
    }

    @Override
    public boolean delete(String bookingId) {
        Booking bookingToDelete = read(bookingId);
        if(bookingToDelete == null){
            return false;
        }
        return true;
    }

    @Override
    public Set<Booking> getAll() {
        return bookingDB;
    }
}
