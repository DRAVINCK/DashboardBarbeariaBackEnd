package com.dravinck.dashboardbarbearia.repository;

import com.dravinck.dashboardbarbearia.entity.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}
