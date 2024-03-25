package ru.tuzhilkin_dm.rusoft.data.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValueDirectoryCreationDto {
    private String key;
    private String name;
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayNode supAttrs;
    private String idDirectory;
}
