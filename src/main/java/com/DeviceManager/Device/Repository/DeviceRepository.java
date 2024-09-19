package com.DeviceManager.Device.Repository;

import com.DeviceManager.Device.Entity.Device;
import com.DeviceManager.Device.dto.smallDTO.GetCountDeviceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    boolean existsByCode(String deviceCode);
    boolean existsByCodeAndId(String deviceCode, int id);

    @Query(value = "SELECT code from device", nativeQuery = true)
    List<String> findAllOnlyCode();

    @Query(value = "SELECT * FROM device LIMIT 8 OFFSET :offsetValue", nativeQuery = true)
    List<Device> splitTableDevice(@Param("offsetValue") int offsetValue);

    @Query(value = "SELECT COUNT(*) FROM device", nativeQuery = true)
    int countTableDevice();

    @Query(value = "SELECT DISTINCT current_area, SUM(CASE WHEN type = 'tablet' THEN 1 ELSE 0 END) OVER (PARTITION BY current_area), SUM(CASE WHEN type = 'barcode' THEN 1 ELSE 0 END) OVER (PARTITION BY current_area) FROM device;",nativeQuery = true)
    List<Object[]> getCountTableDevice();


}
