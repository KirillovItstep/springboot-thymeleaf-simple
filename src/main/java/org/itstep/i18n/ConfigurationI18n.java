package org.itstep.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

    @Configuration
    @ComponentScan(basePackages = "org.itstep.i18n")
    public class ConfigurationI18n implements WebMvcConfigurer {

        @Bean
        public ResourceBundleMessageSource messageSource() {
            var source = new ResourceBundleMessageSource();
            source.setBasenames("messages/i18n");
            source.setDefaultEncoding("UTF-8");
            source.setUseCodeAsDefaultMessage(true); //Вместо NoSuchMessageException будет выдаваться стандартное сообщение
            return source;
        }

        @Bean
        public LocaleResolver localeResolver() {
            SessionLocaleResolver slr = new SessionLocaleResolver();
            slr.setDefaultLocale(Locale.ENGLISH);
            return slr;
        }

        @Bean
        public LocaleChangeInterceptor localeChangeInterceptor() {
            LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
            lci.setParamName("lang");
            return lci;
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(localeChangeInterceptor());
        }


    }
