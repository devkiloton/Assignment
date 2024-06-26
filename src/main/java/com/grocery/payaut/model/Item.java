package com.grocery.payaut.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.grocery.payaut.enumerator.ItemTypes;
import com.grocery.payaut.enumerator.MeasurementUnits;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private ItemTypes type;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_price")
    private double price;

    /**
     * Unit to measure the item. e.g. GRAM, PIECE, etc.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "item_unit")
    private MeasurementUnits unit;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount; // Nullable for `Items` without `Discount`
}