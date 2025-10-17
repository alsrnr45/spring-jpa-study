package org.jpa.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jpa.order.domain.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String city;
    
    @Column
    private String street;
    
    @Column
    private String zipCode;
    
    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();
}