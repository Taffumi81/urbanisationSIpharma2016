/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import pharma.Medicament;
import bureau.DatabaseUtils;
import pharma.ServicesPharma;

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
        //serv.newMedicament("Test1","Orale",300);
        //List<Medicament> res = serv.getAllMedicament();
        //assert(res.isEmpty());
    }
    
    @Test
    public void medicament() {
        System.out.println("foo");
        clean();
        ServicesPharma serv = new ServicesPharma(DatabaseUtils.fact());
        Medicament med = serv.newMedicament("Test1","Orale",300);
        assertNotNull(med);
        med = serv.newMedicament("Test2","Orale",100);
        assertNotNull(med);
        
        List<Medicament> res = serv.consultStock();
        assert(!res.isEmpty());
        assert(res.size() == 2);
        System.out.println("toto test");
        
        for (Medicament m : res) {
            System.out.println(m.getId());
            System.out.println(m.getNomMed());
            System.out.println(m.getAdministrationMed());
            System.out.println(m.getStockMed());
        }
        
    }
}
