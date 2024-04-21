package ru.kosterror.libraryonline.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String name;

    private String surname;

    private String patronymic;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @OneToMany(mappedBy = "book")
    private List<PersonBookEntity> personBooks;

}
