package com.DeviceManager.Device.Repository;

import com.DeviceManager.Device.Entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    boolean existsByCode(String deviceCode);
    boolean existsByCodeAndId(String deviceCode, int id);

    @Query(value = "SELECT code from device", nativeQuery = true)
    List<String> findAllOnlyCode();
}
