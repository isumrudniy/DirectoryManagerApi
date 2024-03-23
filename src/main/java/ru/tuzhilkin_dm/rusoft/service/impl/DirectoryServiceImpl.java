package ru.tuzhilkin_dm.rusoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Service;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;
import ru.tuzhilkin_dm.rusoft.exception.NotFoundException;
import ru.tuzhilkin_dm.rusoft.repository.DirectoryRepository;
import ru.tuzhilkin_dm.rusoft.service.DirectoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;

    @Override
    public Directory findById(String id) {
        return directoryRepository.findById(id).orElseThrow(() -> new NotFoundException("The record with id " + id + "not found."));
    }

    @Override
    public Directory findByName(String name) {
        return directoryRepository.findDirectoryByName(name);
    }

    @Override
    @Transactional
    public void save(Directory directory) {
        directoryRepository.save(directory);
    }

    @Override
    public void deleteById(String id) {
        directoryRepository.deleteById(id);
    }

    @Override
    public List<Directory> findAll() {
        List<Directory> directories = directoryRepository.findAll();
        if (directories.isEmpty()) {
            throw new NotFoundException("The records not found.");
        }
        return directories;
    }

    @Override
    public void update(String id, Directory directory) {

    }
}
