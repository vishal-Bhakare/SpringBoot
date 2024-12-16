package com.example.dto;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoToAddress {
    @NotBlank(message = "Address type cannot be blank")
    @Pattern(regexp = "^(Current|Permanent)$", message = "Enter Valid Option (e.g : Current | Permanent)")
    private String addressType;
    private String houseNo;
    private String streetName;
    private String city;
    private String state;
    private String pinCode;

}
