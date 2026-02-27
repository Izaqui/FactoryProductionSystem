package com.factory.controller;

import com.factory.dto.ProductionSuggestionDTO;
import com.factory.service.ProductionService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/production")
@Produces(MediaType.APPLICATION_JSON)
public class ProductionController {

    @Inject
    ProductionService productionService;

    @GET
    @Path("/suggest")
    public List<ProductionSuggestionDTO> suggest() {

        return productionService.suggestProduction();

    }
}