package com.to.backend.repository;

import com.to.backend.model.HeroItemInBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagRepository extends JpaRepository<HeroItemInBag,Long> {
}
