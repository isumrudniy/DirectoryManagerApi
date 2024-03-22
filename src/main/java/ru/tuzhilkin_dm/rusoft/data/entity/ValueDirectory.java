package ru.tuzhilkin_dm.rusoft.data.entity;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "value_reference")
public class ValueReference {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(name = "sup_attrs")
    private String supAttrs;
}
