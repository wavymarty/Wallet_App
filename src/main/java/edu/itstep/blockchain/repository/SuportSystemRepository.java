package edu.itstep.blockchain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itstep.blockchain.domain.SupportSystem;

@Repository
public interface SuportSystemRepository extends JpaRepository<SupportSystem, Long> {
     List<SupportSystem> findByStatus(boolean status);
     List<SupportSystem> findByTitleContaining(String title);
}
