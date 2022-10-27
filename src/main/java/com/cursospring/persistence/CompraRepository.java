package com.cursospring.persistence;

import com.cursospring.domain.Purchase;
import com.cursospring.domain.repository.PurchaseRepository;
import com.cursospring.persistence.crud.CompraCrudRepository;
import com.cursospring.persistence.entity.Compra;
import com.cursospring.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());

    }

    @Override
    public Optional<List<Purchase>> getByClientId(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }


    @Override
    public Optional<Purchase> getPurchase(int purchaseId) {
        return compraCrudRepository.findById(purchaseId).map(purchase -> purchaseMapper.toPurchase(purchase));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);

        //Esto se hace para asignar varios productos y que se guarde en cascada
        //Tambien es necesario modificar el entity para que la relacion funcione
        //en cascada
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));

    }

    @Override
    public void delete(int purchaseId) {
        compraCrudRepository.deleteById(purchaseId);
    }

}
