package noemibaglieri.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "building_id")
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Room> rooms = new ArrayList<>();

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
