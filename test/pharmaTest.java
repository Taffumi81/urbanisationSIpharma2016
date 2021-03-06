/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pharma.Medicament;
import bureau.DatabaseUtils;
import pharma.ServicesPharma;
import pharma.Admission;
import pharma.Prescription;
import pharma.MedicamentPrescription;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pharma.Etat;

/**
 *
 * @author achevann
 */
public class pharmaTest {
    
    static EntityManagerFactory fact;
    
    public pharmaTest() {
        
    }
    
    static void clean() {
        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        serv.deleteAllMedicaments();
        serv.deleteAllAdmission();
        serv.deleteAllMedicamentPrescription();
        serv.deleteAllPrescription();
        List<Medicament> res = serv.consultStock();
        assert(res.isEmpty());
    }
    
//    @Test
//    public void medicament() {
//        
//        //clean();
//        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        Medicament med = serv.newMedicament("Test1","Orale",300);
//        assertNotNull(med);
//        Medicament med1 = serv.newMedicament("Test2","Anale",300);
//        
//        List<Medicament> listInt = new ArrayList ();
//        listInt.add(med);
//        listInt.add(med1);
//        
//        Medicament med2 = serv.newMedicament("Test3","Orale",100);
//        assertNotNull(med2);
//        
//        List<Medicament> res = serv.consultStock();
//        assert(!res.isEmpty());
//        assert(res.size() == 3);
//        
//        serv.setInteractionsMedic(med2, med);
//        
//        
//        for (Medicament m : res) {
//            System.out.println(m.getId());
//            System.out.println(m.getNomMed());
//            System.out.println(m.getAdministrationMed());
//            System.out.println(m.getStockMed());
//            System.out.println("---------------");
//        }
//        
//    }
    
//    @Test
//    public void admission() {
//        
//        clean();
//        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        Admission a = serv.newAdmission(01,101,"Gagnaire","Patrick");
//        assertNotNull(a);
//        a = serv.newAdmission(02,201,"Chevanne","Alexy");
//        assertNotNull(a);
//        a = serv.newAdmission(03,301,"Receveur","Alexandre");
//        assertNotNull(a);
//        
//        List<Admission> res = serv.getAllAdmission();
//        assert(!res.isEmpty());
//        assert(res.size() == 3);
//        
//        /*for (Admission m : res) {
//            System.out.println(m.toString());
//            System.out.println("---------------");
//        }*/
//        
//        Admission res1 = serv.getAdmissionByIEP(02);
//        assert(res1!=null);
//        assert(res1.getNomPatient().equals("Chevanne"));
//        System.out.println(res1.toString());
//        
//        Admission res2 = serv.getAdmissionByIEP(04);
//        assert(res2==null);
//    }
    
//    @Test
//    public void medicamentPrescription() {
//        clean();
//        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        List<MedicamentPrescription> listMed = new ArrayList() {};
//        
//        Medicament med = serv.newMedicament("Test1","Orale",300);
//        assertNotNull(med);
//        MedicamentPrescription mp = serv.newMedicamentPrescription(med, 10);
//        assertNotNull(mp);
//        listMed.add(mp);
//        
////        med = serv.newMedicament("Test2","Orale",100);
////        assertNotNull(med);
//        mp = serv.newMedicamentPrescription(med, 15);
//        assertNotNull(mp);
//        listMed.add(mp);
//       
//        assert(!listMed.isEmpty());
//        assert(listMed.size() == 2);
//        
//        for (MedicamentPrescription m : listMed) {
//            System.out.println(m.getIdMedPresc());
//            System.out.println(m.getMedPresc());
//            System.out.println(m.getQuantite());
//            System.out.println("---------------");
//        }
//    }
    
//    @Test
//    public void Prescription() {
//       clean();
//       ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//       Medicament med = serv.newMedicament("Test1","Orale",300);
//       assertNotNull(med);
//       Medicament med1 = serv.newMedicament("Test2","Orale",200);
//       assertNotNull(med1);
//       Medicament med2 = serv.newMedicament("Test3","Anale",250);
//       assertNotNull(med1);
//        
//       MedicamentPrescription mp = serv.newMedicamentPrescription(med, 10);
//       assertNotNull(mp);
//       MedicamentPrescription mp1 = serv.newMedicamentPrescription(med1, 15);
//       assertNotNull(mp1);
//       MedicamentPrescription mp2 = serv.newMedicamentPrescription(med1, 15);
//       assertNotNull(mp2);
//       MedicamentPrescription mp3 = serv.newMedicamentPrescription(med2, 5);
//       assertNotNull(mp3);
//        
//       List<MedicamentPrescription> listMed = new ArrayList<>();
//       listMed.add(mp);
//       listMed.add(mp1);
//       
//       List<MedicamentPrescription> listMed1 = new ArrayList<>();
//       listMed1.add(mp2);
//       listMed1.add(mp3);
//
//       Admission a = serv.newAdmission(12345,101,"Gagnaire","Patrick");
//       Admission a1 = serv.newAdmission(67890,201,"Chevanne","Alexy");
//                
//       Prescription p = serv.newPrescription("Radiologie","Prep1","07/10/2015", med,10);
//       assertNotNull(p);
//       Prescription p1 = serv.newPrescription("Cardio","Prep1","08/10/2015", med1,15);
//       assertNotNull(p1);
//       
////       List<Prescription> listP = serv.consultPrescriptionByIEP(12345);
////       assert(!listP.isEmpty());
////       assert(listP.size() == 1);
//       
////       serv.setEtatByIDPrescription(p.getIdPresc(), Etat.Valide);
//    }
    
    
//    @Test
//    public void ConsultListe() {
//        clean();
//        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        Medicament med = serv.newMedicament("Test1","Orale",300);
//        assertNotNull(med);
//        Medicament med1 = serv.newMedicament("Test2","Orale",200);
//        assertNotNull(med1);
//        Medicament med2 = serv.newMedicament("Test3","Anale",250);
//        assertNotNull(med1);
//
//        MedicamentPrescription mp = serv.newMedicamentPrescription(med, 10);
//        assertNotNull(mp);
//        MedicamentPrescription mp1 = serv.newMedicamentPrescription(med1, 15);
//        assertNotNull(mp1);
//        MedicamentPrescription mp2 = serv.newMedicamentPrescription(med1, 15);
//        assertNotNull(mp2);
//        MedicamentPrescription mp3 = serv.newMedicamentPrescription(med2, 5);
//        assertNotNull(mp3);
//
//        List<MedicamentPrescription> listMed = new ArrayList<>();
//        listMed.add(mp);
//        listMed.add(mp1);
//
//        List<MedicamentPrescription> listMed1 = new ArrayList<>();
//        listMed1.add(mp2);
//        listMed1.add(mp3);
//
//        Admission a = serv.newAdmission(12345,101,"Gagnaire","Patrick");
//        Admission a1 = serv.newAdmission(67890,201,"Chevanne","Alexy");
//        Admission a2 = serv.newAdmission(10111,201,"Chevanne","Alexy");
//
//        Prescription p = serv.newPrescription("Radiologie","Prep1","07/10/2015", listMed,a2);
//        assertNotNull(p);
//        Prescription p1 = serv.newPrescription("Cardio","Prep1","08/10/2015", listMed1,a1);
//        assertNotNull(p1);
//        
//        List<Prescription> workList = serv.consultWorklistPrep("Prep1");
//        assert(workList.size() == 2);
//
//        System.out.println("\nWorklist du préparateur prep1");
//        for (Prescription pr : workList) {
//             System.out.println(pr.toString());
//             System.out.println("---------------");
//        }
//
//        List<Prescription> listbyIEP = serv.consultPrescriptionByIEP(67890);
//        assert(listbyIEP.size() == 1);
//        
//        System.out.println("\nListe des prescriptions de l'IEP 67890");
//        for (Prescription pr : listbyIEP) {
//             System.out.println(pr.toString());
//             System.out.println("---------------");
//        }
//        
//        List<Prescription> listbyIPP = serv.consultPrescriptionByIPP(201);
//        assert(listbyIPP.size() == 2);
//        
//        System.out.println("\nListe des prescriptions de l'IPP 201");
//        for (Prescription pr : listbyIPP) {
//             System.out.println(pr.toString());
//             System.out.println("---------------");
//        }
//    }
    
    
//    @Test
//    public void SetPrescription() {
//        clean();
//        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        Medicament med = serv.newMedicament("Test1","Orale",300);
//        assertNotNull(med);
//        Medicament med1 = serv.newMedicament("Test2","Orale",200);
//        assertNotNull(med1);
//
//        MedicamentPrescription mp = serv.newMedicamentPrescription(med, 10);
//        assertNotNull(mp);
//        MedicamentPrescription mp1 = serv.newMedicamentPrescription(med1, 15);
//        assertNotNull(mp1);
//
//        List<MedicamentPrescription> listMed = new ArrayList<>();
//        listMed.add(mp);
//        listMed.add(mp1);
//
//        Admission a2 = serv.newAdmission(10111,201,"Chevanne","Alexy");
//
//        Prescription p = serv.newPrescription("Radiologie","Prep1","07/10/2015", listMed);
//        assertNotNull(p);
//        
//        serv.setAdmissionPrescription(p, a2);
//        Prescription res = serv.getPrescriptionByID(1);
//        assert(res.getAdmiPatient().getIEP()==10111);
//        
//        serv.setEtatPrescription(p, Etat.Valide);
//        res = serv.getPrescriptionByID(1);
//        assert(res.getEtat().equals(Etat.Valide));
//        
//        serv.setEtatPrescription(p, Etat.EnCoursPrep);
//        res = serv.getPrescriptionByID(1);
//        assert(res.getEtat().equals(Etat.EnCoursPrep));
//    }
    
//    @Test
//    public void intercationsMedicament() {
//        
//        clean();
//        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        Medicament med = serv.newMedicament("Test1","Orale",300);
//        assertNotNull(med);
//        Medicament med1 = serv.newMedicament("Test2","Orale",100);
//        assertNotNull(med1);
//        Medicament med2 = serv.newMedicament("Test3","Anale",150);
//        assertNotNull(med2);
//        
//        List<Medicament> res = serv.consultStock();
//        assert(!res.isEmpty());
//        assert(res.size() == 3);
//        
//        serv.setInteractionsMedic(med, med2);
//        
//        Admission a1 = serv.newAdmission(67890,201,"Chevanne","Alexy");
//        
//        Prescription p = serv.newPrescription("Radiologie","Prep1","07/10/2015", med , 10);
//        
//        assert(serv.addMedicamentPresc(p, med2, 14)==true);
//        assert(serv.addMedicamentPresc(p, med1, 19)==false);
//     
//    }
    
        @Test
        public void test() {
        
        //clean();
        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
//        List<String> test = serv.consultListePrep();
        
//        System.out.println("Voici la liste :" + test);
        
        Prescription p = serv.getPrescriptionByID(1);
        serv.setEtatSuivantPrescription(p);
        System.out.println("Voici la l'état :" + p.getEtat());
     
    }
}
