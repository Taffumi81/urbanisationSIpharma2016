/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
/**
 *
 * @author achevannjkl jkl
 */
public class ServicesPharma {
    
    EntityManagerFactory fact;
    
    public ServicesPharma(EntityManagerFactory fact) {
        this.fact = fact;
    }
    
    public Medicament newMedicament(String nomMed , String adminMed , int stockMedInit) {
        Medicament m = new Medicament();
        m.setNomMed(nomMed);
        m.setAdministrationMed(adminMed);
        m.setStockMed(stockMedInit);
        EntityManager em = fact.createEntityManager();
	em.getTransaction( ).begin( );
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        return m;
    }
    
    public List<Medicament> consultStock() {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m", Medicament.class);
        List<Medicament> res = query.getResultList();
        em.close();
        return res;
    }
}
