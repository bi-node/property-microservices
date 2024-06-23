package com.binode.property;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {
    private  PropertyRepository propertyRepository;

    public Property saveProperty( Property property) {
        propertyRepository.save(property);
        return  property;

    }

    public List<Property> getAllProperties() {
        return  propertyRepository.findAll() ;
    }

    public Property getPropertyById(Integer id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public List<Property> findAllPropertiesByOwner(Integer ownerId) {
        return propertyRepository.findAllByOwnerId(ownerId);
    }
}
