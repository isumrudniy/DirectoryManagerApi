package ru.tuzhilkin_dm.rusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tuzhilkin_dm.rusoft.data.entity.ValueDirectory;

import java.util.List;
import java.util.Optional;

public interface ValueDirectoryRepository extends JpaRepository<ValueDirectory, String> {
    @Override
    @Query("select vd from ValueDirectory vd join fetch vd.directory")
    List<ValueDirectory> findAll();
}
