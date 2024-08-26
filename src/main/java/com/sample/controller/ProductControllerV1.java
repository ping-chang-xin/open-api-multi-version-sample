package com.sample.controller;

import com.sample.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "product-controller-v1",
        description = "Support for product related operations"
)
@RestController
@RequestMapping("/product/v1")
public class ProductControllerV1 {

    @Operation(
            summary = "Get product list",
            description = "Returns all products"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all products.")
    })
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getList() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setName("prod name" + i);
            product.setDesc("this is " + i + "th prod");
            productList.add(product);
        }
        return productList;
    }


    @Operation(
            summary = "Get a product by id",
            description = "Returns a product with the specified id"
    )
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the product.")
    @ApiResponse(
            responseCode = "404",
            description = "Product not found",
            content = @Content(
                    mediaType = "text/plain",
                    schema = @Schema(type = "string"),
                    examples = {@ExampleObject(value = "Product Not Found")})
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getDetail(
            @Parameter(description = "Product Id", example = "123")
            @PathVariable("id")
            Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("prod name" + id);
        product.setDesc("this is product " + id);
        return product;
    }

}
