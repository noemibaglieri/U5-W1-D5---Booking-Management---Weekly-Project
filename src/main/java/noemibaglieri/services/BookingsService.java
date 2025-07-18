package noemibaglieri.services;

import lombok.extern.slf4j.Slf4j;
import noemibaglieri.entities.Booking;
import noemibaglieri.entities.Room;
import noemibaglieri.entities.User;
import noemibaglieri.exceptions.NotFoundException;
import noemibaglieri.exceptions.ValidationException;
import noemibaglieri.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;

    public void saveBooking(Booking booking) {
        Room room = booking.getRoom();
        User user = booking.getUser();
        LocalDate date = booking.getDate();

        if (bookingsRepository.existsByRoomAndDate(room, date)) {
            throw new ValidationException("Room * " + room.getId() + " * is already booked on " + date);
        }

        if (bookingsRepository.existsByUserAndDate(user, date)) {
            throw new ValidationException("User * " + user.getUsername() + " * already has a booking on * " + date + " *");
        }

        bookingsRepository.save(booking);
        log.info("Booking saved for user * " + user.getUsername() + " * in room * " + room.getId() + " * on date * " + date + " *");
    }

    public List<Booking> findAll() {
        return bookingsRepository.findAll();
    }

    public Booking findById(long id) {
        return bookingsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking with ID " + id + " not found"));
    }

    public List<Booking> findByDate(LocalDate date) {
        List<Booking> bookings = bookingsRepository.findByDate(date);
        if (bookings.isEmpty()) {
            throw new NotFoundException("No bookings were made for this date * " + date);
        }
        return bookings;
    }

    public List<Booking> findByUserAndDate(User user, LocalDate date) {

        List<Booking> bookings = bookingsRepository.findByDate(date);
        if (bookings.isEmpty()) {
            throw new NotFoundException("No bookings were made by * " + user.getUsername() + " * for this date * " + date + " *");
        }

        return bookings;
    }

    public void deleteById(long id) {
        Booking found = findById(id);
        bookingsRepository.delete(found);
        log.info("Booking with ID * " + id + " * deleted");
    }
}
