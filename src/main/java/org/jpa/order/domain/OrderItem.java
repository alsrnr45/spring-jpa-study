package org.jpa.order.domain;

import jakarta.persistence.*;
import org.jpa.item.domain.Item;

import java.math.BigDecimal;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="order_item_id")
    private Long Id;
    
    @Column
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;
    
    @Column
    @OneToOne(fetch = FetchType.LAZY)
    private Item item;
    
    private int price;
    
    private int quantity;
    
}
