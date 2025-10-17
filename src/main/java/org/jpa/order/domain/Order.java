package org.jpa.order.domain;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.*;
import org.jpa.member.domain.Member;

import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="order_id")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    private LocalDateTime orderDate = LocalDateTime.now();
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.READY;
    
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
}
