package noemibaglieri.repositories;

import noemibaglieri.entities.Booking;
import noemibaglieri.entities.Room;
import noemibaglieri.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {
    boolean existsByUserAndDate(User user, LocalDate date);
    boolean existsByRoomAndDate(Room room, LocalDate date);
}
