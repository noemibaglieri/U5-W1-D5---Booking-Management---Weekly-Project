package noemibaglieri.repositories;

import noemibaglieri.entities.Room;
import noemibaglieri.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Room, Long> {
    List<Room> findByTypeAndBuilding_City(RoomType type, String city);
}
