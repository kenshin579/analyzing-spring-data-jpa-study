package me.freelife.springjpaprograming;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import static javax.persistence.TemporalType.*;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    private LocalDateTime created = LocalDateTime.now();
    @Temporal(TIME)
    private Date updated = new Date();

    private String yes;
    @Transient
    private String no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;
}
