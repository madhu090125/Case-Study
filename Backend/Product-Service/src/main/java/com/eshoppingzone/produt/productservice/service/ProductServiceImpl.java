package com.eshoppingzone.produt.productservice.service;

import java.util.Collections;
import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.eshoppingzone.produt.exception.ProductCategoryNotFoundException;
import com.eshoppingzone.produt.exception.ProductNotFoundException;
import com.eshoppingzone.produt.exception.ProductTypeNotExistsException;
import com.eshoppingzone.produt.productservice.entity.Product;
import com.eshoppingzone.produt.productservice.repository.ProductRepository;

@Service
@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public List<Product> getAllProduct() throws ProductNotFoundException {
		logger.info("Get all Product is started");
		List<Product> findAllProduct = productRepository.findAll();
		if(!findAllProduct.isEmpty()) {
		logger.info("If condition for Get all Product is Started");
		logger.debug("Details of products are :{}",findAllProduct);
		List<Product> findAll = productRepository.findAll();
		Collections.sort(findAll ,(o1,o2)->o1.getProductName().compareTo(o2.getProductName()));
		return findAll;
		}
		else {
			logger.info("If Else condition for Get all Product is Executed");
			throw new ProductNotFoundException("No data's found");
		}

	}

	@Override
	public Product getProductById(long productId) throws ProductNotFoundException {
		logger.info("Get Product By Id is started");
		Optional<Product> getProductById = productRepository.findById(productId);
		if (getProductById.isPresent()) {
			logger.info("If condition of get product by is started");
			logger.debug("Details of product by id :{}",getProductById);
			return getProductById.get();
		} else {
			logger.info("If else condition of get product by is Executed");
			return getProductById.orElseThrow(() -> new ProductNotFoundException(productId + "Product is not found"));
		}

	}

	@Override
	public Product addProduct(Product product) throws ProductNotFoundException {
		logger.info("Add Product method is started");
		return productRepository.insert(product);
	}

	@Override
	public Product updateProducts(Product product)throws ProductNotFoundException  {
		logger.info("Update Product method started");
		return productRepository.save(product);
	}

	@Override
	public String deleteProductById(long productId) throws ProductNotFoundException{
		logger.info("Delete Product method is started");
		Optional<Product> delete = productRepository.findById(productId);
		if(delete.isPresent()) {
			logger.info("If condition for delete product id started");	
			productRepository.deleteById(productId);
			return "Product with id"+productId+"is deleted successfully";
		}
		else {
			logger.info("If else condition of delete product is executed");
			throw new ProductNotFoundException("Product doesn't Exists");
		}

	}
	

	@Override
	public List<Product> getProductByName(String productName)throws ProductNotFoundException {
		logger.info("Get Product By Name is started");
		List<Product> findByProductName = productRepository.findByProductName(productName);
			  if (!findByProductName.isEmpty()) {
			  logger.info("If condition of get product by name started");
			  logger.debug("Details of product by name :{}",findByProductName);
			  return productRepository.findByProductName(productName);
			  } 
			  else {
			  logger.info("If else condition of get product by is Executed"); 
			  throw new ProductNotFoundException(productName+" does not exists");
			 
	}
}
	
	@Override
	public List<Product> getProductByCategory(String category)throws ProductCategoryNotFoundException {
		logger.info("Get Product By Category is started");
		 List<Product> findByCategory = productRepository.findByCategory(category);
			  if (!findByCategory.isEmpty()) {
			  logger.info("If condition of get product by category started");
			  logger.debug("Details of product by category :{}",findByCategory);
			  return productRepository.findByCategory(category);
			  } 
			  else {
			  logger.info("If else condition of get product by is Executed"); 
			  throw new ProductCategoryNotFoundException(category+" Does not exists ");	 
	}
}

	@Override
	public List<Product> getProductByType(String productType) throws ProductTypeNotExistsException{
		logger.info("Get Product by Type is Started");
		List<Product> findByProductType = productRepository.findByProductType(productType);
		if(!findByProductType.isEmpty()) {
			logger.info("If condition for get product by type is started");
			logger.info("Details of product by type :{}",findByProductType);
			return productRepository .findByProductType(productType);
		}
		else {
			logger.info("If else condition for get by product tyoe is executed");
			throw new ProductTypeNotExistsException(productType+" Does not exists");
		}
	}
}
