package com.digitalSupport.seasonalInformation.repository;


import com.digitalSupport.seasonalInformation.model.MasterSeasonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterSeasonalInfoRepository extends JpaRepository<MasterSeasonalInfo, Long> {

    List<MasterSeasonalInfo> findByProduct(String Product);
}
