package org.example.repository;

import org.example.dao.DueCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DueCreditRepository extends JpaRepository<DueCredit, Integer> {

    DueCredit findByCreditId(String creditId);
}
