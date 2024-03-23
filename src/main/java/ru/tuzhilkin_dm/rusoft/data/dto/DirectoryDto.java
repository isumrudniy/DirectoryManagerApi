package ru.tuzhilkin_dm.rusoft.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectoryDto {
    private String name;
    private String login;
}
