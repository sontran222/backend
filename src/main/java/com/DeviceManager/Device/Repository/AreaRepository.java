package com.DeviceManager.Device.Repository;

import com.DeviceManager.Device.Entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    @Query(value = "SELECT area FROM Area", nativeQuery = true)
    List<String> findAllOnlyAreas();


}
