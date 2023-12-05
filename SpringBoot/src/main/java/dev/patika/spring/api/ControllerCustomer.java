package dev.patika.spring.api;

import dev.patika.spring.Customer;
import dev.patika.spring.business.abstracts.ICustomerServis;
import dev.patika.spring.dto.CustomerDto;
import dev.patika.spring.dto.CustomerSaveRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController// Bu anatasyon vermemizin sebebi Tarayıcıdan bir istek geldiğinde bu sınıftan
// işlem yapabilirim demek.
// 2. olarak Bu anatasyon ise Tarayıcıdan gelen isteğe cevap vermek için kullanılır.
@RequestMapping("/customer")
// 3. olarak Bu anatasyon ise Tarayıcıdan gelen isteğin hangi url ile geleceğini belirtir.Yani ne yazarsak Customer sınıfı çalışıssın
public class ControllerCustomer {
   @Autowired
    private final ICustomerServis customerServis;

    @Autowired
     private ModelMapper modelMapper;
    public ControllerCustomer(ICustomerServis customerServis) {
        this.customerServis = customerServis;
    }

/*@PostMapping("/save")// Bu metot ile şu amaçlanmaktıdır. Tarayıcıdan bir istek geldiğinde bu metot çalışsın.
    public Customer save (@RequestBody CustomerSaveRequest customerSaveRequest){
        Customer newcustomer=modelMapper.map(customerSaveRequest,Customer.class);
        newcustomer.setOnDate(LocalDate.now());
        return customerServis.save(newcustomer);
 
    }
@DeleteMapping("/{id}")
    public CustomerDto deleteById(@PathVariable("id") int id){
    modelMapper.map(customerServis.deleteById(id),CustomerDto.class);// id kısmı hata veriyor ç
};*/
@GetMapping("/{id}")
    public CustomerDto getById(@PathVariable("id") int id) {
        return modelMapper.map(customerServis.getById(id),CustomerDto.class);

    }


}


