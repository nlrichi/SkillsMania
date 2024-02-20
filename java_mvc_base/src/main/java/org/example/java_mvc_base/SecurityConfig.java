package org.example.java_mvc_base;
//relevant imports as needed
import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import static org.springframework.security.config.http.MatcherType.mvc;
//below is a basic security configuration to enable the usage of Okta successfully
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //This method returns a bean which is used to create a MvcRequestMatcher.Builder that matches against the URL of a request.
    // It takes HandlerMappingIntrospector as an argument, which is used to introspect handler mappings.
    // This bean is used to define request matchers in the security configuration.
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
    //This method declares a SecurityFilterChain bean which is used to configure security rules for HTTP requests.
    // It takes HttpSecurity and MvcRequestMatcher.Builder as arguments.
    // Within this method, various security configurations are applied using the http object,
    // such as defining authorization rules, logout behavior, and OAuth2 client and login customization.
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http.authorizeRequests(auth ->
                auth.requestMatchers(mvc.pattern("/")).permitAll()
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated()
                )
                .logout(logout ->
                        logout
                                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                                .invalidateHttpSession(true))
                .oauth2Client(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
}
