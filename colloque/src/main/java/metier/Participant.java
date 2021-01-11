package metier;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Participant")
public class Participant{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "num_personne")
    private long numPers;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "date_naissance")
    private Date date_naiss;

    @Column(name = "organisation")
    private String organisation;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "num_personne",orphanRemoval= true)
    @OrderColumn(name = "idO")
    private List<String> observations;

    public Participant(String nom, String prenom, String email, Date date_naiss, String organisation, List<String> observations) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
    }


}