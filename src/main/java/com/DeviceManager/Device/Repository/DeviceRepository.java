package com.DeviceManager.Device.Repository;

import com.DeviceManager.Device.Entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    boolean existsByCode(String deviceCode);
    boolean existsByCodeAndId(String deviceCode, int id);

}
