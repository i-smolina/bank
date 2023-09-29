package com.example.bank.controller;

import com.example.bank.model.Operation;
import com.example.bank.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("operation")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService operationService;

    @GetMapping("{id}")
    public Operation findById(@PathVariable int id) {
        return operationService.findById(id);
    }

    @GetMapping("all")
    public List<Operation> findAll() {
        return operationService.findAll();
    }

    @PostMapping("add")
    public Operation add(@RequestBody Operation operation) {
        return operationService.add(operation);
    }

    @PutMapping("replace/{id}")
    public Operation replace(@PathVariable int id, @RequestBody Operation operation) {
        return operationService.replace(id, operation);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        operationService.delete(id);
    }
}
