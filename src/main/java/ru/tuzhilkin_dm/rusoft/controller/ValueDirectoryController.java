package ru.tuzhilkin_dm.rusoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.tuzhilkin_dm.rusoft.data.dto.RestResponse;
import ru.tuzhilkin_dm.rusoft.service.ValueDirectoryService;

@RestController
@RequestMapping("/api/field")
@RequiredArgsConstructor
public class ValueDirectoryController {

    private final ValueDirectoryService valueDirectoryService;

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse findAll() {
        return new RestResponse(null);
    }
}