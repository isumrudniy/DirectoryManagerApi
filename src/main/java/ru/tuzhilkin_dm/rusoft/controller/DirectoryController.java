package ru.tuzhilkin_dm.rusoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tuzhilkin_dm.rusoft.data.dto.DirectoryDto;
import ru.tuzhilkin_dm.rusoft.data.dto.RestResponse;
import ru.tuzhilkin_dm.rusoft.repository.DirectoryRepository;
import ru.tuzhilkin_dm.rusoft.service.DirectoryService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directory")
public class DirectoryController {
    private final DirectoryService directoryService;

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAllOrByName(@RequestParam(required = false) Optional<String> name) {
        if (!name.isPresent()) {
            return new RestResponse(directoryService.findAll());
        }
        return new RestResponse(directoryService.findByName(name.get()));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse create(@RequestBody DirectoryDto directoryDto) {
        return new RestResponse(directoryDto);
    }
}
