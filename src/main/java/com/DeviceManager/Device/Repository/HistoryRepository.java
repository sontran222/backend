package com.DeviceManager.Device.Repository;

import com.DeviceManager.Device.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
//    @Query(value = " id,  FROM user ", nativeQuery = true)
//    Device findByEmail(@Param("email") String email);

}
