package com.binode.owner;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FullOwnerResponse {
    private String fullName;
    private String phoneNumber;
    private List<Property> properties;
}
