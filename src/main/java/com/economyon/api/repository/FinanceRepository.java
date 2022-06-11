package com.economyon.api.repository;

import com.economyon.api.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> findByUserId(long id);
}
