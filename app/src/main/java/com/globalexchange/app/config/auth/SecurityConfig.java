package com.globalexchange.app.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
//WebSecurityConfigurerAdapter는 더 이상 지원 안하므로 SecurityFilterChain리턴

public class SecurityConfig  {
    private final CustomOAuth2UserService customOAuth2UserService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //만약 deprecated되면  authorizeHttpRequests()
        http
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**","/error").permitAll()
                //단순 이 한줄 때문에 /member/login에서 지멋대로 실행되던게, googleLogin에서 oauth 페이지가 실행된다??????
                .antMatchers("/member/login").permitAll()
                .antMatchers("/member/join").permitAll()
                //.antMatchers("/member/emailLogin").permitAll()
                //.antMatchers("/member/googleJoin").permitAll()
                //.antMatchers("/member/googleLogin").permitAll()
                .anyRequest().authenticated()
                //이렇게했더니 안먹힘
                //.anyRequest().permitAll()

                //로그인 경로
                //formLogin()
                //loginPage("/member/googleLogin")
                //loginProcessingUrl("/member/googleLogin")
                //.permitAll()
                //.and()
                //.formLogin()
                //.loginPage("/member/emailLogin")
                //.loginProcessingUrl("/member/emailLogin")
                //.loginPage("http://localhost:22222/member/googleLogin")
                //loginProcessingUrl("/member/googleLoginProcessing")
                //.defaultSuccessUrl("/diary/list")
                //.failureUrl("/member/login")


                //로그아웃 경로
                .and()
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .invalidateHttpSession(true).deleteCookies("JSESSIONID","remember-me").deleteCookies("SESSION")
                .logoutSuccessUrl("/main/main")

                .permitAll()

                .and()
                .oauth2Login()
                //.loginPage("/member/googleLogin")
                //.loginProcessingUrl("/member/googleLoginProcessing")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        return http.build();
    }
//WebSecurityConfigurerAdapter 지원했을때의 방식

/*@Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                    .authorizeRequests()
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()

                .anyRequest().authenticated()

                .and()
                    .logout()
                    .logoutSuccessUrl("/member/logout")

                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }*/

}
