package com.circuitbreaker.example;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TaxService {

  private final RestTemplate restTemplate;

  public TaxService(RestTemplate rest) {
    this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public Tax getTaxDetails(BigDecimal amount) {
	System.out.println("Getting tax details for amount : Rs "+amount);
    URI uri = URI.create("https://taxservicec5244525trial.hanatrial.ondemand.com/tax.svc/api/v1/calculate/tax?amount="+amount);

    return this.restTemplate.getForObject(uri, Tax.class);
  }

  public Tax reliable(BigDecimal amount) {
	  System.out.println("Inside tax details fallback");
	  
	  Tax tax = new Tax();
	  tax.setTaxPercentage(00.00);
	  tax.setTaxAmount(new BigDecimal(00.00));
    
	  return tax;
  }

}
