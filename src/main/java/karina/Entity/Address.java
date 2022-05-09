package karina.Entity;


import javax.persistence.*;

@Entity
@Table(name ="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Long house;

    private int index;

    private int numOfFlat;

    @OneToOne(mappedBy = "address")
    private Client client;
}


