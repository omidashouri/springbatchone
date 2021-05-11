package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans;


import io.micrometer.core.annotation.Counted;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SequenceGenerator(name = "entity_sequence",schema = "test", sequenceName = "user1",allocationSize = 1)
@Table(name = "TBL_USER_!",schema = "test")
public class UserEntity implements Serializable {
//    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
//    @GeneratedValue(generator = "entity_sequence", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IDD")
    private int idd;

    @Column(name="NAME")
    private String name;

    @Column(name = "EMAIL")
    private String emailAddress;
}
