package com.example.openticket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Screen {
    private @Id
    @GeneratedValue
    Long id;
    private int rows;
    private int columns;
    private String rowNames;
    private String columnNames;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Theater theater;

    public Screen(int rows, int columns, String rowNames, String columnNames) {
        this.rows = rows;
        this.columns = columns;
        this.rowNames = rowNames;
        this.columnNames = columnNames;
    }

    public Screen() {

    }
}
