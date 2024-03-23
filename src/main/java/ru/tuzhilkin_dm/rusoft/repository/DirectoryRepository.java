package ru.tuzhilkin_dm.rusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;

import java.util.List;
import java.util.Optional;

public interface DirectoryRepository extends JpaRepository<Directory, String> {

    @Query("select distinct d from Directory d left join fetch d.valueDirectories")
    List<Directory> findAllDirectoriesWithValue();

    @Query("select distinct d from Directory d left join fetch d.valueDirectories where d.name = :name")
    Optional<Directory> findDirectoryByName(String name);
}
