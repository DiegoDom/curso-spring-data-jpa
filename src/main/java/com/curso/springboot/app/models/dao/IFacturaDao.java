package com.curso.springboot.app.models.dao;

import com.curso.springboot.app.models.entity.Factura;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

  @Query("select f from Factura f join fetch f.cliente c join fetch f.detalles d join fetch d.producto where f.id=?1")
  public Factura fetchByIdWithClienteWithFacturaDetalleWithProducto(Long id);

}
