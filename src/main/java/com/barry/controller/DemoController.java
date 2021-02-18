package com.barry.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barry.model.Product;
import com.barry.model.User;
import com.barry.repository.CustomerRowMapper;
import com.barry.repository.ProductRowMapper;
import com.barry.repository.UserRepository;

@RestController
@RequestMapping("/two")
public class DemoController {

	@Autowired
	UserRepository daoUser;
	
	@Qualifier("jdbctemplate1")
	@Autowired
	JdbcTemplate graphTemplate;
	
	@Autowired
	
//	@Autowired
//	@Qualifier("jdbctemplate1")
//	private JdbcTemplate graphTemplate;
//
//	@Autowired
//	@Qualifier("jdbctemplate2")
//	private JdbcTemplate userTemplate;

	

	@GetMapping(value = "/products")
	public List<Product> getProduct() {
		String query = " select * from products";
		return graphTemplate.query(query, new ProductRowMapper());
	}

	@GetMapping(value = "/users")
	public List<User> getMYUser() {
		return daoUser.findAll();
	
	}
}