package edu.itstep.blockchain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itstep.blockchain.domain.Issue;
import jakarta.transaction.Transactional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{
    List<Issue> findByIssueId(Long id);
    @Transactional
    void deleteById(Long idIssue);
}
