package com.ads.system.ads.repository;

import com.ads.system.ads.model.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisingRepository extends JpaRepository<Advertising, Long> {
    List<Advertising> findByClient(String client);
}
