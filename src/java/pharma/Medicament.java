/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author achevann
 */
@Entity
@XmlRootElement
public class Medicament implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String nomMed;
    
    @Column
    private String administrationMed;
    
    @Column
    private int stockMed;
    
    /*Getter et setter*/
    public String getNomMed() {
        return nomMed;
    }

    public void setNomMed(String nomMed) {
        this.nomMed = nomMed;
    }

    public String getAdministrationMed() {
        return administrationMed;
    }

    public void setAdministrationMed(String administrationMed) {
        this.administrationMed = administrationMed;
    }

    public int getStockMed() {
        return stockMed;
    }

    public void setStockMed(int stockMed) {
        this.stockMed = stockMed;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicament)) {
            return false;
        }
        Medicament other = (Medicament) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bureau.Medicament[ id=" + id + " ]";
    }
    
}
