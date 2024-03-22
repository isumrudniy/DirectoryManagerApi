package ru.tuzhilkin_dm.rusoft.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "directories")
public class Directories {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToMany(mappedBy = "")
    private ValueDirectory valueReference;
}