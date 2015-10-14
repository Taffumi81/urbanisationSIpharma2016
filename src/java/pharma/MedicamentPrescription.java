/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author achevann
 */
@Entity
public class MedicamentPrescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMedPresc;

    @ManyToOne
    private Medicament medPresc;
    
    @Column
    private int quantite;
    
    
    /*Getter & Setter*/

    public int getIdMedPresc() {
        return idMedPresc;
    }

    public void setIdMedPresc(int idMedPresc) {
        this.idMedPresc = idMedPresc;
    }

    public Medicament getMedPresc() {
        return medPresc;
    }

    public void setMedPresc(Medicament medPresc) {
        this.medPresc = medPresc;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idMedPresc;
        hash = 37 * hash + Objects.hashCode(this.medPresc);
        hash = 37 * hash + this.quantite;
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
        final MedicamentPrescription other = (MedicamentPrescription) obj;
        if (this.idMedPresc != other.idMedPresc) {
            return false;
        }
        if (!Objects.equals(this.medPresc, other.medPresc)) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicament prescrit n°" + idMedPresc + ", medPresc=" + medPresc + ", quantite=" + quantite + '\n';
    }
}
