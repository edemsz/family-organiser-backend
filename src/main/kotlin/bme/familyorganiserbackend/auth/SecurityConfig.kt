package bme.familyorganiserbackend.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.firewall.HttpFirewall
import org.springframework.security.web.firewall.StrictHttpFirewall


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true
)
open class SecurityConfig: WebSecurityConfigurerAdapter() {
    @Autowired
    private lateinit var userDetailsService: UserDetailsService


    override fun configure(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        authenticationManagerBuilder.userDetailsService(userDetailsService)
    }

    protected open fun registerAuthentication(authManagerBuilder: AuthenticationManagerBuilder) {
        authManagerBuilder
            .inMemoryAuthentication()
            .withUser("admin").password("admin").roles("ADMIN")
    }


    @Bean
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }


    override fun configure(http: HttpSecurity) {
        http.cors().and().authorizeRequests().antMatchers(
            "/api/family-member/login/**",
            "/api/family-member/register/**",

            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
        ).permitAll()


        http.csrf().disable()
    }



    @Bean
    open fun allowUrlEncodedSlashHttpFirewall(): HttpFirewall? {
        val firewall = StrictHttpFirewall()
        firewall.setAllowUrlEncodedSlash(true)
        firewall.setAllowUrlEncodedDoubleSlash(true)
        firewall.setAllowSemicolon(true)
        return firewall
    }


}