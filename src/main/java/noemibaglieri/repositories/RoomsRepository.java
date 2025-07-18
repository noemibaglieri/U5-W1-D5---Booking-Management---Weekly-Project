package noemibaglieri.repositories;

import noemibaglieri.entities.Building;
import noemibaglieri.entities.Room;
import noemibaglieri.enums.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomsRepository extends JpaRepository<Room, Long> {
    List<Room> findByTypeAndBuilding_City(RoomType type, String city);
    List<Room> findByMaxCapacityAndBuilding(int maxCapacity, Building building);
    boolean existsByTypeAndBuilding(RoomType type, Building building);
}
