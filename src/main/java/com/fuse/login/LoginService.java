package com.fuse.login;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginService implements UserDetailsService {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Collection<Login> findAll() {
		return this.loginRepository.findAll();
	}

	public Login findOne(String id) {
		return loginRepository.findOne(id);
	}

	public Login save(Login login) {
		// Encrypt the password
		login.setPassword(passwordEncoder.encode(login.getPassword()));
		// Set the authorities
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.createAuthorityList(login.getRoles().toArray(new String[login.getRoles().size()]));
		login.setGrantedAuthorities(grantedAuthorities);
		return loginRepository.save(login);
	}

	/*
	 * WARNING!! If all the values are not provided during update, this might result
	 * in inconsistent data
	 */
	public Login updateAllFields(String id, Login login) {
		Login loginToUpdate = loginRepository.findOne(id);
		loginToUpdate.setUsername(login.getUsername());
		loginToUpdate.setPassword(login.getPassword());
		// TODO Update authority
		return loginRepository.save(loginToUpdate);
	}

	public void delete(String id) {
		loginRepository.delete(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login userDetails = loginRepository.findByUsername(username);		
		return userDetails;
	}

}
