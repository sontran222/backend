package com.DeviceManager.Device.Repository;

import com.DeviceManager.Device.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer> {
    @Query(value = "SELECT * FROM history LIMIT 8 OFFSET :pageNumber", nativeQuery = true)
    List<History> getHistoryLimit(@Param("pageNumber") int pageNumber);

    @Query(value = "SELECT count(*) FROM history", nativeQuery = true)
    int getHistoryCount();
    @Transactional
    @Modifying
    @Query(value = "update device d set d.current_area = (select current_area from history h where h.code = d.code order by h.id desc Limit 1) where exists (select 1 from history h where h.code = d.code ) AND d.id IS NOT NULL", nativeQuery = true)
    public void updateCurrentArea();

    @Transactional
    @Modifying
    @Query(value = "update device d set d.current_area = (select current_area from history h where h.code = :code order by h.id desc Limit 1) where exists (Select 1 from history h where h.code = d.code) AND d.id IS NOT NULL",nativeQuery = true)
    public void returnCurrentArea(@Param("code") String code);
}
