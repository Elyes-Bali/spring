package esprit.se.foyer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id

    @Column(name="idUniversite")
    private Long idUniversite; // Clé primaire
    private String nomUniversite;
    private String adress;
    @OneToOne(mappedBy="universite")
    private Foyer foyer;
}
