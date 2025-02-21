package com.example.basicsession.todo.controller;

import com.example.basicsession.member.common.consts.Const;
import com.example.basicsession.todo.dto.*;
import com.example.basicsession.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> save(
            @SessionAttribute(name = Const.LOGIN_USER) Long userId,
            @RequestBody TodoSaveRequestDto dto
    ) {
        return ResponseEntity.ok(todoService.save(userId, dto));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoResponseDto>> getAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoResponseDto> getOne(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.findById(todoId));
    }

    @PutMapping
    public ResponseEntity<TodoUpdateResponseDto> update(
            @SessionAttribute(name = Const.LOGIN_USER) Long userId,
            @PathVariable Long todoId,
            @RequestBody TodoUpdateRequestDto dto
    ) {
        return ResponseEntity.ok(todoService.update(todoId, dto));
    }

    @DeleteMapping("/todos/{todoId}")
    public void delete(
            @SessionAttribute(name = Const.LOGIN_USER) Long userId,
            @PathVariable Long todoId
    ) {
        todoService.deleteById(todoId);
    }
}
