package me.freelife.springjpaprograming;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Comment {

    @Id @GeneratedValue
    private Long id;
    private String comment;

    private Integer likeCount; //Like의 경우 예약어라 오류가 발생함 likeCount로 변경함

    @ManyToOne
    private Post post;
}
