package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
List<Product> findProductBySize(String size);

@Query(value="select * from product p where p.price :=start and :=end",nativeQuery=true)
List<Product> findProductByPrice(@Param("start") int start, @Param("end") int end);

List<Product> findProducyByColor(String color);

@Query(value="select * from product p where p.pname like %:=pname%",nativeQuery=true)
List<Product> findProductByPname(@Param("pname") String pname);

@Query(value="select * from product p where p.pid = :=pid",nativeQuery=true)
Product findOneProductByPid(@Param("pid") int pid);
}
