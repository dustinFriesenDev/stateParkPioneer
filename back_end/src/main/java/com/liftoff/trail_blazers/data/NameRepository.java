package com.liftoff.trail_blazers.data;

import com.liftoff.trail_blazers.model.Name;
import com.liftoff.trail_blazers.model.Plants;
import com.liftoff.trail_blazers.model.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRepository extends JpaRepository<Name, Integer> {

    List<Name> findByName(Name name);

}
