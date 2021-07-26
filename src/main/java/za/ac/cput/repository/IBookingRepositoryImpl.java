package za.ac.cput.repository;

import za.ac.cput.entity.Booking;

import java.util.HashSet;
import java.util.Set;

public class IBookingRepositoryImpl implements IBookingRepository {

    private static IBookingRepositoryImpl repository = null;
    private Set<Booking> bookingDB = null;

    public IBookingRepositoryImpl() {
        bookingDB = new HashSet<Booking>();
    }

    public static IBookingRepositoryImpl getRepository(){
        if(repository == null){
            repository = new IBookingRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Set<Booking> getAll() {
        return null;
    }

    @Override
    public Booking create(Booking booking) {
        return null;
    }

    @Override
    public Booking read(String s) {
        return null;
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
