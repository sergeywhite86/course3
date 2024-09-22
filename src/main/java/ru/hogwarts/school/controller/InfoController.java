package ru.hogwarts.school.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.impl.PortService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/info")
@Log4j2
public class InfoController {

    private final PortService portService;

    @GetMapping("/port")
    public Integer getPort() {
        log.info("Get port");
        return portService.getPort();
    }
}
