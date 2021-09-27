package com.gomesmatheus.dscatalog.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gomesmatheus.dscatalog.dto.ProductDTO;
import com.gomesmatheus.dscatalog.entities.Product;
import com.gomesmatheus.dscatalog.repositories.ProductRepository;
import com.gomesmatheus.dscatalog.services.exceptions.ResourcecNotFoundException;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository repository;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	public void testFindById() {
		Product product = new Product(1L, "Phone", "Good Phone", 800.0, "https://img.com/img.png", Instant.parse("2020-10-20T03:00:00Z"));
		
		// ARRANJE
		when(repository.findById(any()))
			.thenReturn(Optional.of(product));
		
		// ACT
		ProductDTO productDTO = service.findById(1L);
		
		// ASSERT
		assertNotNull(productDTO);
		assertEquals(1L, productDTO.getId());
	}
	
	@Test
	public void testFindByInexistingId() {
		// ARRANJE
		when(repository.findById(any()))
			.thenReturn(Optional.empty());
		
		// ACT / ASSERT
		assertThrows(ResourcecNotFoundException.class, () -> {
			service.findById(1L);
		});
	}

}
