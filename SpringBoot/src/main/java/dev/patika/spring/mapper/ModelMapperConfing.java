package dev.patika.spring.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration// Bu anatasyon ile bu sınıfın bir konfigürasyon sınıfı olduğunu belirtiyoruz.
public class ModelMapperConfing {
  @Bean// Bu anatasyon ile bu sınıfın bir bean olduğunu belirtiyoruz.// Bean demek bu sınıfın bir nesne olduğunu belirtiyoruz.
  // Bean anahtar kelimesi ile bir sınıfı Spring'e tanıtıyoruz.Böylece Spring bu sınıfı kendi içinde yönetebiliyor.
  // Bu sınıfı Spring'e tanıtmamızın sebebi ise bu sınıfı Controller içinde kullanacağız.
  // Bu sınıfı Controller içinde kullanmamızın sebebi ise Controller içindeki metotlarda Customer sınıfını CustomerDto sınıfına çevirmek için kullanacağız.


    public ModelMapper modelMapper (){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;// Bu şekilde ayarlamaları yapıp sonrasında Controller içine tanımlamamz lazım
    }



}
