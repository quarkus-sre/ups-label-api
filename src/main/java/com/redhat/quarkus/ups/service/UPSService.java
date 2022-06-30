package com.redhat.quarkus.ups.service;

import java.time.LocalDate;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.redhat.quarkus.ups.domain.Label;
import com.redhat.quarkus.ups.domain.Order;

@Path("/ups")
public class UPSService {

  @ConfigProperty(name="label.delay", defaultValue = "2000")
  long delay;

  int minDelay = 300;
  int maxDelay = 2000;
  
  @POST
  @Path("/createlabel")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Label createLabel(Order order) throws InterruptedException {
    System.out.println("Label generated -> "+UUID.randomUUID().toString());
    delay = (int) ((Math.random() * (maxDelay - minDelay)) + minDelay);
    System.out.println("UPS Delay -> "+ delay);
    Thread.sleep(delay);
    return new Label(UUID.randomUUID().toString(), LocalDate.now());
  }

}