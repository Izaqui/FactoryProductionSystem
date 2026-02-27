package com.factory.repository;

import com.factory.entity.Product;
import com.factory.entity.ProductMaterial;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProductMaterialRepository implements PanacheRepository<ProductMaterial> {

    public List<ProductMaterial> findByProduct(Product product) {
        return list("product", product);
    }

}