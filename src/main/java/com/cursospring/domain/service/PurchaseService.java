package com.cursospring.domain.service;

import com.cursospring.domain.Purchase;
import com.cursospring.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<Purchase> getPurchase(int purchaseId) {
        return purchaseRepository.getPurchase(purchaseId);
    }

    public Optional<List<Purchase>> getByClientId(String clientId) {
        return purchaseRepository.getByClientId(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public boolean delete(int purchaseId) {
        return purchaseRepository.getPurchase(purchaseId).map(p -> {
            purchaseRepository.delete(purchaseId);
            return true;
        }).orElse(false);
    }
}
