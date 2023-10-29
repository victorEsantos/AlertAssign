package com.victor.alertassign.task.api;

import com.victor.alertassign.task.CreateTaskUseCase;
import com.victor.alertassign.task.CreateTaskUseCase.CreateTaskCommand;
import com.victor.alertassign.task.InsertUserTaskUseCase;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static com.victor.alertassign.task.InsertUserTaskUseCase.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final InsertUserTaskUseCase insertUserTaskUseCase;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateTaskCommand command) throws SchedulerException {
        UUID id = createTaskUseCase.handle(command);
        var uri = URI.create("/task/" + id);
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/insertUser")
    public ResponseEntity<String> insertUser(@RequestBody InsertUserTaskCommand command) {
        insertUserTaskUseCase.handle(command);
        return ResponseEntity.ok().build();
    }
}
