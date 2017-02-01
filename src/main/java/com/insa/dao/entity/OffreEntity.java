package com.insa.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
/**
 * Created by Franck-Gravouil on 17/11/2016.
 */
@Entity
@NamedNativeQuery(name = "OffreEntity.findOfferByKeyWord", query = "SELECT * FROM offers o WHERE " +
        "(LOWER(o.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
        "LOWER(o.description) LIKE LOWER(CONCAT('%',:searchTerm, '%')))" +
        "AND (o.available)=1" , resultClass = OffreEntity.class)
@Table(name = "offers")
public class OffreEntity implements Serializable {

    public static final long serialVersionUID = 12348798760L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOffers")
    private int id;

    @NotNull
    @Column(name = "title")
    private String titre;

    @NotNull
    @Column(name = "description")
    private String contenu;

    @NotNull
    @Column(name = "startdate")
    private String dateDebut;

    public OffreEntity() {
    }

    public OffreEntity(int id, String title, String description, String dateDebut) {
        this.id = id;
        this.titre = title;
        this.contenu = description;
        this.dateDebut = dateDebut;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDateDebut() { return dateDebut; }
}
