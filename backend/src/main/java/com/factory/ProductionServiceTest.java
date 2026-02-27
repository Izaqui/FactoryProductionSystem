package com.factory;

import com.factory.service.ProductionService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ProductionServiceTest {

    @Inject
    ProductionService service;

    @Test
    public void testProductionSuggestion() {

        var result = service.suggestProduction();

        assertNotNull(result);
    }
}