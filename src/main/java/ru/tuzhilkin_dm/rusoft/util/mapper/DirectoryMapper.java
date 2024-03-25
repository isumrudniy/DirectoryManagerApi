package ru.tuzhilkin_dm.rusoft.util.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryCreationDto;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.dto.ValueDirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DirectoryMapper {

    @Lazy
    private final ValueDirectoryMapper valueDirectoryMapper;

    public Directory toEntity(DirectoryCreationDto directoryDto) {
        return Directory.builder()
                .name(directoryDto.getName())
                .build();
    }

    public DirectoryDto toDto(Directory directory) {
        return DirectoryDto.builder()
                .id(directory.getId())
                .name(directory.getName())
                .valueDirectories(
                        directory.getValueDirectories().stream()
                                .map(valueDirectoryMapper::toDto)
                                .collect(Collectors.toList())
                )
                .author(directory.getAuthor())
                .dateTime(directory.getDateTime())
                .build();
    }

    public List<DirectoryDto> toDto(List<Directory> directories) {
        return directories.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

}
