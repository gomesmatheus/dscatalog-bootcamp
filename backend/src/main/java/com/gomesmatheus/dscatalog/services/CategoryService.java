package com.gomesmatheus.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gomesmatheus.dscatalog.dto.CategoryDTO;
import com.gomesmatheus.dscatalog.entities.Category;
import com.gomesmatheus.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(CategoryDTO::new).collect(Collectors.toList());
	}
	
}
