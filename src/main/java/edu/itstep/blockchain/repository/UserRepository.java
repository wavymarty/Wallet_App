package edu.itstep.blockchain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.itstep.blockchain.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
       User findById(int id);
}
