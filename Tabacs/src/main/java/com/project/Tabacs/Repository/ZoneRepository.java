package com.project.Tabacs.Repository;


import com.project.Tabacs.Model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

    Optional <List<Zone>> findByNomZoneContains(String nomZone);
    Optional<Zone> findByNomZone(String nomZone);

}
