package com.tejait.batch15.repository;

import com.tejait.batch15.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Integer> {
    Optional<Loans> findByMobile(Long mobile);

    Optional<Loans> findByMailId(String mailId);

    Loans findByAppId(int appId);
}