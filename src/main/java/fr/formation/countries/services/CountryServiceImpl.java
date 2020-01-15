package fr.formation.countries.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.formation.countries.dtos.CountryDto;
import fr.formation.countries.dtos.CountryViewDto;
import fr.formation.countries.entities.Country;
import fr.formation.countries.entities.Region;
import fr.formation.countries.repositories.CountryRepository;
import fr.formation.countries.repositories.RegionRepository;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepo;

    private final RegionRepository regionRepo;

    protected CountryServiceImpl(CountryRepository countryRepo,
	    RegionRepository regionRepo) {
	this.countryRepo = countryRepo;
	this.regionRepo = regionRepo;
    }

    @Override
    public CountryViewDto getOne(String code) {
	CountryViewDto viewDto = countryRepo.findByAlpha2Code(code);
	if (viewDto == null) {
	    CountryDto response = callApi(code);
	    Region region = saveAndGet(response.getRegion());
	    Country country = new Country(response.getNativeName(),
		    response.getAlpha2Code(), region, response.getFlag());
	    countryRepo.save(country);
	    return countryRepo.findByAlpha2Code(code);
	}
	return viewDto;
    }

    @Override
    public CountryDto callApi(String code) {
	RestTemplate restTemplate = new RestTemplate();
	CountryDto dto = restTemplate.getForObject(
		"https://restcountries.eu/rest/v2/alpha/" + code,
		CountryDto.class);
	return dto;
    }

    private Region saveAndGet(String name) {
	// regionRepo.saveIfDoesntExist(name);
	Region region = regionRepo.findByName(name);
	if (region == null) {
	    regionRepo.save(new Region(name));
	    region = regionRepo.findByName(name);
	}
	return region;
    }
}
