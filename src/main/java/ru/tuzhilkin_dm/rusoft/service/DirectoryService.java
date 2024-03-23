package ru.tuzhilkin_dm.rusoft.service;

import ru.tuzhilkin_dm.rusoft.data.entity.Directory;

import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    Directory findById(String id);

    List<Directory> findAll();

    Directory findByName(String name);

    Directory save(Directory directory);

    void deleteById(String id);

    void update(String id, Directory directory);
}