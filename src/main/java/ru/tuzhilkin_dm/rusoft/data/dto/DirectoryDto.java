package ru.tuzhilkin_dm.rusoft.data.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DirectoryDto {
    private String id;
    private String name;
    private List<ValueDirectoryDto> valueDirectories;
    private String author;
    private LocalDateTime dateTime;
}
