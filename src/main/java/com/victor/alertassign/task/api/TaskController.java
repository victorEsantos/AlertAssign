package com.victor.alertassign.task.api;

import com.victor.alertassign.task.domain.CreateTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTaskUseCase.CreateTaskCommand command) {
        UUID id = createTaskUseCase.handle(command);
        var uri = URI.create("/task/" + id);
        return ResponseEntity.created(uri).build();
    }
}
