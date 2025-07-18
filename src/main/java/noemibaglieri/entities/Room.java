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
@ToString(exclude = "bookings")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;

    private String description;

    @Column(name = "room_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(name = "max_capacity", nullable = false)
    private int maxCapacity;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings = new ArrayList<>();

    public Room(String description, RoomType roomType, int maxCapacity, Building building) {
        this.description = description;
        this.type = roomType;
        this.maxCapacity = maxCapacity;
        this.building = building;
    }
}
