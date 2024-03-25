package ru.tuzhilkin_dm.rusoft.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;
import ru.tuzhilkin_dm.rusoft.data.entity.ValueDirectory;
import ru.tuzhilkin_dm.rusoft.exception.NotFoundException;
import ru.tuzhilkin_dm.rusoft.repository.ValueDirectoryRepository;
import ru.tuzhilkin_dm.rusoft.service.ValueDirectoryService;
import ru.tuzhilkin_dm.rusoft.util.mapper.DirectoryMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ValueDirectoryServiceImpl implements ValueDirectoryService {

    private final ValueDirectoryRepository valueDirectoryRepository;

    @Override
    public ValueDirectory findById(String id) {
        return valueDirectoryRepository.findById(id).orElseThrow(() -> new NotFoundException("The record with id " + id + "not found."));
    }

    @Override
    public List<ValueDirectory> findAll() {
        List<ValueDirectory> valueDirectories = valueDirectoryRepository.findAll();
        if (valueDirectories.isEmpty()) {
            throw new NotFoundException("The records not found.");
        }
        return valueDirectories;
    }

    @Override
    @Transactional
    public ValueDirectory save(ValueDirectory valueDirectory) {
        valueDirectory.setAuthor("AUTHOR");
        valueDirectory.setDateTime(LocalDateTime.now());
        return valueDirectoryRepository.save(valueDirectory);
    }

    @Override
    public void deleteById(String id) {
        ValueDirectory valueDirectory = findById(id);
        valueDirectoryRepository.deleteById(valueDirectory.getId());
    }

    @Override
    @Transactional
    public ValueDirectory update(String id, ValueDirectory valueDirectory) {
        ValueDirectory valueDirectoryUpdate = findById(id);
        valueDirectoryUpdate.setKey(valueDirectory.getKey());
        valueDirectoryUpdate.setName(valueDirectory.getName());
        valueDirectoryUpdate.setSupAttrs(valueDirectory.getSupAttrs());
        valueDirectoryUpdate.setDirectory(valueDirectory.getDirectory());
        valueDirectoryUpdate.setAuthor("AUTHOR");
        valueDirectoryUpdate.setDateTime(LocalDateTime.now());
        return valueDirectoryRepository.save(valueDirectoryUpdate);
    }
}
