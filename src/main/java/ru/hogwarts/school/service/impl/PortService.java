package ru.hogwarts.school.service.impl;

import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortService {

   private final ServletRequest request;

    public Integer getPort(){
        return request.getServerPort();
    }
}
