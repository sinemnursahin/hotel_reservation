package com.hotelprject.hotelproject.service;

import com.hotelprject.hotelproject.model.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    Reservation makeReservation(Long roomId, LocalDate reservationDate, LocalDate endDate, String user);
    List<Reservation> findAllReservations();
}
