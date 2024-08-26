package com.sample.controller;

import com.sample.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Tag(
        name = "product-controller-v2",
        description = "Support for product related operations"
)
@RestController
@RequestMapping("/product/v2")
public class ProductControllerV2 {

    @Operation(
            summary = "Update a product",
            description = "Update a product with the specified id"
    )
    @ApiResponse(responseCode = "200", description = "Successfully updated the product.")
    @ApiResponse(
            responseCode = "404",
            description = "Product not found",
            content = @Content(
                    mediaType = "text/plain",
                    schema = @Schema(type = "string"),
                    examples = {@ExampleObject(value = "Product Not Found")})
    )
    @PatchMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public void updateProduct(
            @Parameter(description = "Product Id", example = "123")
            @PathVariable("id")
            Long id,
            @RequestBody Product product) {
        System.out.println("Successfully updated the product" + id);
    }

}
