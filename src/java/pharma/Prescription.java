/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author achevann
 */
@Entity
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPresc;
    
    @Column
    private String nomUF;
    
    @Column
    private Etat etat;
    
    @Column
    private String preparateur;

    @Column
    private String datePresc;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<MedicamentPrescription> medicamentsPresc;

    
    /*Getter & Setter*/
    
    public int getIdPresc() {
        return idPresc;
    }

    public void setIdPresc(int idPresc) {
        this.idPresc = idPresc;
    }

    public String getNomUF() {
        return nomUF;
    }

    public void setNomUF(String nomUF) {
        this.nomUF = nomUF;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getPreparateur() {
        return preparateur;
    }

    public void setPreparateur(String preparateur) {
        this.preparateur = preparateur;
    }

    public String getDatePresc() {
        return datePresc;
    }

    public void setDatePresc(String datePresc) {
        this.datePresc = datePresc;
    }

    public List<MedicamentPrescription> getMedicamentsPresc() {
        return medicamentsPresc;
    }

    public void setMedicamentsPresc(List<MedicamentPrescription> medicamentsPresc) {
        this.medicamentsPresc = medicamentsPresc;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.idPresc;
        hash = 31 * hash + Objects.hashCode(this.nomUF);
        hash = 31 * hash + Objects.hashCode(this.etat);
        hash = 31 * hash + Objects.hashCode(this.preparateur);
        hash = 31 * hash + Objects.hashCode(this.datePresc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prescription other = (Prescription) obj;
        if (this.idPresc != other.idPresc) {
            return false;
        }
        if (!Objects.equals(this.nomUF, other.nomUF)) {
            return false;
        }
        if (this.etat != other.etat) {
            return false;
        }
        if (!Objects.equals(this.preparateur, other.preparateur)) {
            return false;
        }
        if (!Objects.equals(this.datePresc, other.datePresc)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prescription{" + "idPresc=" + idPresc + ", nomUF=" + nomUF + ", etat=" + etat + ", preparateur=" + preparateur + ", datePresc=" + datePresc + '}';
    }
    
    
    
    
    
}
