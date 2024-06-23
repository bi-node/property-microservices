package com.binode.owner;


import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;


    @GetMapping
    public ResponseEntity<List<Owner>> getAllProperties() {
        return  ResponseEntity.ok(ownerService.getAllProperties());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getPropertyById(@PathVariable Integer id) {
       return ResponseEntity.ok(ownerService.getOwnerById(id));
    }

    @PostMapping
    public ResponseEntity<Owner> createProperty(@RequestBody Owner owner) {
        return ResponseEntity.ok(ownerService.saveOwner(owner));
    }
    @GetMapping("/with-properties/{owner-id}")
    public ResponseEntity<FullOwnerResponse> getOwnerWithProperties(@PathVariable("owner-id") Integer ownerId) {
        return ResponseEntity.ok(ownerService.findOwnerWithProperties(ownerId));
    }


}
