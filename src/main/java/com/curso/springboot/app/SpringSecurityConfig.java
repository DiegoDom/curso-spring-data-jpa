package com.curso.springboot.app;

// import javax.sql.DataSource;

import com.curso.springboot.app.auth.handler.LoginSuccessHandler;
import com.curso.springboot.app.models.service.JpaUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /*
   * @Autowired
   * private DataSource dataSource;
   */

  @Autowired
  private JpaUserDetailsService userDetailsService;

  @Autowired
  public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {

    builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    /*
     * builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(
     * passwordEncoder)
     * .usersByUsernameQuery("select username, password, enabled from users where username=?"
     * )
     * .authoritiesByUsernameQuery(
     * "select u.username, a.authority from authorities a inner join users u on (a.user_id = u.id) where u.username=?"
     * );
     */

    /*
     * PasswordEncoder encoder = this.passwordEncoder;
     * // (encoder::encode) === (password -> encoder.encode(password));
     * UserBuilder users = User.builder().passwordEncoder(encoder::encode);
     * 
     * builder.inMemoryAuthentication()
     * .withUser(users.username("admin").password("admin").roles("ADMIN", "USER"))
     * .withUser(users.username("diego").password("admin").roles("USER"));
     */

  }

  @Autowired
  private LoginSuccessHandler successHandler;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/", "/css/**", "/js/**", "/images/**", "/fonts/**", "/listar", "/api", "/api/listar",
            "/api/clientes/**",
            "/locale")
        .permitAll()
        /* .antMatchers("/ver/**").hasAnyRole("USER") */
        /* .antMatchers("/uploads/**").hasAnyRole("USER") */
        /* .antMatchers("/form/**").hasAnyRole("ADMIN") */
        /* .antMatchers("/eliminar/**").hasAnyRole("ADMIN") */
        /* .antMatchers("/factura/**").hasAnyRole("ADMIN") */
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .successHandler(successHandler)
        .loginPage("/login")
        .permitAll()
        .and()
        .logout().permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/error_403");
  }

}
