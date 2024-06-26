package ru.tuzhilkin_dm.rusoft.data.dto;

import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Data
@Builder
public class ValueDirectoryDto {
    private String id;
    private String key;
    private String name;
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayNode supAttrs;
    private String idDirectory;
    private String author;
    private LocalDateTime dateTime;
}
