package com.egt.persistence.util.security;

import com.egt.persistence.entity.UserBean;

public interface PasswordGenerator {
	public String genPassword( UserBean userBean );
}
