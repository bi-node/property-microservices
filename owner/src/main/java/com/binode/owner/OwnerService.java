package com.binode.owner;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService {
    private OwnerRepository ownerRepository;

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
}
