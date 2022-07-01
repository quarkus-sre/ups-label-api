package com.redhat.quarkus.ups.service;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.quarkus.ups.domain.Label;
import com.redhat.quarkus.ups.domain.Order;

@Path("/ups")
public class UPSService {

  int minDelay = 300;
  int maxDelay = 1000;

  Random random = new Random();
  
  @POST
  @Path("/createlabel")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Label createLabel(Order order) throws InterruptedException {
    UUID randomUUID = UUID.randomUUID();
    System.out.println("Label generated -> "+randomUUID.toString());
    int delay = random.nextInt(maxDelay - minDelay) + minDelay;
    System.out.println("UPS Delay -> "+ delay);
    Thread.sleep(delay);
    return new Label(randomUUID.toString(), LocalDate.now());
  }

}