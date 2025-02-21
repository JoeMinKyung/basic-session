package com.example.basicsession.todo.service;

import com.example.basicsession.todo.dto.TodoSaveRequestDto;
import com.example.basicsession.todo.dto.TodoSaveResponseDto;
import com.example.basicsession.todo.entity.Todo;
import com.example.basicsession.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoSaveResponseDto save(TodoSaveRequestDto dto) {
        Todo todo = new Todo(dto.getContent());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getContent()
        );
    }
}
