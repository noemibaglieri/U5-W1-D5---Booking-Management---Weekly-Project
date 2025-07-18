package noemibaglieri.runners;

import noemibaglieri.entities.Booking;
import noemibaglieri.services.BookingsService;
import noemibaglieri.services.RoomsService;
import noemibaglieri.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class BookingsRunner implements CommandLineRunner {

    @Autowired
    private BookingsService bookingsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private RoomsService roomsService;

    @Override
    public void run(String... args) throws Exception {
        /*
    }
        bookingsService.saveBooking(new Booking(
                usersService.findById(1),
                LocalDate.of(2025, 7, 19),
                roomsService.findById(3)
        ));

        bookingsService.saveBooking(new Booking(
                usersService.findById(2),
                LocalDate.of(2025, 7, 20),
                roomsService.findById(5)
        ));

        bookingsService.saveBooking(new Booking(
                usersService.findById(3),
                LocalDate.of(2025, 7, 21),
                roomsService.findById(6)
        ));

        bookingsService.saveBooking(new Booking(
                usersService.findById(4),
                LocalDate.of(2025, 7, 23),
                roomsService.findById(13)
        ));

        // lo stesso utente 1 prenota una stanza per un giorno diverso
        bookingsService.saveBooking(new Booking(
                usersService.findById(1),
                LocalDate.of(2025,7, 28),
                roomsService.findById(31)
        ));

        bookingsService.saveBooking(new Booking(
                usersService.findById(1),
                LocalDate.of(2025, 7, 22),
                roomsService.findById(9)
        ));

        // lo stesso utente 1 prova a prenotare un'altra stanza lo stesso giorno
        bookingsService.saveBooking(new Booking(
                usersService.findById(1),
                LocalDate.of(2025, 7, 22),
                roomsService.findById(10)
        ));

      */

        // controlla i bookings di una data specifica
        bookingsService.findByDate(LocalDate.of(2025, 7, 22))
                .forEach(System.out::println);

        // controlla i bookings di un utente e una data
        List<Booking> bookings = bookingsService.findByUserAndDate(usersService.findByUsername("esantoro"), LocalDate.of(2025, 7,22));
        System.out.println(bookings);

    }
}


