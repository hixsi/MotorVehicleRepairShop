package com.project.motorVehicleRepairShop.config;


import com.project.motorVehicleRepairShop.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auto-repair-shops").hasAnyAuthority("ADMIN")
                .antMatchers("/auto-repair-shops/create-auto-repair-shop").hasAnyAuthority("ADMIN")
                .antMatchers("/auto-repair-shops/edit-auto-repair-shop").hasAnyAuthority("ADMIN")
                .antMatchers("/employees/create-employee").hasAnyAuthority("ADMIN")
                .antMatchers("/employees/edit-employee").hasAnyAuthority("ADMIN")
                .antMatchers("/services").hasAnyAuthority("ADMIN","EMPLOYEE")
                .antMatchers("/services/create-service").hasAnyAuthority("ADMIN","EMPLOYEE")
                .antMatchers("/appointments/edit-appointment").hasAnyAuthority("ADMIN","EMPLOYEE")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login")
                .permitAll();
    }

}
