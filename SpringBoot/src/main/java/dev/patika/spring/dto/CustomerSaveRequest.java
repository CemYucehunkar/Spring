package dev.patika.spring.dto;

import dev.patika.spring.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    private  int id;
    private String name;
    private String email;

    private Customer.GENDER gender;
}
