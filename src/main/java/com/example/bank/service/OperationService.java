package com.example.bank.service;

import com.example.bank.exception.NoContentException;
import com.example.bank.model.Operation;
import com.example.bank.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationService {
    private final OperationRepository operationRepository;

    public Operation findById(int id) {
        return operationRepository.findById(id).orElseThrow(
                ()->new NoContentException("Not found operation id = " + id));
    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public Operation add(Operation operation) {
        return operationRepository.save(operation);
    }

    public Operation replace(int id, Operation newOperation) {
        Operation operation = findById(id);
        operation.setAmount(newOperation.getAmount());
        operation.setDate(newOperation.getDate());
        operation.setComment(newOperation.getComment());
        operation.setSrc_client(newOperation.getSrc_client());
        operation.setDst_client(newOperation.getDst_client());
        return operationRepository.save(operation);
    }

    public void delete(int id) {
        Operation operation = findById(id);
        operationRepository.delete(operation);
    }
}
