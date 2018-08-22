package com.netflix.spinnaker.gate.controllers;

import com.netflix.spinnaker.gate.services.ServiceService;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/service")
public class ServiceController {
  private final ServiceService serviceService;

  @Autowired
  public ServiceController(ServiceService serviceService) {
    this.serviceService = serviceService;
  }

  @RequestMapping(value = "{account}/services", method = RequestMethod.GET)
  public List<Map> listServices(@RequestParam(value = "provider", required = false) String provider, // deprecated
                                @RequestParam(value = "cloudProvider", required = false) String cloudProvider,
                                @PathVariable String account) {
    return serviceService.listServices(provider, cloudProvider, account);
  }
}
