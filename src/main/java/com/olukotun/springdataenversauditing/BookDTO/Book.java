package com.olukotun.springdataenversauditing.BookDTO;


import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Component
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int pages;


}
