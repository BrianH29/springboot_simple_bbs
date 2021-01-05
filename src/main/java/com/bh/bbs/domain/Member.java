package com.bh.bbs.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Setter
@Getter
@Entity
@ToString
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String pwd;
    private String email;

}
