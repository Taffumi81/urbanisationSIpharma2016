/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharma;

import bureau.*;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    @Path("medicaments/{id}")
    @Produces("application/json")
    public Medicament getMedicByID(@PathParam("id") int id) {
        return serv.getMedicamentByID(id);
    }
    
    @GET
    @Path("admissions")
    @Produces("application/json")
    public List<Admission> getAllAdmi() {
        return serv.getAllAdmission();
    }
    
    @GET
    @Path("admissions/{id}")
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
        return serv.getAllPrescription();
    }
    
    @GET
    @Path("prescriptions/{id}")
    @Produces("application/json")
    public Prescription getPrescById(@PathParam("id") int id) {
        return serv.getPrescriptionByID(id);
    }
    
    @GET
    @Path("prescriptions/iep/{id}")
    @Produces("application/json")
    public List<Prescription> getPrescByIep(@PathParam("id") int id) {
        return serv.consultPrescriptionByIEP(id);
    }
    
    @GET
    @Path("prescriptions/ipp/{id}")
    @Produces("application/json")
    public List<Prescription> getPrescByIpp(@PathParam("id") int id) {
        return serv.consultPrescriptionByIPP(id);
    }
    
    @GET
    @Path("medpresc/{id}")
    @Produces("application/json")
    public MedicamentPrescription getMedPresc(@PathParam("id") int id) {
        return serv.getMedicamentPrescriptionByID(id);
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
    @Path("medpresc")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public MedicamentPrescription newMedPresc(MedicamentPrescription mp) {
        serv.newMedicamentPrescription(mp);
        System.out.println("id:"+mp.getIdMedPresc());
        return mp;
    }
    
    @POST
    @Path("prescriptions")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Prescription newPresc(Prescription p) {
        serv.newPrescription(p);
        System.out.println("id:"+p.getIdPresc());
        return p;
    }
    
    //SET
    
    @POST
    @Path("medicaments/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Medicament updateMed(Medicament m) {
        serv.updateMedicament(m);
        System.out.println("id:"+m.getId());
        return m;
    }
    
    @POST
    @Path("admissions/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Admission updateAdmi(Admission ad) {
        serv.updateAdmission(ad);
        System.out.println("id:"+ad.getId());
        return ad;
    }
    
    @POST
    @Path("medicpresc/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public MedicamentPrescription updateMedPresc(MedicamentPrescription mp) {
        serv.updateMedPresc(mp);
        System.out.println("id:"+mp.getIdMedPresc());
        return mp;
    }
    
    @POST
    @Path("prescriptions/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Prescription updatePresc(Prescription p) {
        serv.updatePrescription(p);
        System.out.println("id:"+p.getIdPresc());
        return p;
    }
    
    @GET
    @Path("prescriptions/state/{id}")
    @Produces("application/json")
    public Response updateStatePresc(@PathParam("id") int id){
        Prescription pr = serv.getPrescriptionByID(id);
        serv.setEtatSuivantPrescription(pr);
        return Response.status(200).build();
    }
    //DELETE
    
    @DELETE
    @Path("medicpresc/{id}")
    public Response removeMedPresc(@PathParam("id") int id) {
        serv.deleteMedicamentPrescription(id);
        return Response.status(200).build();
    }
    
    @DELETE
    @Path("prescriptions/{id}")
    public Response removePresc(@PathParam("id") int id) {
        serv.deletePrescription(id);
        return Response.status(200).build();
    }
}
