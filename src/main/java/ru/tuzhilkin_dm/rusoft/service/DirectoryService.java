package ru.tuzhilkin_dm.rusoft.service;

import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryCreationDto;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;

import java.util.List;

public interface DirectoryService {
    Directory findById(String id);

    List<Directory> findAll();

    Directory findByName(String name);

    Directory save(Directory directory);

    void deleteById(String id);

    Directory update(String id, Directory directory);
}