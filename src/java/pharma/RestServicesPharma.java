/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import bureau.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Kurasawa
 */
@Path("generic")
public class RestServicesPharma {

    @Context
    private UriInfo context;
   
    ServicesPharma serv;
    /**
     * Creates a new instance of GenericResource
     */
    public RestServicesPharma() {
       serv = new ServicesPharma(DatabaseUtils.fact());
    }
    
    @GET
    @Path("medicaments")
    @Produces("application/json")
    public List<Medicament> getStock() {
        //TODO return proper representation object
        return serv.consultStock();
    }
    
    @GET
    @Path("admissions")
    @Produces("application/json")
    public List<Admission> getAllAdmi() {
        //TODO return proper representation object
        return serv.getAllAdmission();
    }
    
    @GET
    @Path("admissions/iep/{id}")
    @Produces("application/json")
    public Admission getAdmiByIEP(@PathParam("id") int iep) {
        return serv.getAdmissionByIEP(iep);
    }
    
    @GET
    @Path("admissions/ipp/{id}")
    @Produces("application/json")
    public List<Admission> getAdmiByIPP(@PathParam("id") int ipp) {
        return serv.getAdmissionByIPP(ipp);
    }
    
    @GET
    @Path("prescriptions")
    @Produces("application/json")
    public List<Prescription> getAllPresc() {
        //TODO return proper representation object
        return serv.getAllPrescription();
    }
    
    @GET
    @Path("prescriptions/{id}")
    @Produces("application/json")
    public Prescription getPrescById(@PathParam("id") int id) {
        return serv.getPrescriptionByID(id);
    }
    
    @GET
    @Path("prescriptions/prep/{prep}")
    @Produces("application/json")
    public List<Prescription> getWorklistPrep(@PathParam("prep") String prep) {
        return serv.consultWorklistPrep(prep);
    }
//    
//    //NEW
//    
    @POST
    @Path("medicaments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Medicament newMedic(Medicament m) {
        serv.newMedicament(m);
        System.out.println("id:"+m.getId());
        return m;
    }
    
    @POST
    @Path("admissions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Admission newAdmi(Admission a) {
        serv.newAdmission(a);
        System.out.println("id:"+a.getId());
        return a;
    }
    
    @POST
    @Path("medicpresc")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public MedicamentPrescription newMedPresc(MedicamentPrescription mp) {
        serv.newMedicamentPrescription(mp);
        System.out.println("id:"+mp.getIdMedPresc());
        return mp;
    }
    
//    @POST
//    @Path("prescriptions")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces("application/json")
//    public Prescription newPresc(Prescription p) {
//        serv.newPrescription(p);
//        System.out.println("id:"+p.getIdPresc());
//        return p;
//    }
//    
//    //DELETE
//    
//    @DELETE
//    @Path("medicaments/{id}")
//    public Response removeMedic(@PathParam("id") int id) {
//        serv.deleteMedicament(id);
//        return Response.status(200).build();
//    }
   
}
