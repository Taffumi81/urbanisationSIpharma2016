/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author achevann
 */
@Entity
public class Admission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int IEP;

    @Column
    private int IPP;
    
    @Column
    private String nomPatient;
    
    @Column
    private String prenomPatient;

    /*Getter & Setter*/
    
    public void setPrenomPatient(String prenomPatient) {    
        this.prenomPatient = prenomPatient;
    }
    
     public int getIEP() {
        return IEP;
    }

    public void setIEP(int IEP) {
        this.IEP = IEP;
    }

    public int getIPP() {
        return IPP;
    }

    public void setIPP(int IPP) {
        this.IPP = IPP;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public int getId() {
        return IEP;
    }

    public void setId(int id) {
        this.IEP = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.IEP;
        hash = 17 * hash + this.IPP;
        hash = 17 * hash + Objects.hashCode(this.nomPatient);
        hash = 17 * hash + Objects.hashCode(this.prenomPatient);
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
        final Admission other = (Admission) obj;
        if (this.IEP != other.IEP) {
            return false;
        }
        if (this.IPP != other.IPP) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Admission{" + "IEP=" + IEP + ", IPP=" + IPP + ", nomPatient=" + nomPatient + ", prenomPatient=" + prenomPatient + '}';
    }

}
