package ru.tuzhilkin_dm.rusoft.service;


import ru.tuzhilkin_dm.rusoft.data.entity.ValueDirectory;

import java.util.List;

public interface ValueDirectoryService {

    ValueDirectory findById(String id);

    List<ValueDirectory> findAll();

    ValueDirectory save(ValueDirectory valueDirectory);

    void deleteById(String id);

    ValueDirectory update(String id, ValueDirectory valueDirectory);

}
