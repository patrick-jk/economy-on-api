package com.economyon.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class Finance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private float value;
    @JsonProperty("initial_date")
    private Date initialDate;
    @JsonProperty("final_date")
    private Date finalDate;
    @JsonProperty("user_id")
    @ManyToOne
    private User user;
}
