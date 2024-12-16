package com.example.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressToDto {
    private String addressType;
    private String houseNo;
    private String streetName;
    private String city;
    private String state;
    private String pinCode;
}
