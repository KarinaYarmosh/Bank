package karina.Entity;

import javax.persistence.*;
import java.util.Set;


/*
Айди
Название
Количество филиалов
(10234, банк милениум, 150)
(11294, банк пекао, 200)
 */


@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_branches")
    private Long numberOfBranches;

    @ManyToMany(mappedBy = "banks", fetch = FetchType.LAZY)
    private Set<City> cities;


    @OneToMany(mappedBy="bank",fetch=FetchType.LAZY)
    private Set<Account> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfBranches() {
        return numberOfBranches;
    }

    public void setNumberOfBranches(Long numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }

    public Bank() {
    }


    public Bank(Long id, String name, Long numberOfBranches, Set<City> cities) {
        this.id = id;
        this.name = name;
        this.numberOfBranches = numberOfBranches;
        this.cities = cities;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
