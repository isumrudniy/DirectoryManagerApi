package ru.tuzhilkin_dm.rusoft.util.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;

@Component
@RequiredArgsConstructor
public class DirectoryMapper {

    public Directory toEntity(DirectoryDto directoryDto) {
        return Directory.builder()
                .name(directoryDto.getName())
                .build();
    }

}
