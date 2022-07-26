package com.opsyx.openapi.sample.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties( prefix = "pets.api")
@Data
public class PetFeignClientProperties extends AbstractFeignProperties{
}
