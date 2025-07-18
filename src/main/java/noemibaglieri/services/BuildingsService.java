package noemibaglieri.services;

import lombok.extern.slf4j.Slf4j;
import noemibaglieri.entities.Building;
import noemibaglieri.exceptions.NotFoundException;
import noemibaglieri.exceptions.ValidationException;
import noemibaglieri.repositories.BuildingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BuildingsService {
    @Autowired
    private BuildingsRepository buildingsRepository;

    public void saveBuilding(Building newBuilding) {

        if(buildingsRepository.existsByNameAndCity(newBuilding.getName(), newBuilding.getCity())) throw new ValidationException("A building with name * " + newBuilding.getName() + " * already exists in " + newBuilding.getCity());

        buildingsRepository.save(newBuilding);
        log.info("Building * " + newBuilding.getName() + " * successfully added.");

    }

    public List<Building> findAll() {
        return buildingsRepository.findAll();
    }

    public Building findById(long buildingId) {
        return buildingsRepository.findById(buildingId).orElseThrow(() -> new NotFoundException(buildingId));
    }

    public Building findByName(String name) {
        return buildingsRepository.findByName(name).orElseThrow(() -> new NotFoundException(name));
    }

    public void findByIdAndUpdate(long buildingId, Building updatedBuilding) {
        Building found = this.findById(buildingId);

        found.setName(updatedBuilding.getName());
        found.setAddress(updatedBuilding.getAddress());
        found.setCity(updatedBuilding.getCity());

        buildingsRepository.save(found);
        log.info("Building with ID * " + buildingId + " * successfully updated.");
    }

    public void findByIdAndDelete(long buildingId) {
        Building found = this.findById(buildingId);
        buildingsRepository.delete(found);
        log.info("Building with ID * " + buildingId + " * successfully deleted.");
    }
}
