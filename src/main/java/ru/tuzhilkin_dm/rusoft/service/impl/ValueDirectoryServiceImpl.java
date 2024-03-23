package ru.tuzhilkin_dm.rusoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tuzhilkin_dm.rusoft.data.entity.Directory;
import ru.tuzhilkin_dm.rusoft.data.entity.ValueDirectory;
import ru.tuzhilkin_dm.rusoft.exception.NotFoundException;
import ru.tuzhilkin_dm.rusoft.repository.ValueDirectoryRepository;
import ru.tuzhilkin_dm.rusoft.service.ValueDirectoryService;

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
    public ValueDirectory save(ValueDirectory valueDirectory) {
        return valueDirectoryRepository.save(valueDirectory);
    }

    @Override
    public void deleteById(String id) {
        ValueDirectory valueDirectory = valueDirectoryRepository.findById(id).orElseThrow(() -> new NotFoundException("The record with id " + id + "not found."));
        valueDirectoryRepository.deleteById(valueDirectory.getId());
    }

    @Override
    public void update(String id, ValueDirectory valueDirectory) {
    }
}
