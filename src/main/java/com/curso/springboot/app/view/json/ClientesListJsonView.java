package com.curso.springboot.app.view.json;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component("listar.json")
public class ClientesListJsonView extends MappingJackson2JsonView {

  @Override
  protected Object filterModel(Map<String, Object> model) {

    // En caso de tener mas propiedades en model aqui se remueven con
    // model.remove(propiedad)

    model.remove("titulo");

    return super.filterModel(model);
  }

}
