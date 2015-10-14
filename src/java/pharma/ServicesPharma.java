/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import java.util.ArrayList;
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
    
    /*Medicaments*/
    
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
    
    public void deleteAllMedicaments() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Medicament").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    /*Admission*/
    
    public Admission newAdmission(int IEP , int IPP , String nom , String prenom) {
        Admission a = new Admission();
        
        a.setIEP(IEP);
        a.setIPP(IPP);
        a.setNomPatient(nom);
        a.setPrenomPatient(prenom);  
        EntityManager em = fact.createEntityManager();
	em.getTransaction( ).begin( );
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        return a;
    }
    
    public List<Admission> getAllAdmission() {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a", Admission.class);
        List<Admission> res = query.getResultList();
        em.close();
        return res;
    }
    
    public void deleteAllAdmission() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public Admission getAdmissionByIEP (int IEP) {
        EntityManager em = fact.createEntityManager();
	Admission res = em.find( Admission.class, IEP );
        em.close();
        return res;
    }
    
    public List<Admission> getAdmissionByIPP (int IPP) {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Admission> query;
        query = em.createQuery(
                "SELECT a FROM Admission a WHERE a.IPP LIKE :IPP ", Admission.class)
                .setParameter("IPP",IPP);
        List<Admission> res = query.getResultList();
        em.close();
        return res;
    }
    
    /*Prescription*/
    
    public Prescription newPrescription(String nomUF , String prep , String date, List<MedicamentPrescription> listMed, Admission admiP) {
        EntityManager em = fact.createEntityManager();
        Prescription p = new Prescription();
        
        p.setMedicamentsPresc(listMed);
        p.setNomUF(nomUF);
        p.setPreparateur(prep);
        p.setEtat(Etat.NonValide);
        p.setDatePresc(date);
        p.setAdmiPatient(admiP);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }
    
    public List<Prescription> getAllPrescription() {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p", Prescription.class);
        List<Prescription> res = query.getResultList();
        em.close();
        return res;
    }
    
    public void deleteAllPrescription() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Prescription").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public Prescription getPrescriptionByID (int id) {
        EntityManager em = fact.createEntityManager();
	Prescription res = em.find( Prescription.class, id );
        em.close();
        return res;
    }
    
    public void setEtatPrescription (Prescription p, Etat e) {
        EntityManager em = fact.createEntityManager();
        p.setEtat(e);
        em.getTransaction( ).begin( );
        em.merge(p);
        em.getTransaction().commit();
        em.close();
    }
    
    /*MedicamentPrescription*/
    
    public MedicamentPrescription newMedicamentPrescription(Medicament med , int q) {
        EntityManager em = fact.createEntityManager();
        MedicamentPrescription mp = new MedicamentPrescription();
        mp.setMedPresc(med);
        mp.setQuantite(q);
     
	em.getTransaction( ).begin( );
        em.persist(mp);
        em.getTransaction().commit();
        em.close();
        return mp;
    }
    
    public void deleteAllMedicamentPrescription() {
        EntityManager em = fact.createEntityManager();
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM MedicamentPrescription").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Prescription> consultWorklistPrep (String prep) {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Prescription> query;
        query = em.createQuery(
                "SELECT p FROM Prescription p WHERE p.preparateur LIKE :prepName ", Prescription.class)
                .setParameter("prepName",prep);
        List<Prescription> res = query.getResultList();
        em.close();
        return res;
    }
    
    public List<Prescription> consultPrescriptionByAdmission (Admission admiIEP) {
        EntityManager em = fact.createEntityManager();
	TypedQuery<Prescription> query;
        query = em.createQuery(
                "SELECT p FROM Prescription p WHERE p.AdmiPatient LIKE :admiIEP ", Prescription.class)
                .setParameter("admiIEP",admiIEP);
        List<Prescription> res = query.getResultList();
        em.close();
        return res;
    }
    
    
    public List<Prescription> consultPrescriptionByIEP (int IEP) {
        EntityManager em = fact.createEntityManager();
        Admission admiIEP = getAdmissionByIEP(IEP);
	TypedQuery<Prescription> query;
        query = em.createQuery(
                "SELECT p FROM Prescription p WHERE p.AdmiPatient LIKE :admiIEP ", Prescription.class)
                .setParameter("admiIEP",admiIEP);
        List<Prescription> res = query.getResultList();
        em.close();
        return res;
    }
    
    public List<Prescription> consultPrescriptionByIPP(int IPP) {
        ArrayList<Prescription> listPresc = new ArrayList();
        List<Admission> admiIPP = getAdmissionByIPP(IPP);
        for (Admission ad : admiIPP) {
            listPresc.addAll(consultPrescriptionByAdmission(ad));
        }
        return listPresc;
    }
}
