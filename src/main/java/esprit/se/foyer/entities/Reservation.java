package esprit.se.foyer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Reservation")
public class Reservation implements Serializable {
    @Id
    @Column(name="idReservation")
    private String idReservation; // Clé primaire
    private Boolean estValide;

    @Temporal(TemporalType.DATE)
    private Date anneUniversitaire;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy="reservation")
    private Set<Etudient> etudiant ;
}
