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
import javax.persistence.TypedQuery;
/**
 *
 * @author achevannjkl jkl
 */
public class ServicesPharma {
    
    EntityManagerFactory fact;
    EntityManager em;
    
    public ServicesPharma(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
    
    /*Medicaments*/
    
    public Medicament newMedicament(String nomMed , String adminMed , int stockMedInit) {
        Medicament m = new Medicament();
        m.setNomMed(nomMed);
        m.setAdministrationMed(adminMed);
        m.setStockMed(stockMedInit);
        List<Medicament> listMed = new ArrayList (); 
        m.setListInteractionsMedic(listMed);
	em.getTransaction( ).begin( );
        em.persist(m);
        em.getTransaction().commit();
        return m;
    }
    
    public Medicament createMedicament(String nomMed , String adminMed , int stockMedInit) {
        Medicament m = new Medicament();
        m.setNomMed(nomMed);
        m.setAdministrationMed(adminMed);
        m.setStockMed(stockMedInit);
        List<Medicament> listMed = new ArrayList (); 
        m.setListInteractionsMedic(listMed);
        return m;
    }
    
    public void newMedicament (Medicament m) {
        em.getTransaction( ).begin( );
        em.persist(m);
        em.getTransaction().commit();
    }
    
    public List<Medicament> consultStock() {
	TypedQuery<Medicament> query = em.createQuery("SELECT m FROM Medicament m", Medicament.class);
        List<Medicament> res = query.getResultList();
        return res;
    }
     
    public Medicament getMedicamentByID (int id) {
	Medicament res = em.find( Medicament.class, id );
        return res;
    }    
    
    public void updateMedicament (Medicament m) {
        em.getTransaction( ).begin( );
        em.merge(m);
        em.getTransaction().commit(); 
    }
    
//    public void deleteAllMedicaments() {
//        //Suprimmer ses interactions aussi !!!
//        em.getTransaction( ).begin( );
//        em.createQuery("DELETE FROM Medicament").executeUpdate();
//        em.getTransaction().commit();
//    }
    
    public void deleteMedicament(int id) {
        //Suprimmer ses interactions aussi !!!
        Medicament med = em.find(Medicament.class, id);
        em.getTransaction( ).begin( );
        em.remove(med);
        em.getTransaction().commit();
    }
    
//    //Ajoute une interaction entre deux médicament (dans les deux sens)
//    public void setInteractionsMedic (Medicament m, Medicament m1) {
//        m.addInteractionMedic(m1);
//        m1.addInteractionMedic(m);
//        em.getTransaction( ).begin( );
//        em.persist(m);
//        em.getTransaction().commit();
//    }
//    
//    //Supprime une interaction entre deux médicament (dans les deux sens)
//    public void deleteInteractionsMedic (Medicament m , Medicament m1) {
//        m.delInteractionMedic(m1);
//        m1.delInteractionMedic(m);
//    }
//    
//    //Retoune vrai si on detecte une interaction
//    public boolean detectInteractionsMedic (Medicament m , Medicament m1) {
//        boolean interactionDetect = false;
//        if (m.interactionsMedic.contains(m1)) {
//            interactionDetect = true;
//        }
//        return interactionDetect;
//    }
    
    /*Admission*/
    
    public Admission newAdmission(int IEP , int IPP , String nom , String prenom) {
        Admission a = new Admission();
        
        a.setIEP(IEP);
        a.setIPP(IPP);
        a.setNomPatient(nom);
        a.setPrenomPatient(prenom);
	em.getTransaction( ).begin( );
        em.persist(a);
        em.getTransaction().commit();
        return a;
    }
    
    public Admission createAdmission(int IEP , int IPP , String nom , String prenom) {
        Admission a = new Admission();
        a.setIEP(IEP);
        a.setIPP(IPP);
        a.setNomPatient(nom);
        a.setPrenomPatient(prenom);
        return a;
    }
    
    public void newAdmission(Admission a){
	em.getTransaction( ).begin( );
        em.persist(a);
        em.getTransaction().commit();
    }
    
    public void updateAdmission (Admission ad) {
        em.getTransaction( ).begin( );
        em.merge(ad);
        em.getTransaction().commit(); 
    }
    
    public List<Admission> getAllAdmission() {
	TypedQuery<Admission> query = em.createQuery("SELECT a FROM Admission a", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }
    
    public void deleteAllAdmission() {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteAdmission(int id) {
        Admission a = em.find(Admission.class, id);
        em.getTransaction( ).begin( );
        em.remove(a);
        em.getTransaction().commit();
    }
    
    public Admission getAdmissionByIEP (int IEP) {
	Admission res = em.find( Admission.class, IEP );
        return res;
    }
    
    public List<Admission> getAdmissionByIPP (int IPP) {
	TypedQuery<Admission> query;
        query = em.createQuery(
                "SELECT a FROM Admission a WHERE a.IPP LIKE :IPP ", Admission.class)
                .setParameter("IPP",IPP);
        List<Admission> res = query.getResultList();
        return res;
    }
    
    /*Prescription*/
    
    public Prescription newPrescription(String nomUF , String prep , String date, Medicament med , int q) {
        Prescription p = new Prescription();
        List <MedicamentPrescription> listMedP = new ArrayList ();
        MedicamentPrescription medP = newMedicamentPrescription(med, q);
        
        p.setListMedicamentsPresc(listMedP);
        p.addMedicamentPresc(medP);
        p.setNomUF(nomUF);
        p.setPreparateur(prep);
        p.setEtat(Etat.NonValide);
        p.setDatePresc(date);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }
    
    public Prescription createPrescription(String nomUF , String prep , String date, Medicament med , int q) {
        Prescription p = new Prescription();
        List <MedicamentPrescription> listMedP = new ArrayList ();
        MedicamentPrescription medP = newMedicamentPrescription(med, q);
        
        p.setListMedicamentsPresc(listMedP);
        p.addMedicamentPresc(medP);
        p.setNomUF(nomUF);
        p.setPreparateur(prep);
        p.setEtat(Etat.NonValide);
        p.setDatePresc(date);
        return p;
    }
    
    public Prescription newPrescription(Prescription p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
    }
    
    
    public List<Prescription> getAllPrescription() {
	TypedQuery<Prescription> query = em.createQuery("SELECT p FROM Prescription p", Prescription.class);
        List<Prescription> res = query.getResultList();
        return res;
    }
    
    public void deleteAllPrescription() {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Prescription").executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deletePrescription(int id) {
        Prescription p = em.find(Prescription.class, id);
        em.getTransaction( ).begin( );
        em.remove(p);
        em.getTransaction().commit();
    }
    
    public Prescription getPrescriptionByID (int id) {
	Prescription res = em.find( Prescription.class, id );
        return res;
    }
    
    public void setEtatPrescription (Prescription p, Etat e) {
        p.setEtat(e);
        em.getTransaction( ).begin( );
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void setEtatSuivantPrescription(Prescription p) {

        switch (p.getEtat()) {
            case NonValide:
                p.setEtat(Etat.Valide);
                em.getTransaction().begin();
                em.merge(p);
                em.getTransaction().commit();
                break;
                
            case Valide:
                p.setEtat(Etat.EnCoursPrep);
                em.getTransaction().begin();
                em.merge(p);
                em.getTransaction().commit();
                break;
                
            case EnCoursPrep:
                p.setEtat(Etat.Delivree);
                em.getTransaction().begin();
                em.merge(p);
                em.getTransaction().commit();
                break;

            default:
                break;
        }
    }
    
    public void updatePrescription (Prescription p) {
        em.getTransaction( ).begin( );
        em.merge(p);
        em.getTransaction().commit(); 
    }
    
    public void setAdmissionPrescription (Prescription p, Admission a) {
        p.setAdmiPatient(a);
        em.getTransaction( ).begin( );
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public void setMedPrescPrescription (Prescription p, MedicamentPrescription mp) {
        p.addMedicamentPresc(mp);
        em.getTransaction( ).begin( );
        em.persist(p);
        em.getTransaction().commit();
    }  
    
//    //Retourne false s'il n'y pas d'interaction dans la prescription
//    public boolean detectInteractMedPresc (Prescription p, Medicament m) {
//        boolean interactionDetect = false;
//                
//        for (MedicamentPrescription medP : p.getListMedicamentsPresc() ) {
//            Medicament med = medP.getMedPresc();
//            if(detectInteractionsMedic(med, m)) {
//                interactionDetect = true;
//                break;
//            }
//        }
//        return interactionDetect;
//    }
//    
//    //Prend un medicament créer un medicamentPresc et l'ajoute à la prescription
//    //Retourne false si pas d'interaction et true s'il en detecte une
//    public boolean addMedicamentPresc (Prescription p, Medicament m, int q) {
//        boolean interactionDetect = detectInteractMedPresc (p,m);
//        if (!interactionDetect) {
//            setMedPrescPrescription(p,newMedicamentPrescription(m, q));
//            
//        }
//        return interactionDetect;
//    }
    /*MedicamentPrescription*/
    
    public MedicamentPrescription newMedicamentPrescription(Medicament med , int q) {
        MedicamentPrescription mp = new MedicamentPrescription();
        mp.setMedPresc(med);
        mp.setQuantite(q);
     
	em.getTransaction( ).begin( );
        em.persist(mp);
        em.getTransaction().commit();
        return mp;
    }
    
    public MedicamentPrescription getMedicamentPrescriptionByID(int id) {
        MedicamentPrescription res = em.find( MedicamentPrescription.class, id );
        return res;
    }
    
    public MedicamentPrescription createMedicamentPrescription(Medicament med , int q) {
        MedicamentPrescription mp = new MedicamentPrescription();
        mp.setMedPresc(med);
        mp.setQuantite(q);
        return mp;
    }
    
    public void newMedicamentPrescription(MedicamentPrescription mp){
	em.getTransaction( ).begin( );
        em.persist(mp);
        em.getTransaction().commit();
    }
    
    public void updateMedPresc (MedicamentPrescription mp) {
        em.getTransaction( ).begin( );
        em.merge(mp);
        em.getTransaction().commit(); 
    }
    
    public void deleteAllMedicamentPrescription() {
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM MedicamentPrescription").executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteMedicamentPrescription(int id) {
        MedicamentPrescription mp = em.find(MedicamentPrescription.class, id);
        em.getTransaction( ).begin( );
        em.remove(mp);
        em.getTransaction().commit();
    }
    
//    public List<Prescription> consultWorklistPrep (String prep) {
//	TypedQuery<Prescription> query;
//        query = em.createQuery(
//                "SELECT p FROM Prescription p WHERE p.preparateur LIKE :prepName ", Prescription.class)
//                .setParameter("prepName",prep);
//        List<Prescription> res = query.getResultList();
//        return res;
//    }
    
    public List<Prescription> consultPrescriptionByAdmission (Admission admiIEP) {
	TypedQuery<Prescription> query;
        query = em.createQuery(
                "SELECT p FROM Prescription p WHERE p.admiPatient LIKE :admiIEP ", Prescription.class)
                .setParameter("admiIEP",admiIEP);
        List<Prescription> res = query.getResultList();
        return res;
    }
    
    
    public List<Prescription> consultPrescriptionByIEP (int IEP) {
        Admission admiIEP = getAdmissionByIEP(IEP);
	TypedQuery<Prescription> query;
        query = em.createQuery(
                "SELECT p FROM Prescription p WHERE p.admiPatient LIKE :admiIEP ", Prescription.class)
                .setParameter("admiIEP",admiIEP);
        List<Prescription> res = query.getResultList();
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
