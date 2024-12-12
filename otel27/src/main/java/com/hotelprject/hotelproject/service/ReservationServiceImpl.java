package com.hotelprject.hotelproject.service;
import com.hotelprject.hotelproject.controller.ReservationController;
import com.hotelprject.hotelproject.model.Reservation;
import com.hotelprject.hotelproject.model.Room;
import com.hotelprject.hotelproject.repository.ReservationRepository;
import com.hotelprject.hotelproject.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }
    @Override
    public Reservation makeReservation(Long roomId, LocalDate reservationDate, LocalDate endDate, String user) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + roomId));
        room.setAvailable(false);
        roomRepository.save(room);
        Reservation reservation = new Reservation();
        reservation.setRoom(room);
        reservation.setReservationDate(reservationDate);
        reservation.setEndDate(endDate);
        reservation.setUserInfo(user);
        reservation.setStatus("ONAYLANDI");
        return reservationRepository.save(reservation);
    }

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }
}