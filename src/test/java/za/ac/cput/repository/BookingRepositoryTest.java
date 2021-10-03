package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class BookingRepositoryTest {
    private static BookingRepository repository = BookingRepository.getRepository();
    private static Booking booking = BookingFactory.createBooking("Date and time slot booking", "09:00",
            "14 June 2021", "District 6", "30 minutes");

    @Test
    void a_create(){
        Booking created = repository.create(booking);
        assertEquals(created.getUserId(), booking.getUserId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read(){
        Booking read = repository.read(booking.getUserId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update(){
        Booking updated = new Booking.Builder().copy(booking).setLocation("Cape Town").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(booking.getUserId());
        assertTrue(success);
        System.out.println("Delete: "+ success);
    }

    @Test
    void e_getAll(){
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}