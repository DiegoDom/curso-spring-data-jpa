package com.curso.springboot.app.controllers;

import java.util.List;

import com.curso.springboot.app.models.entity.Cliente;
import com.curso.springboot.app.models.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

  @Autowired
  private IClienteService clienteService;

  @GetMapping(value = { "/listar" })
  public List<Cliente> index() {
    return clienteService.findAll();
  }

}
