package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;

@SpringBootApplication
public class ProductCrudOperationsApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx=
		SpringApplication.run(ProductCrudOperationsApplication.class, args);
		
		ProductRepository repo=ctx.getBean(ProductRepository.class);
		
		
	/**	
	//Insert Product
		ProductEntity p1=new ProductEntity();
		//p1.setPid(1);     //Here id created auto increment in database
		p1.setPname("Parle-G");
		p1.setPprice(10.00);
		System.out.println(repo.save(p1));
		
		
		ProductEntity p2=new ProductEntity();
		//p1.setPid(2);    //Here id created auto increment in database
		p2.setPname("20-20");
		p2.setPprice(20.00);
		System.out.println(repo.save(p2));
		**/
		
	//Display All Products
		Iterable<ProductEntity> prodAll=repo.findAll();
		prodAll.forEach(System.out::println);
		
	//Delete by id
		if(repo.findById(4)!=null)
			repo.deleteById(4);
		else
			System.out.println("Record Not Found");
	//Update by id
		Optional<ProductEntity> proOptional=repo.findById(2);
		ProductEntity p3=proOptional.get();
		p3.setPname("Jim-Jam");
		repo.save(p3);
		
		
		
		
	}

}
