package ru.tuzhilkin_dm.rusoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryCreationDto;
import ru.tuzhilkin_dm.rusoft.data.dto.RestResponse;
import ru.tuzhilkin_dm.rusoft.data.dto.ValueDirectoryCreationDto;
import ru.tuzhilkin_dm.rusoft.service.ValueDirectoryService;
import ru.tuzhilkin_dm.rusoft.util.mapper.ValueDirectoryMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/field")
public class ValueDirectoryController {

    private final ValueDirectoryService valueDirectoryService;
    private final ValueDirectoryMapper valueDirectoryMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAll() {
        return new RestResponse(
                valueDirectoryMapper.toDto(valueDirectoryService.findAll()));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findById(@PathVariable String id) {
        return new RestResponse(valueDirectoryMapper.toDto(valueDirectoryService.findById(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse create(@RequestBody ValueDirectoryCreationDto valueDirectoryDto) {
        return new RestResponse(valueDirectoryMapper.toDto(
                valueDirectoryService.save(valueDirectoryMapper.toEntity(valueDirectoryDto))));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse deleteById(@PathVariable String id) {
        valueDirectoryService.deleteById(id);
        return new RestResponse("Record deleted successfully");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse updateById(@PathVariable String id, @RequestBody ValueDirectoryCreationDto valueDirectoryDto) {
        return new RestResponse(valueDirectoryMapper.toDto(valueDirectoryService.update(id,
                valueDirectoryMapper.toEntity(valueDirectoryDto))));
    }

}