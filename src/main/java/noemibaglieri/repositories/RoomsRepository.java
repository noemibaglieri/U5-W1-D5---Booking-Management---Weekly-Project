package noemibaglieri.repositories;

import noemibaglieri.entities.Room;
import noemibaglieri.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Room, Long> {
    List<Room> findByTypeAndBuilding_City(RoomType type, String city);
}
