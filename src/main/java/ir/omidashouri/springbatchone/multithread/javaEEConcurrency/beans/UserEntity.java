package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;




// Attention table name and field names are case sensitive in mariadb

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SequenceGenerator(name = "entity_sequence",schema = "test", sequenceName = "user1",allocationSize = 1)
@Table(name = "TBL_USER_CON",schema = "test")
public class UserEntity implements Serializable {

//    @GeneratedValue(generator = "entity_sequence", strategy = GenerationType.SEQUENCE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MYID")
    private Long myId;

    @Column(name="NAME")
    private String name;

    @Column(name = "EMAIL")
    private String emailAddress;
}
