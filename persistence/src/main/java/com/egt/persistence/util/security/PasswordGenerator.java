package com.egt.persistence.util.security;

import com.egt.persistence.entity.User;

public interface PasswordGenerator {
	public String genPassword( User userEntity);
}
