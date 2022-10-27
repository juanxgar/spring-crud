package com.cursospring.domain.repository;

import com.cursospring.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();

    Optional<List<Purchase>> getByClientId(String clientId);

    Optional<Purchase> getPurchase(int purchaseId);

    Purchase save(Purchase purchase);

    void delete(int purchaseId);


}
