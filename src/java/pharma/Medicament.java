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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Medicament> interactionsMedic;
    
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

    public List<Medicament> getListInteractionsMedic() {
        return interactionsMedic;
    }

    public void setListInteractionsMedic(List<Medicament> interactionsMedic) {
        this.interactionsMedic = interactionsMedic;
    }
    
    public void addInteractionMedic (Medicament m) {
        this.interactionsMedic.add(m);
    }
    
    public void delInteractionMedic (Medicament m) {
        if(this.interactionsMedic.contains(m)) {
            this.interactionsMedic.remove(m);
        }
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nomMed);
        hash = 47 * hash + Objects.hashCode(this.administrationMed);
        hash = 47 * hash + this.stockMed;
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
        final Medicament other = (Medicament) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nomMed, other.nomMed)) {
            return false;
        }
        if (!Objects.equals(this.administrationMed, other.administrationMed)) {
            return false;
        }
        if (this.stockMed != other.stockMed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicament{" + "id=" + id + ", nomMed=" + nomMed + ", administrationMed=" + administrationMed + ", stockMed=" + stockMed + '}';
    }

    
}
