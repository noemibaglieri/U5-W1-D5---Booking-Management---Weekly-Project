package noemibaglieri.runners;

import noemibaglieri.entities.Building;
import noemibaglieri.services.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BuildingsRunner implements CommandLineRunner {
    @Autowired
    private BuildingsService buildingsService;

    @Override
    public void run(String... args) throws Exception {
        try {
            buildingsService.saveBuilding(new Building("Innovation Hub", "Via Torino 12", "Milano"));
            buildingsService.saveBuilding(new Building("Tech District", "Viale Europa 55", "Roma"));
            buildingsService.saveBuilding(new Building("Green Tower", "Piazza Verdi 3", "Bologna"));
            buildingsService.saveBuilding(new Building("Sky Business Center", "Via del Mare 101", "Napoli"));
            buildingsService.saveBuilding(new Building("Digital Point", "Corso Francia 77", "Torino"));
            buildingsService.saveBuilding(new Building("Future Lab", "Via dei Mille 22", "Firenze"));
            buildingsService.saveBuilding(new Building("WorkSpace One", "Via Milano 18", "Genova"));
            buildingsService.saveBuilding(new Building("Smart Offices", "Via Libertà 88", "Palermo"));
            buildingsService.saveBuilding(new Building("Alpha Center", "Via Roma 45", "Milano"));
            buildingsService.saveBuilding(new Building("Beta Tower", "Via Appia 200", "Roma"));
            buildingsService.saveBuilding(new Building("Campus 2", "Via Zamboni 16", "Bologna"));
            buildingsService.saveBuilding(new Building("Mediterraneo", "Via Posillipo 75", "Napoli"));
            buildingsService.saveBuilding(new Building("Polo Digitale", "Via XX Settembre 23", "Torino"));
            buildingsService.saveBuilding(new Building("Florence Tech", "Viale Michelangelo 9", "Firenze"));
            buildingsService.saveBuilding(new Building("Lanterna Hub", "Via San Lorenzo 11", "Genova"));
            buildingsService.saveBuilding(new Building("Sicilia Center", "Via Maqueda 90", "Palermo"));

        } catch (Exception e) {
            System.out.println("[BuildingsRunner] " + e.getMessage());
        }
    }
}