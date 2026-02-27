package com.factory.controller;

import com.factory.entity.RawMaterial;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/materials")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RawMaterialController {

    @GET
    public List<RawMaterial> list() {
        return RawMaterial.listAll();
    }

    @GET
    @Path("/{id}")
    public RawMaterial get(@PathParam("id") Long id) {
        return RawMaterial.findById(id);
    }

    @POST
    @Transactional
    public RawMaterial create(RawMaterial material) {
        material.persist();
        return material;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public RawMaterial update(@PathParam("id") Long id, RawMaterial material) {

        RawMaterial entity = RawMaterial.findById(id);

        entity.code = material.code;
        entity.name = material.name;
        entity.stockQuantity = material.stockQuantity;

        return entity;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id) {
        RawMaterial.deleteById(id);
    }
}