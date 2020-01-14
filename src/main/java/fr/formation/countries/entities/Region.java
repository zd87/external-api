package fr.formation.countries.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Region extends AbstractId {

    @Column(length = 45, nullable = false, unique = true)
    private String name;

    public Region() {
    }

    public Region(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
