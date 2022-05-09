package karina.Entity;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

/*
Таблица связи банки-города (мэни ту мэни)
Айди банка - айди города
(10234, 110101)
(11294, 110101)
(10234, 10101)
 */

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pesel")
    private Long pesel;

    @Column(name = "date_of_birth")
    private ZonedDateTime DateOfBirth;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


//    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
//    private Set<Account> accounts;

    public ZonedDateTime getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(ZonedDateTime dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public Client() {
    }

    public Client(Long id, String firstName, String lastName, Long pesel, ZonedDateTime dateOfBirth, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        DateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client {" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name=" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", date_of_birth'" + DateOfBirth + '\'' +
                ", address'" + address +
                '}';
    }
}
