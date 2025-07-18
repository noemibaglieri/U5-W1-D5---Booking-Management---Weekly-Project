package noemibaglieri.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "booking_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Booking(User user, LocalDate date, Room room) {
        this.user = user;
        this.date = date;
        this.room = room;
    }
}
