package com.tp;
import com.model.Personne;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.*;

@Path("/tigre")
public class TigreAPI {
        private  static int idCount ;

        // static pour conserver les data entre les requettes
        private static List<Tigre> tigres = new ArrayList<>() ;

        @GET
        @Produces(MediaType.APPLICATION_JSON) // renvoie
        public List<Tigre> getTigres (){
            return tigres;
        }
        @POST
        @Consumes(MediaType.APPLICATION_JSON)  // recois
        public void addTigre (Tigre newTigre){
            newTigre.setId(idCount++);
            tigres.add(newTigre);
            System.out.println("newTigre : "+ newTigre);
        }
    //Get one person
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Tigre getTigre(@PathParam("id") Integer id){
        for(Tigre p : tigres){
            if(p.getId().equals(id)){
                System.out.println("p id"+p);
                return  p;
            }
        }
        return null;

    }
    @DELETE
    @Path("/{id}")
    public void deleteTigre(@PathParam("id") Integer id){
        for(Tigre p : tigres){
            if(p.getId().equals(id)){
                tigres.remove(p);
            }
        }
    }

    @PUT
    @Path("/{id}")
    public void  updatTigre(Tigre newData, @PathParam("id") Integer id){
      int i =0;
       while(i < tigres.size() && !tigres.get(i).getId().equals(id)){
           i++;
       }
       if(i < tigres.size()){
           newData.setId(id);
           tigres.set(i, newData);
       }

    }

   @PATCH
    @Path("/{id}")
    public void  updatTigreValue(Tigre newData, @PathParam("id") Integer id){
      int i =0;
       while(i < tigres.size() && !tigres.get(i).getId().equals(id)){
           i++;
       }
       if(i < tigres.size()){
           Tigre dbTigre = tigres.get(id);
           dbTigre.setNotNull(newData);
       }

    }


















}
