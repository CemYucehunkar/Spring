package dev.patika.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    //Customer clasının DTO sınıfı oluşturmak için gerekli kodlar neler aşağıda görelim.
    private String name;
    private String email;
    private int id;

}
