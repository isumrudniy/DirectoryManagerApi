package ru.tuzhilkin_dm.rusoft.data.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "directory")
@Table(name = "value_directory")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ValueDirectory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String key;
    private String name;
    @Column(name = "sup_attrs")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayNode supAttrs;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directory_id")
    private Directory directory;
    private String author;
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;
}