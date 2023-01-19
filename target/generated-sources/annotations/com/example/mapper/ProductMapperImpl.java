package com.example.mapper;

import com.example.dto.ProductDTO;
import com.example.entity.Product;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-19T16:13:01+0530",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_352 (Private Build)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO getModelFromEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductName( product.getName() );
        productDTO.setId( product.getId() );
        productDTO.setQuantity( product.getQuantity() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }

    @Override
    public Product getEntityFromModel(ProductDTO product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setName( product.getProductName() );
        product1.setId( product.getId() );
        product1.setQuantity( product.getQuantity() );
        product1.setPrice( product.getPrice() );

        return product1;
    }
}
