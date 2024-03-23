package ru.tuzhilkin_dm.rusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;

import java.util.List;

public interface DirectoryRepository extends JpaRepository<Directory, String> {
    Directory findDirectoryByName(String name);
}
