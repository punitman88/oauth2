package com.fuse.login;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Login>> getLogins() {
		return new ResponseEntity<>(loginService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Login> getLogin(@PathVariable String id) {
		return new ResponseEntity<>(loginService.findOne(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addLogin(@RequestBody Login login) {
		System.out.println("Hello " + login);
		return new ResponseEntity<>(loginService.save(login), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateLogin(@PathVariable String id, @RequestBody Login login) {
		return new ResponseEntity<>(loginService.updateAllFields(id, login), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLogin(@PathVariable String id) {
		loginService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
