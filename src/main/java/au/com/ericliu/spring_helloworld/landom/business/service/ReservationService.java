package au.com.ericliu.spring_helloworld.landom.business.service;

import au.com.ericliu.spring_helloworld.landom.business.domain.RoomReservation;
import au.com.ericliu.spring_helloworld.landom.data.entity.Guest;
import au.com.ericliu.spring_helloworld.landom.data.entity.Reservation;
import au.com.ericliu.spring_helloworld.landom.data.entity.Room;
import au.com.ericliu.spring_helloworld.landom.data.repository.GuestRepository;
import au.com.ericliu.spring_helloworld.landom.data.repository.ReservationRepository;
import au.com.ericliu.spring_helloworld.landom.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ericliu on 29/6/17.
 */

@Service
public class ReservationService {

    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(final RoomRepository roomRepository, final GuestRepository guestRepository, final ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }


    public List<RoomReservation> getRoomReservations(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = reservationRepository.findByDate(new java.sql.Date(date.getTime()));
        if (reservations != null) {
            reservations.forEach(reservation -> {
                Guest guest = guestRepository.findOne(reservation.getGuestId());
                if (guest != null) {
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    roomReservation.setGuestId(guest.getId());
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                }
            });
        }

        final List<RoomReservation> roomReservations = new ArrayList<>();
        roomReservationMap.forEach(
                (k, v) -> roomReservations.add(v)
        );
        return roomReservations;
    }

}
