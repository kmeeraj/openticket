package com.example.openticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Theater {
    private @Id
    @GeneratedValue
    Long id;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "theater")
    @JsonIgnore
    private Set<Screen> screens = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theater)) return false;
        Theater theater = (Theater) o;
        return getAddress().equals(theater.getAddress()) && getCity().equals(theater.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getCity());
    }

    @Override
    public String toString() {
        return "Theater{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }
}
