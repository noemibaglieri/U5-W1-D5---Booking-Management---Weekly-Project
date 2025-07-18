package noemibaglieri.repositories;

import noemibaglieri.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingsRepository extends JpaRepository<Building, Long> {
    List<Building> findByCity(String city);
}
