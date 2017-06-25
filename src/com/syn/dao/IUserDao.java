package com.syn.dao;

import com.syn.model.User;
import com.syn.utils.SynExceptionHAndler;

public interface IUserDao {

	public User getData(User user) throws SynExceptionHAndler;

	}
