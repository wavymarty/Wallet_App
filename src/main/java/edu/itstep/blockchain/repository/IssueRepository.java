package edu.itstep.blockchain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itstep.blockchain.domain.Issue;
import jakarta.transaction.Transactional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{
    Optional<Issue> findById(Long id);
    @Transactional
    void deleteById(Long idIssue);
}
