package org.models.core.impl;

import org.models.core.dao.BookingRepository;
import org.models.core.domain.Booking;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepoImpl  implements BookingRepository {
    @Override
    public Boolean save(String vehicleId, Booking booking) {
        return false;
    }

    @Override
    public List<Booking> getAllBookingsById(String vehicleId) {
        return null;
    }
}
