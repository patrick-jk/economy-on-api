package com.economyon.api.service;

import com.economyon.api.exception.BadRequestException;
import com.economyon.api.model.Finance;
import com.economyon.api.repository.FinanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {
    private final FinanceRepository financeRepository;

    public List<Finance> listAll() {
        return financeRepository.findAll();
    }

    public List<Finance> findByUserId(long userId) {
        return financeRepository.findByUserId(userId);
    }

    public Finance findByIdOrThrowBadRequestException(long id) {
        return financeRepository.findById(id).orElseThrow(() -> new BadRequestException("User not Found"));
    }

    @Transactional
    public Finance save(Finance finance) {
        return financeRepository.save(finance);
    }

    public void delete(long id) {
        financeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(Finance finance) {
        Finance savedFinance = findByIdOrThrowBadRequestException(finance.getId());
        finance.setId(savedFinance.getId());
        financeRepository.save(finance);
    }
}
