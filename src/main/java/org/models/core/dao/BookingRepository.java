package org.models.core.dao;

import org.models.core.domain.Booking;

import java.util.List;

public interface BookingRepository {

    Boolean save(String vehicleId, Booking booking);
    List<Booking> getAllBookingsById(String vehicleId);


}
