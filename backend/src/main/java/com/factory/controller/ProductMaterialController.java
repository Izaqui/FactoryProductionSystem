package com.factory.controller;

import com.factory.entity.Product;
import com.factory.entity.ProductMaterial;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product-materials")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductMaterialController {

    @GET
    public List<ProductMaterial> list() {
        return ProductMaterial.listAll();
    }

    @GET
    @Path("/product/{productId}")
    public List<ProductMaterial> listByProduct(@PathParam("productId") Long productId) {

        Product product = Product.findById(productId);

        return ProductMaterial.list("product", product);
    }

    @POST
    @Transactional
    public ProductMaterial create(ProductMaterial pm) {
        pm.persist();
        return pm;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        ProductMaterial.deleteById(id);
    }
}