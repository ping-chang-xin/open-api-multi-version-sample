package com.sample.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    @Schema(
            description = "Product Id",
            example = "123"
    )
    private Long id;

    @Schema(
            description = "Product Name",
            example = "Bond"
    )
    private String name;

    @Schema(
            description = "Product Description",
            example = "Fixed Bond Product"
    )
    private String desc;

}
