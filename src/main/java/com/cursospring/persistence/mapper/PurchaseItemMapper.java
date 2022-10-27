package com.cursospring.persistence.mapper;

import com.cursospring.domain.PurchaseItem;
import com.cursospring.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            //Como se habia creado un archivo con dos llaves primarias, se accede de esa manera
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            //Como son iguales, se puede omitir
            //@Mapping(source = "total", target = "total"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    CompraProducto toComprasProducto(PurchaseItem purchaseIem);

}
