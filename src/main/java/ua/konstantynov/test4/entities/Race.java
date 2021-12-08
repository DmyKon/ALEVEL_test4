package ua.konstantynov.test4.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_race")
    private Long identifier;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "horses_number")
    private int horseCount;

    @Column(name = "betting_on")
    private int horseNumber;

    @OneToMany(mappedBy = "race", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Horse> horses;
}
