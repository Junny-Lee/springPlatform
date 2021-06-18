package com.junny.relationships.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.junny.relationships.models.License;
import com.junny.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
 // adding the license repository as a dependency
 private final LicenseRepository licenseRepository;
 
 public LicenseService(LicenseRepository licenseRepository) {
     this.licenseRepository = licenseRepository;
 }
 // returns all the licenses
 public List<License> allLicenses() {
     return licenseRepository.findAll(); // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 
 }
 // creates a license
 public License createLicense(License l) {
     return licenseRepository.save(l); // save() fn from extending from Crud
 }
 // retrieves a license
 public License findLicense(Long id) {
     Optional<License> optionalLicense = licenseRepository.findById(id); // Optional is saying "if it is here, i'll get you the license"
     if(optionalLicense.isPresent()) {
         return optionalLicense.get();
     } else {
         return null;
     }
 }
 // updates a license
 public License updateLicense(Long id, String number, Date expirationDate, String state) {
 	License license = findLicense(id);
 	license.setNumber(number);
 	license.setExpirationDate(expirationDate);
 	license.setState(state);
 	return licenseRepository.save(license);
 }
 
 public License updateLicense(License l) {
 	return licenseRepository.save(l);
 }
 
 // deletes a license
 public void deleteLicense(Long id) {
 	licenseRepository.deleteById(id);
 }
}
