package com.binode.owner;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Property {
    private String name;
    private double price;
}
