package com.insaship.enterprise1.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Franck-Gravouil on 17/11/2016.
 */
@Entity
@Table(name = "offers")
public class OfferEntity implements Serializable {

    public static final long serialVersionUID = 12348798760L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOffers;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private int available;

    @NotNull
    private Date startDate;

    @NotNull
    private Date expirationDate;

    public OfferEntity() {
    }

    public OfferEntity(int id, String title, String description, int available, Date startDate, Date expirationDate) {
        this.idOffers = id;
        this.title = title;
        this.description = description;
        this.available = available;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return idOffers;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailable() {
        return available;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
