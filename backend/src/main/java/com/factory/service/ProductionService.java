package com.factory.service;

import com.factory.dto.ProductionSuggestionDTO;
import com.factory.entity.Product;
import com.factory.entity.ProductMaterial;
import com.factory.entity.RawMaterial;
import com.factory.repository.ProductMaterialRepository;
import com.factory.repository.ProductRepository;
import com.factory.repository.RawMaterialRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.*;

@ApplicationScoped
public class ProductionService {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductMaterialRepository productMaterialRepository;

    @Inject
    RawMaterialRepository rawMaterialRepository;

    public List<ProductionSuggestionDTO> suggestProduction() {

        List<Product> products = productRepository.findAllOrderByPriceDesc();

        Map<Long, Double> stock = new HashMap<>();

        for (RawMaterial rm : rawMaterialRepository.listAll()) {
            stock.put(rm.id, rm.stockQuantity);
        }

        List<ProductionSuggestionDTO> result = new ArrayList<>();

        for (Product product : products) {

            List<ProductMaterial> materials =
                    productMaterialRepository.findByProduct(product);

            int maxProduction = Integer.MAX_VALUE;

            for (ProductMaterial material : materials) {

                double available =
                        stock.get(material.rawMaterial.id);

                int possible =
                        (int)(available / material.quantityRequired);

                maxProduction = Math.min(maxProduction, possible);
            }

            if (maxProduction > 0) {

                for (ProductMaterial material : materials) {

                    long materialId = material.rawMaterial.id;

                    stock.put(
                        materialId,
                        stock.get(materialId) -
                        material.quantityRequired * maxProduction
                    );
                }

                result.add(
                        new ProductionSuggestionDTO(
                                product.name,
                                maxProduction,
                                product.price * maxProduction
                        )
                );
            }

        }

        return result;
    }
}