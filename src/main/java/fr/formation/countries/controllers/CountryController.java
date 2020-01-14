package fr.formation.countries.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.countries.dtos.CountryViewDto;
import fr.formation.countries.services.CountryService;

@RestController
@RequestMapping("/countries")
@CrossOrigin("*")
public class CountryController {

    private final CountryService service;

    protected CountryController(CountryService service) {
	this.service = service;
    }

    @GetMapping("/{code}")
    protected CountryViewDto response(@PathVariable("code") String code) {
	return service.getOne(code);
    }
}
