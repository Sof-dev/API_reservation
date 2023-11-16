package com.model;

import com.tp.Tigre;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.*;


@Path("/personnes")
public class PersonneApi {
    private  static int idCount ;

    // static pour conserver les data entre les requettes
    private static List<Personne> personnes = new ArrayList<>() ;

    @GET
    @Produces(MediaType.APPLICATION_JSON) // renvoie
    public List<Personne> getPersonnes (){
       /* List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("Alain", "Delon"));
              personnes.add(new Personne("Marie", "Dupont"));
        return personnes;*/
        return personnes;

    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)  // recois
    @Produces(MediaType.APPLICATION_JSON)
   /* public void addPersonne (Personne newPersonne){
         newPersonne.setId(idCount++);
         personnes.add(newPersonne);
         System.out.println("personnes : "+ newPersonne);
    }*/
   public Response postPersonne (Personne newPersonne){
         newPersonne.setId(idCount++);

        // if(newPersonne.getPrenom().isEmpty() || newPersonne.getNom().isEmpty()){
        if(newPersonne.getPrenom() == null||newPersonne.getPrenom() .isBlank() || newPersonne.getNom()== null || newPersonne.getNom().isBlank()){

             return Response.status(Response.Status.BAD_REQUEST).entity("Error les champs ne doivent pas etre vide ").build();

         }else{
             personnes.add(newPersonne);
             //System.out.println("personnes : "+ newPersonne);
             //return Response.status(201).build();
             System.out.println("Response serveur  : "+ Response.status(Response.Status.CREATED).build());
             return Response.status(Response.Status.CREATED).entity(newPersonne).build();

         }

    }






    //Get one person
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
//    public Personne getPersonne(@PathParam("id") Integer id){
//        for(Personne p : personnes){
//            if(p.getId().equals(id)){
//                System.out.println("p id"+p);
//                return  p;
//            }
//        }
//        return null;
//
//    }
     public Response getPersonne(@PathParam("id") Integer id){
        for(Personne p : personnes){
            if(p.getId().equals(id)){
                System.out.println("p id"+p);
                return  Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.FOUND).entity(" id inexistatnt").build();

    }








  // idem get id , si id  n'existe pas
    @DELETE
    @Path("/{id}")
    public void deletePersonne(@PathParam("id") Integer id){
        for(Personne p : personnes){
            if(p.getId().equals(id)){
                personnes.remove(p);
            }
        }
    }

   /* @DELETE
    @Path("/{id}")
    public void deletePersonne(@PathParam("id") Integer id){

        Iterator<Personne> it = personnes.listIterator();
        boolean continuer = true;
        while(it.hasNext() && continuer){
            Personne p = it.next();
            if(p.getId().equals(id)) {
                personnes.remove(p);
                continuer = false;
            }
        }*/
        /*
       int i = 0;
       while(i < personnes.size() && !personnes.get(i).getId().equals(id)){
          i++;
       }
       if(i < personnes.size()){
           personnes.remove(i);
       }*/

/* ATTENTION : Exception Access Concurrent
       for(Personne p : personnes){
           if(p.getId().equals(id)){
               personnes.remove(p);
           }
       }*/
   @PUT
   @Path("/{id}")
//    public void  updatePersonne(Personne newData, @PathParam("id") Integer id){
//      int i =0;
//       while(i < personnes.size() && !personnes.get(i).getId().equals(id)){
//           i++;
//       }
//       if(i < personnes.size()){
//           newData.setId(id);
//           personnes.set(i, newData);
//       }
//    }
   public Response updatePersonne(Personne newData, @PathParam("id") Integer id){

       if(!id.equals(newData.getId())){
           return Response.status(Response.Status.BAD_REQUEST).entity("deux id différents").build();
       }
       else {

           if(findPersonne(id) == null){
               return Response.status(Response.Status.NOT_FOUND).entity("id inexistant").build();
           }
           else {
               int i = 0;
               while (i < personnes.size() && !personnes.get(i).getId().equals(id)) {
                   i++;
               }
               if (i < personnes.size()) {
                   newData.setId(id);
                   personnes.set(i, newData);
                   return Response.ok().build();
               }
               return Response.status(Response.Status.BAD_REQUEST).entity("").build();
           }
       }
   }






    @PATCH
    @Path("patch/{id}")
    public void patchPersonne(Personne newData, @PathParam("id") Integer id){

            int i =0;
            while(i < personnes.size() && !personnes.get(i).getId().equals(id)){
                i++;
            }
            if(i < personnes.size()){
                Personne dbPersonne = personnes.get(id);
                dbPersonne.setNotNull(newData);

            }


    }

    private Personne findPersonne(Integer id){
        for(Personne p : personnes){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }













    }
