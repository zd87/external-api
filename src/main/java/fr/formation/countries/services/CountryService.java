package fr.formation.countries.services;

import fr.formation.countries.dtos.CountryDto;
import fr.formation.countries.dtos.CountryViewDto;

public interface CountryService {

    CountryViewDto getOne(String code);

    CountryDto callApi(String code);
}
