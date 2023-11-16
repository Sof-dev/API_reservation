package com.tp.spectacle;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
@Path("/reservations")
public class ReservationAPI {
    private SpectacleDAO spectacleDAO = SpectacleDAO.getInstance();
    private ResvervationDAO reservationDAO = ResvervationDAO.getInstance();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postReservation(Reservation reservation) {
        if(!spectacleDAO.exist(reservation.getSpectacleId()))
            return Response.status(Response.Status.BAD_REQUEST).build();
        else{
            reservationDAO.addReservation(reservation);
            return Response.ok().build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getReservations() {
        return reservationDAO.getReservations();
    }

    @DELETE
    @Path("/{id}")
    public Response annulationReservation(@PathParam("id") Integer id){
        boolean ok = reservationDAO.annulationReservation(id);
        if (ok)
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}/validation")
    public Response confirmerReservation(Reservation confirmation, @PathParam("id") Integer id){
        if(!confirmation.getId().equals(id))
            return Response.status(Response.Status.BAD_REQUEST).build();

        boolean ok = reservationDAO.confirme(confirmation);

        if (ok)
            return Response.ok().build();
        else
            return Response.status(Response.Status.FORBIDDEN).build();
    }



}
