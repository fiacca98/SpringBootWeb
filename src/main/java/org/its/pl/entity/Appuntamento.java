package org.its.pl.entity;

import java.util.Date;

public class Appuntamento {
    private int id;
    private int idUtente;
    private Date dataInizio;
    private Date dataFine;
    private int idUtenteToMeet;

    public Appuntamento(int id, int idUtente, Date dataInizio, Date dataFine, int idUtenteToMeet) {
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
