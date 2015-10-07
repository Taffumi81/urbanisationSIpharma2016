/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pharma.Medicament;
import bureau.DatabaseUtils;
import pharma.ServicesPharma;
import pharma.Admission;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        serv.deleteAllMedicaments();
        List<Medicament> res = serv.consultStock();
        assert(res.isEmpty());
    }
    
    @Test
    public void medicament() {
        
        clean();
        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
        Medicament med = serv.newMedicament("Test1","Orale",300);
        assertNotNull(med);
        med = serv.newMedicament("Test2","Orale",100);
        assertNotNull(med);
        
        List<Medicament> res = serv.consultStock();
        assert(!res.isEmpty());
        assert(res.size() == 2);
        
        for (Medicament m : res) {
            System.out.println(m.getId());
            System.out.println(m.getNomMed());
            System.out.println(m.getAdministrationMed());
            System.out.println(m.getStockMed());
            System.out.println("---------------");
        }
        
    }
    
    @Test
    public void admission() {
        
        clean();
        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
        Admission a = serv.newAdmission(01,101,"Gagnaire","Patrick");
        assertNotNull(a);
        a = serv.newAdmission(02,201,"Chevanne","Alexy");
        assertNotNull(a);
        a = serv.newAdmission(03,301,"Receveur","Alexandre");
        assertNotNull(a);
        
        List<Admission> res = serv.getAllAdmission();
        assert(!res.isEmpty());
        assert(res.size() == 3);
        
        /*for (Admission m : res) {
            System.out.println(m.toString());
            System.out.println("---------------");
        }*/
        
        Admission res1 = serv.getAdmissionByIEP(02);
        assert(res1!=null);
        assert(res1.getNomPatient().equals("Chevanne"));
        System.out.println(res1.toString());
        
        Admission res2 = serv.getAdmissionByIEP(04);
        assert(res2==null);
    }
}
