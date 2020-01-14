package fr.formation.countries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.countries.dtos.CountryViewDto;
import fr.formation.countries.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    CountryViewDto findByAlpha2Code(String code);
}
