package org.its.dl.entity;

import javax.persistence.*;

@Entity
@Table(name = "utente")
public class UtenteDL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "enabled")
    private boolean enabled;

    public UtenteDL(int id, String name,boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
    }

    public  UtenteDL(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
