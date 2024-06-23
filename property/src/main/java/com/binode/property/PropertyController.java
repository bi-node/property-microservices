package com.binode.property;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/properties")
public class PropertyController {
    private final PropertyService propertyService;
    private final ServerProperties serverProperties;

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return  ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Integer id) {
       return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return ResponseEntity.ok(propertyService.saveProperty(property));
    }

    //communicating with owner
    @GetMapping("/owners/{owner-id}")
    public ResponseEntity<List<Property>> getPropertyByOwner(@PathVariable("owner-id") Integer ownerId) {
        return ResponseEntity.ok(propertyService.findAllPropertiesByOwner(ownerId));
    }

}
