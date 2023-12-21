package com.mrzzom.simple2.mapper;

import com.mrzzom.simple2.model.product.Category;
import com.mrzzom.simple2.model.product.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper =  new ModelMapper();

        modelMapper.createTypeMap(Product.class, Category.class)
                .<String>addMapping(src -> src.getCategory().getName(), (dest, value) -> dest.setName(value));

        return modelMapper;
    }

}
