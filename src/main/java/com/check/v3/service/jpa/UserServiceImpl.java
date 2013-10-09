package com.check.v3.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.check.v3.domain.User;
import com.check.v3.repository.UserRepository;
import com.check.v3.service.UserService;

@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly=true)
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public User findByAccount(String account) {
		return userRepository.findByAccount(account);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

}
