package com.example.ProductsApplication.Controllers;

import java.sql.Date;
//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductsApplication.Entities.Products;
import com.example.ProductsApplication.Repositories.ProductRepository;


@RestController
@RequestMapping("/Products")
public class ProductController {

	
	@Autowired
	ProductRepository productRepository;
	@PostMapping("/AddProducts")
	public ResponseEntity<Products> addProducts(@RequestBody Products products) {
		ResponseEntity response=null;
		try {
		productRepository.save(products);
		response= new ResponseEntity<String>(
                "Product added",HttpStatus.CREATED);
        }
		catch(Exception e){
            response=new ResponseEntity<String>("Adding products failed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	@GetMapping("/getProducts")
	@ResponseStatus(HttpStatus.OK)
	public List<Products> getProducts(){
		
		return productRepository.findAll();
	}
	
	
	
	//put
	
	@PutMapping("/productsUpdate/{id}")                                   
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id, @RequestBody  Products products) {

		ResponseEntity<String> response = null;
		
		Optional<Products> productid = productRepository.findById(id);
        
		if (productid.isPresent()) {
			products.id=id;
			productRepository.save(products);
			
			response= new ResponseEntity<String>(
	                "Product Updated",HttpStatus.CREATED);
			return response;
		} else
			response = new ResponseEntity<>("Product not Found",HttpStatus.NOT_FOUND);
		return response;

	}
	
	//delete
	@DeleteMapping("/productDelete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id, @RequestBody  Products products) {

		ResponseEntity<String> response = null;
		
		Optional<Products> productid = productRepository.findById(id);
        
		if (productid.isPresent()) {
			productRepository.deleteById(id);
			
			response= new ResponseEntity<String>(
	                "Product is deleted",HttpStatus.OK);
			return response;
		} else
			response = new ResponseEntity<>("Product not Found",HttpStatus.NOT_FOUND);
		return response;

     }
	
	//findMethods......
	@GetMapping("/findbyname")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Products>> getProductByName(@RequestParam("name") String name) {
    	List<Products> product=productRepository.findByName(name);
    	ResponseEntity<List<Products>> response=null;
    	if(product.isEmpty()) {
    			response =new ResponseEntity<List<Products>>(HttpStatus.NOT_FOUND);
    		return response;
    	}
    		
    	else {
    	response =new ResponseEntity<List<Products>>(product,HttpStatus.OK);
    	return response;
    	}
	}
	
	@GetMapping("/Descriptioncontains")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Products>> getDescriptionContaining(@RequestParam("description") String description){
    	List<Products> product=productRepository.findByDescriptionContaining(description);
    	ResponseEntity<List<Products>> response=null;
    	if(product.isEmpty()) {
    			response =new ResponseEntity<List<Products>>(HttpStatus.NOT_FOUND);
    		return response;
    	}
    		
    	else {
    	response =new ResponseEntity<List<Products>>(product,HttpStatus.OK);
    	return response;
    	}
    }
	
	@GetMapping("/pricegreaterthan")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Products>> getPrice(@RequestParam("price") double price){
    	List<Products> product=productRepository.findByPriceGreaterThan(price);
    	ResponseEntity<List<Products>> response=null;
    	if(product.isEmpty()) {
    			response =new ResponseEntity<List<Products>>(HttpStatus.NOT_FOUND);
    		return response;
    	}
    		
    	else {
    	response =new ResponseEntity<List<Products>>(product,HttpStatus.OK);
    	return response;
    	}
    		
    }
	@GetMapping("/samemanufacturedate")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Products>> getSameDate(@RequestParam("mfd") Date mfd){
		List<Products> product=productRepository.findByManufacturingDateEquals(mfd);
		ResponseEntity<List<Products>> response=null;
    	if(product.isEmpty()) {
    			response =new ResponseEntity<List<Products>>(HttpStatus.NOT_FOUND);
    		return response;
    	}
    		
    	else {
    	response =new ResponseEntity<List<Products>>(product,HttpStatus.OK);
    	return response;
    	}
	}
	
	 @GetMapping("/orderbyname")
//	 @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<List<Products>> getEmployeeByNameByOrder() {
	    	List<Products> product=productRepository. findByOrderByName();
	    	ResponseEntity<List<Products>> response=null;
	    	if(product.isEmpty()) {
	    			response =new ResponseEntity<List<Products>>(HttpStatus.NOT_FOUND);
	    		return response;
	    	}
	    		
	    	else {
	    	response =new ResponseEntity<List<Products>>(product,HttpStatus.OK);
	    	return response;
	    	}
			
		}
//	 @PutMapping("/productsUpdate/{id}/{price}")                                   
//		public ResponseEntity<String> updatePrice(@PathVariable("id") int id,@PathVariable("price") double price ,@RequestBody  Products products) {
//
//			ResponseEntity<String> response = null;
//			
//			Optional<Products> productid = productRepository.findById(id);
//	        
//			if (productid.isPresent()) {
//				products.id=id;
//				products.price=price;
//				productRepository.save(products);
//				
//				response= new ResponseEntity<String>(
//		                "Product Updated",HttpStatus.CREATED);
//				return response;
//			} else
//				response = new ResponseEntity<>("Product not Found",HttpStatus.NOT_FOUND);
//			return response;
//
//		}
//	
//	 public ResponseEntity<String> error(){
//		 ResponseEntity<String> response = new ResponseEntity<>("Product not Found",HttpStatus.NOT_FOUND);
//			return response;
	 }

