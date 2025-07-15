package com.begin.advertisement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    Optional<Advertisement> findById(int id);

    List<Advertisement> findByAdvSubCategoryID(int subCategoryID);
    List<Advertisement> findByAdvUserID(int advUserID);

}
