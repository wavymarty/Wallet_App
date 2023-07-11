package edu.itstep.blockchain;

import edu.itstep.blockchain.domain.User;

public interface UserService {
	public User saveUpdatePerson(User person);
    public User findPersonById(Integer id);
}
