package com.curso.springboot.app.models.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.springboot.app.models.dao.IUsuarioDao;
import com.curso.springboot.app.models.entity.Role;
import com.curso.springboot.app.models.entity.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

  @Autowired
  private IUsuarioDao usuarioDao;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuario usuario = usuarioDao.findByUsername(username);

    if (usuario == null) {
      throw new UsernameNotFoundException("El usuario " + username + " no existe en la base de datos");
    }

    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    for (Role role : usuario.getRoles()) {
      authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
    }

    if (authorities.isEmpty()) {
      throw new UsernameNotFoundException(
          "El usuario " + username + " no cuenta con ningun rol asignado en la base de datos");
    }

    return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
  }

}
