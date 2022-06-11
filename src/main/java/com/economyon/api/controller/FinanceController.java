package com.economyon.api.controller;

import com.economyon.api.model.Finance;
import com.economyon.api.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("finances")
@RequiredArgsConstructor
public class FinanceController {
    private final FinanceService financeService;

    @GetMapping
    public ResponseEntity<List<Finance>> listAllFinances() {
        return ResponseEntity.ok(financeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Finance> findById(@PathVariable long id) {
        return ResponseEntity.ok(financeService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Finance>> findByUserId(@RequestParam long userId) {
        return ResponseEntity.ok(financeService.findByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Finance> save(@RequestBody @Valid Finance finance) {
        return new ResponseEntity<>(financeService.save(finance), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        financeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Finance finance) {
        financeService.replace(finance);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
