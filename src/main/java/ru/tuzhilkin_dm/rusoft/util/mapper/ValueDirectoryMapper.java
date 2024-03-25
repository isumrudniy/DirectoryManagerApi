package ru.tuzhilkin_dm.rusoft.util.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.tuzhilkin_dm.rusoft.data.dto.ValueDirectoryCreationDto;
import ru.tuzhilkin_dm.rusoft.data.dto.ValueDirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.entity.ValueDirectory;
import ru.tuzhilkin_dm.rusoft.service.DirectoryService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ValueDirectoryMapper {

    @Lazy
    private final DirectoryService directoryService;

    public ValueDirectory toEntity(ValueDirectoryCreationDto valueDirectoryDto) {
        return ValueDirectory.builder()
                .key(valueDirectoryDto.getKey())
                .name(valueDirectoryDto.getName())
                .supAttrs(valueDirectoryDto.getSupAttrs())
                .directory(directoryService.findById(valueDirectoryDto.getIdDirectory()))
                .build();
    }

    public ValueDirectoryDto toDto(ValueDirectory valueDirectory) {
        return ValueDirectoryDto.builder()
                .id(valueDirectory.getId())
                .key(valueDirectory.getKey())
                .name(valueDirectory.getName())
                .supAttrs(valueDirectory.getSupAttrs())
                .idDirectory(valueDirectory.getDirectory().getId())
                .author(valueDirectory.getAuthor())
                .dateTime(valueDirectory.getDateTime())
                .build();
    }

    public List<ValueDirectoryDto> toDto(List<ValueDirectory> valueDirectory) {
        return valueDirectory.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
