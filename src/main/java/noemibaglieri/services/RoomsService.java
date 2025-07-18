package noemibaglieri.services;

import lombok.extern.slf4j.Slf4j;
import noemibaglieri.entities.Building;
import noemibaglieri.entities.Room;
import noemibaglieri.enums.RoomType;
import noemibaglieri.exceptions.NotFoundException;
import noemibaglieri.exceptions.ValidationException;
import noemibaglieri.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoomsService {
    @Autowired
    private RoomsRepository roomsRepository;

    public void saveRoom(Room newRoom) {

        if (roomsRepository.existsByTypeAndBuilding(newRoom.getType(), newRoom.getBuilding())) {
            throw new ValidationException("Room * " + newRoom.getType() + " already exists in this building.");
        }

        roomsRepository.save(newRoom);
        log.info("Room * " + newRoom.getType() + " * saved successfully in building * " + newRoom.getBuilding());
    }

    public List<Room> findAll() {
        return roomsRepository.findAll();
    }

    public Room findById(long roomId) {
        return roomsRepository.findById(roomId).orElseThrow(() -> new NotFoundException(roomId));
    }

    public List<Room> findByMaxCapacityAndBuilding(int maxCapacity, Building building) {
        return roomsRepository.findByMaxCapacityAndBuilding(maxCapacity, building);
    }

    public void findByIdAndUpdate(long roomId, Room updatedRoom) {
        Room found = this.findById(roomId);

        found.setDescription(updatedRoom.getDescription());
        found.setType(updatedRoom.getType());
        found.setBuilding(updatedRoom.getBuilding());
        found.setMaxCapacity(updatedRoom.getMaxCapacity());

        roomsRepository.save(found);
        log.info("Room with ID * " + roomId + " * updated successfully.");
    }

    public void findByIdAndDelete(long roomId) {
        Room found = this.findById(roomId);
        roomsRepository.delete(found);
        log.info("Room with ID * " + roomId + " * deleted successfully.");
    }

    public List<Room> findByTypeAndCity(RoomType type, String city) {
        return roomsRepository.findByTypeAndBuilding_City(type, city);
    }
}

