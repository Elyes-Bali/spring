package esprit.se.foyer.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBloc")
    private Long idBloc; // Clé primaire
    private String nomBloc;
    private Long CapBloc;
    @ManyToOne(cascade = CascadeType.ALL)
    Foyer foyer;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bloc" , fetch = FetchType.EAGER)
    private Set<Chambre> chambre;
}
