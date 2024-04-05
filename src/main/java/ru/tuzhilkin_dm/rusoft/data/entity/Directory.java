package ru.tuzhilkin_dm.rusoft.data.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "valueDirectories")
@Table(name = "directories")
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToMany(mappedBy = "directory", fetch = FetchType.EAGER)
    private List<ValueDirectory> valueDirectories;
    private String author;
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;
}