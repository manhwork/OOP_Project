package OOP_Project.example.OOP_Project.loginAdmin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((auth) -> auth.
                requestMatchers("/*").permitAll().
                requestMatchers("/admin/**").hasAuthority("ADMIN").
                anyRequest().authenticated()).formLogin(login -> login.
                loginPage("/logon").loginProcessingUrl("/logon").
                usernameParameter("username").passwordParameter("password").
                defaultSuccessUrl("/admin", true));
        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().
                requestMatchers("/static/**", "/assets/**", "/admin/**");
    }
}
