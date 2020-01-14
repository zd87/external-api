package fr.formation.countries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.countries.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findByName(String name);
    /*
     * this caused a problem with auto increment in the database, but was nice
     * to try
     *
     * @Modifying
     *
     * @Transactional
     *
     * @Query(value =
     * "insert into countries.region (name) values (:region) on duplicate key update id = id"
     * , nativeQuery = true) void saveIfDoesntExist(@Param("region") String
     * region);
     *
     */
}
