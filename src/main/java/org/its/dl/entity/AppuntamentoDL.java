package org.its.dl.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appuntamento")
public class AppuntamentoDL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "idUtente")
    private int idUtente;

    @Column(name = "dataInizio")
    private Date dataInizio;

    @Column(name = "dataFine")
    private Date dataFine;

    @Column(name = "idUtenteToMeet")
    private int idUtenteToMeet;

    public AppuntamentoDL(int id,int idUtente, Date dataInizio, Date dataFine, int idUtenteToMeet) {
        this.id = id;
        this.idUtente = idUtente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.idUtenteToMeet = idUtenteToMeet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public int getIdUtenteToMeet() {
        return idUtenteToMeet;
    }

    public void setIdUtenteToMeet(int idUtenteToMeet) {
        this.idUtenteToMeet = idUtenteToMeet;
    }
}
