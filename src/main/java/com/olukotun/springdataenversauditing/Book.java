package com.olukotun.springdataenversauditing;


import lombok.*;
import org.hibernate.envers.Audited;

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
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private int pages;


}
