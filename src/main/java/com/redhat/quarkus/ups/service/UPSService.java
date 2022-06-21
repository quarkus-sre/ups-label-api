package com.redhat.quarkus.ups.service;

import java.time.LocalDate;
import java.util.UUID;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.redhat.quarkus.ups.domain.Label;
import com.redhat.quarkus.ups.domain.Order;

@Path("/ups")
public class UPSService {

  @POST
  @Path("/createlabel")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Label createLabel(Order order) {
    System.out.println("Label generated -> "+UUID.randomUUID().toString());
    return new Label(UUID.randomUUID().toString(), LocalDate.now());
  }

}