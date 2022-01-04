package com.example.openticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class City{
    private @Id
    @GeneratedValue
    Long id;
    private String cityName;
    private String state;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "city")
    @JsonIgnore
    private Set<Theater> theaters = new HashSet<>();

    public City(String cityName,String state) {
        this.cityName = cityName;
        this.state = state;
    }

    public City() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getCityName().equals(city.getCityName()) && getState().equals(city.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getState());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
