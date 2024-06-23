package com.binode.owner.client;

import com.binode.owner.Property;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="property-service", url="${application.config.properties-url}")
public interface PropertyClient {

    @GetMapping("/owners/{owner-id}")
    List<Property> getPropertiesByOwner(@PathVariable("owner-id") Integer ownerId);

}
