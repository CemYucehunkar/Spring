package dev.patika.spring;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_id")
        private int id;
        @Column(name = "customer_name")
        String name;
        @Column(name = "customer_email")
        private String email;
        @Column(name = "customer_birthday")
        private LocalDate onDate;
        @Column(name = "customer_gender")
        private GENDER gender;

        public enum GENDER {
            MALE,
            FAMALE;
        }


}
