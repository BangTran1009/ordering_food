package com.team3.config;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfiguration {
    @Bean
    public com.cloudinary.Cloudinary cloudinary() {
        return new com.cloudinary.Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dggnkthlu",
                "api_key", "935952656844469",
                "api_secret", "tnQvfOqw8Q-LVf9PuhpzdaZquEc",
                "secure", true));
    }
}
