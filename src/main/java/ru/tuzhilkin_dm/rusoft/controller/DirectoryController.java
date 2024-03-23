package ru.tuzhilkin_dm.rusoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.dto.RestResponse;
import ru.tuzhilkin_dm.rusoft.service.DirectoryService;
import ru.tuzhilkin_dm.rusoft.util.mapper.DirectoryMapper;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directory")
public class DirectoryController {
    private final DirectoryService directoryService;
    private final DirectoryMapper directoryMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAllOrByName(@RequestParam(required = false) Optional<String> name) {
        if (!name.isPresent()) {
            return new RestResponse(directoryService.findAll());
        }
        return new RestResponse(directoryService.findByName(name.get()));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findById(@PathVariable String id) {
        return new RestResponse(directoryService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse create(@RequestBody DirectoryDto directoryDto) {
        return new RestResponse(directoryService.save(directoryMapper.toEntity(directoryDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse deleteById(@PathVariable String id) {
        directoryService.deleteById(id);
        return new RestResponse("Record deleted successfully");
    }
}
