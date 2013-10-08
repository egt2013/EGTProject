package com.egt.persistence.util.security;

import com.egt.persistence.entity.MasUserEntity;

public interface PasswordGenerator {
	public String genPassword( MasUserEntity userEntity);
}
