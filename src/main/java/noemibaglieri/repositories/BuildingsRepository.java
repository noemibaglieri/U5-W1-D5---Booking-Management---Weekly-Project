package noemibaglieri.repositories;

import noemibaglieri.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingsRepository extends JpaRepository<Building, Long> {
    List<Building> findByCity(String city);
    boolean existsByNameAndCity(String name, String city);
    Optional<Building> findByName(String name);
}
