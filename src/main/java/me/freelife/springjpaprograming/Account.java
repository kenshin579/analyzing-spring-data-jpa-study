package me.freelife.springjpaprograming;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "owner") //@OneToMany쪽에 양방향 설정 (owner가 fk쪽이라는 곳을 지정하여 알려주는 거임)
    private Set<Study> studies = new HashSet<>();

    //편의 메서드
//    public void addStudy(Study study) {
//        this.getStudies().add(study);
//        study.setOwner(this);
//    }
//
//    public void removeStudy(Study study) {
//        this.getStudies().remove(study);
//        study.setOwner(null);
//    }

}
