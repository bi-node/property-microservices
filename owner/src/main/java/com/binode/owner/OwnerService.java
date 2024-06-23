package com.binode.owner;

import com.binode.owner.client.PropertyClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService {
    private OwnerRepository ownerRepository;
    private PropertyClient propertyClient;

    public Owner saveOwner(Owner owner) {
        ownerRepository.save(owner);
        return owner;

    }

    public List<Owner> getAllProperties() {
        return  ownerRepository.findAll() ;
    }

    public Owner getOwnerById(Integer id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public FullOwnerResponse findOwnerWithProperties(Integer id) {
        var owner = ownerRepository.findById(id).orElse(null);
        var properties=propertyClient.getPropertiesByOwner(id);

        return FullOwnerResponse.builder()
                .fullName(owner.getFullName())
                .phoneNumber(owner.getPhoneNumber())
                .properties(properties)
                .build();
    }
}
