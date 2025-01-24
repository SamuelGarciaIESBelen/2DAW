package org.iesbelen.mapstruct;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "nombreCliente", source = "nombreCliente")
    public PedidoDTO pedidoAPedidoDTO(Pedido pedido, String nombreCliente);

    public Pedido pedidoDTOAPedido(PedidoDTO pedido);

}
