/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tajine
 */
@Table(name="EmployeTache")
@Entity
public class EmployeTache {
@EmbeddedId
    private EmployeTachePk emp;
    @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;
    @Temporal(TemporalType.DATE)
    private Date dateFinReelle;
    @ManyToOne
    @JoinColumn(name="employe",insertable=false,updatable=false)
    private Employe employe;
    @ManyToOne
    @JoinColumn(name="tache",insertable=false,updatable=false)
    private Tache tache;

    public EmployeTache() {
    }

    public EmployeTache(Employe employe, Tache tache,Date dateDebutReelle, Date dateFinReelle) {
        this.employe = employe;
        this.tache = tache;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        
    }

    public EmployeTache(EmployeTachePk emp,Employe employe, Tache tache, Date dateDebutReelle, Date dateFinReelle ) {
        this.emp = emp;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
    }

    public EmployeTachePk getEmp() {
        return emp;
    }

    public void setEmp(EmployeTachePk emp) {
        this.emp = emp;
    }
    

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
    

}
