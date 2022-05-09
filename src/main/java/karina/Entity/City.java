package karina.Entity;

/*
Айди города
Название города
 */

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "city_bank",
            joinColumns = {@JoinColumn(name = "city_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bank_id", referencedColumnName = "id")})
    private Set<Bank> banks;

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

    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    public City() {
    }

    public City(Long id, String name, Set<Bank> banks) {
        this.id = id;
        this.name = name;
        this.banks = banks;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", banks=" + banks +
                '}';
    }
}
