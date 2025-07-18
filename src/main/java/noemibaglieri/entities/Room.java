package noemibaglieri.entities;

import jakarta.persistence.*;
import lombok.*;
import noemibaglieri.enums.RoomType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String descriptiong;

    @Column(name = "room_type", nullable = false)
    private RoomType roomType;

    @Column(name = "max_capacity", nullable = false)
    private int maxCapacity;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings = new ArrayList<>();

    public Room(String descriptiong, RoomType roomType, int maxCapacity, Building building) {
        this.descriptiong = descriptiong;
        this.roomType = roomType;
        this.maxCapacity = maxCapacity;
        this.building = building;
    }
}
