package com.junny.relationships.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.junny.relationships.models.License;
import com.junny.relationships.services.LicenseService;

@RestController
public class LicensesApi {
 private final LicenseService licenseService; // backend. think of it like a const variable (won't change)
 public LicensesApi(LicenseService licenseService){
     this.licenseService = licenseService;
 }
 @RequestMapping("/api/licenses") // create routes
 public List<License> index() {
     return licenseService.allLicenses(); // calling on functions from LicenseService.java (calling from back-end)
 }
 
 @RequestMapping(value="/api/licenses", method=RequestMethod.POST)
 public License create(@RequestParam(value="number") String number,
		@RequestParam(value="expirationDate") Date expirationDate,
 		@RequestParam(value="state") String state){
     License license = new License(number, expirationDate, state); // creating/instantiating a new License according to the License Model
     return licenseService.createLicense(license); // calling on functions from LicenseService.java (calling from back-end)
 }
 
 @RequestMapping("/api/licenses/{id}")
 public License show(@PathVariable("id") Long id) {
     License license = licenseService.findLicense(id); // calling on functions from LicenseService.java (calling from back-end)
     return license;
 }
 
 @RequestMapping(value="/api/licenses/{id}", method=RequestMethod.PUT)
 public License update(@PathVariable("id") Long id, 
 		@RequestParam(value="number") String number, 
 		@RequestParam(value="expirationDate") Date expirationDate,
 		@RequestParam(value="state") String state){
     License license = licenseService.updateLicense(id, number, expirationDate, state);
     return license;
 }
 
 @RequestMapping(value="/api/licenses/{id}", method=RequestMethod.DELETE)
 public void destroy(@PathVariable("id") Long id) {
     licenseService.deleteLicense(id);
 }

}


