package noemibaglieri.runners;

import noemibaglieri.entities.Building;
import noemibaglieri.entities.Room;
import noemibaglieri.enums.RoomType;
import noemibaglieri.services.BuildingsService;
import noemibaglieri.services.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomsRunner implements CommandLineRunner {
    @Autowired
    private RoomsService roomsService;

    @Autowired
    private BuildingsService buildingsService;

    @Override
    public void run(String... args) throws Exception {
        try {

            Building innovationHub = buildingsService.findByName("Innovation Hub");
            roomsService.saveRoom(new Room("Sala Navigli", RoomType.MEETING_ROOM, 12, innovationHub));
            roomsService.saveRoom(new Room("Privata Duomo", RoomType.PRIVATE, 4, innovationHub));

            Building techDistrict = buildingsService.findByName("Tech District");
            roomsService.saveRoom(new Room("Sala Colosseo", RoomType.MEETING_ROOM, 10, techDistrict));
            roomsService.saveRoom(new Room("OpenSpace Trastevere", RoomType.OPENSPACE, 20, techDistrict));

            Building greenTower = buildingsService.findByName("Green Tower");
            roomsService.saveRoom(new Room("Sala Nettuno", RoomType.MEETING_ROOM, 14, greenTower));
            roomsService.saveRoom(new Room("Privata Marconi", RoomType.PRIVATE, 3, greenTower));

            Building skyBusiness = buildingsService.findByName("Sky Business Center");
            roomsService.saveRoom(new Room("Sala Vesuvio", RoomType.MEETING_ROOM, 15, skyBusiness));
            roomsService.saveRoom(new Room("OpenSpace Vomero", RoomType.OPENSPACE, 22, skyBusiness));

            Building digitalPoint = buildingsService.findByName("Digital Point");
            roomsService.saveRoom(new Room("Sala Savoia", RoomType.MEETING_ROOM, 9, digitalPoint));
            roomsService.saveRoom(new Room("Privata Gran Madre", RoomType.PRIVATE, 2, digitalPoint));

            Building futureLab = buildingsService.findByName("Future Lab");
            roomsService.saveRoom(new Room("Sala Rinascimento", RoomType.MEETING_ROOM, 13, futureLab));
            roomsService.saveRoom(new Room("OpenSpace Arno", RoomType.OPENSPACE, 18, futureLab));

            Building workSpaceOne = buildingsService.findByName("WorkSpace One");
            roomsService.saveRoom(new Room("Sala Porto Antico", RoomType.MEETING_ROOM, 11, workSpaceOne));
            roomsService.saveRoom(new Room("Privata Lanterna", RoomType.PRIVATE, 3, workSpaceOne));

            Building smartOffices = buildingsService.findByName("Smart Offices");
            roomsService.saveRoom(new Room("Sala Mediterranea", RoomType.MEETING_ROOM, 10, smartOffices));
            roomsService.saveRoom(new Room("OpenSpace Kalsa", RoomType.OPENSPACE, 20, smartOffices));

            Building alphaCenter = buildingsService.findByName("Alpha Center");
            roomsService.saveRoom(new Room("Sala Brera", RoomType.MEETING_ROOM, 8, alphaCenter));
            roomsService.saveRoom(new Room("Privata Sempione", RoomType.PRIVATE, 2, alphaCenter));

            Building betaTower = buildingsService.findByName("Beta Tower");
            roomsService.saveRoom(new Room("Sala Palatino", RoomType.MEETING_ROOM, 12, betaTower));
            roomsService.saveRoom(new Room("OpenSpace Aventino", RoomType.OPENSPACE, 24, betaTower));

            Building campus2 = buildingsService.findByName("Campus 2");
            roomsService.saveRoom(new Room("Sala Università", RoomType.MEETING_ROOM, 16, campus2));
            roomsService.saveRoom(new Room("Privata Accademia", RoomType.PRIVATE, 4, campus2));

            Building mediterraneo = buildingsService.findByName("Mediterraneo");
            roomsService.saveRoom(new Room("Sala Posillipo", RoomType.MEETING_ROOM, 9, mediterraneo));
            roomsService.saveRoom(new Room("OpenSpace Mergellina", RoomType.OPENSPACE, 17, mediterraneo));

            Building poloDigitale = buildingsService.findByName("Polo Digitale");
            roomsService.saveRoom(new Room("Sala Cloud", RoomType.MEETING_ROOM, 14, poloDigitale));
            roomsService.saveRoom(new Room("Privata Algoritmo", RoomType.PRIVATE, 5, poloDigitale));

            Building florenceTech = buildingsService.findByName("Florence Tech");
            roomsService.saveRoom(new Room("Sala Medici", RoomType.MEETING_ROOM, 11, florenceTech));
            roomsService.saveRoom(new Room("OpenSpace Ponte Vecchio", RoomType.OPENSPACE, 19, florenceTech));

            Building lanternaHub = buildingsService.findByName("Lanterna Hub");
            roomsService.saveRoom(new Room("Sala Porto", RoomType.MEETING_ROOM, 13, lanternaHub));
            roomsService.saveRoom(new Room("Privata Genovese", RoomType.PRIVATE, 3, lanternaHub));

            Building siciliaCenter = buildingsService.findByName("Sicilia Center");
            roomsService.saveRoom(new Room("Sala Trinacria", RoomType.MEETING_ROOM, 12, siciliaCenter));
            roomsService.saveRoom(new Room("OpenSpace Normanni", RoomType.OPENSPACE, 21, siciliaCenter));

        } catch (Exception e) {
            System.out.println("[RoomsRunner] " + e.getMessage());
        }
    }
}
