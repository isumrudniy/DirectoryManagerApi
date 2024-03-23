package ru.tuzhilkin_dm.rusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tuzhilkin_dm.rusoft.data.entity.ValueDirectory;

import java.util.Optional;

public interface ValueDirectoryRepository extends JpaRepository<ValueDirectory, String> {
    @Query("select v from ValueDirectory v join fetch v.directory where v.id = :id")
    Optional<ValueDirectory> findByIdAndFetchTeam(String id);
}
