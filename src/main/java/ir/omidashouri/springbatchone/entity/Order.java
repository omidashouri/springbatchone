package ir.omidashouri.springbatchone.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_ORDER",schema = "test")
public class Order implements Serializable {


    @Id
    private Long orderId;

    @Column(name = "NAME")
    private String name;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "COST")
    private Float cost;
    @Column(name = "ITEM_ID")
    private String itemId;
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "SHIP_DATE")
    private Date shipDate;

}
