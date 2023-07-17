package com.eshoppingzone.produt.productservice.resource;

import java.io.IOException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.eshoppingzone.produt.exception.ProductCategoryNotFoundException;
import com.eshoppingzone.produt.exception.ProductNotFoundException;
import com.eshoppingzone.produt.exception.ProductTypeNotExistsException;
//import com.eshoppingzone.produt.exception.SequenceException;
//import com.eshoppingzone.produt.productservice.entity.Image;
import com.eshoppingzone.produt.productservice.entity.LoggerResponse;
import com.eshoppingzone.produt.productservice.entity.Product;
//import com.eshoppingzone.produt.productservice.entity.SequenceId;
import com.eshoppingzone.produt.productservice.service.ProductServiceImpl;
//import com.eshoppingzone.produt.productservice.service.SequenceDao;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ProductResource {

	@Autowired
	ProductServiceImpl productServiceImpl;
	

	Logger logger = LoggerFactory.getLogger(LoggerResponse.class);

	@RequestMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() throws ProductNotFoundException {
		return ResponseEntity.ok(productServiceImpl.getAllProduct());
	}
	

	@GetMapping("/findById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId)
			throws ProductNotFoundException {
		return ResponseEntity.ok(productServiceImpl.getProductById(productId));
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductNotFoundException{
//		long sequenceid = sequenceDao.getNextSequenceId("product");
//		System.out.println("*********" + sequenceid + "********");
//		product.setProductId(sequenceid);
		return ResponseEntity.ok(productServiceImpl.addProduct(product));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProducts(@PathVariable long id,@RequestBody Product product) throws ProductNotFoundException {
		logger.info("Existing data has been updated");
		return ResponseEntity.ok(productServiceImpl.updateProducts(product));
	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId") long productId)
			throws ProductNotFoundException {
		productServiceImpl.deleteProductById(productId);
		return new ResponseEntity<>("Deleted Sucessfully", HttpStatus.OK);
	}

	@GetMapping("/findByName/{productName}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName)
			throws ProductNotFoundException {
		logger.info("Retrieving product by product name");
		return ResponseEntity.ok(productServiceImpl.getProductByName(productName));
	}

	@GetMapping("/findByCategory/{category}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("category") String category)
			throws ProductCategoryNotFoundException {
		logger.info("Retrieving Product by Product category");
		return ResponseEntity.ok(productServiceImpl.getProductByCategory(category));
	}

	@GetMapping("/findByType/{productType}")
	public ResponseEntity<List<Product>> getProductByType(@PathVariable("productType") String productType)
			throws ProductTypeNotExistsException {
		logger.info("Retrieving Product by Product Type");
		return ResponseEntity.ok(productServiceImpl.getProductByType(productType));
	}
	

}
