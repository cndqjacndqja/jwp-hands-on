package com.example.cachecontrol;

import io.netty.handler.codec.http.HttpContentEncoder;
import java.util.concurrent.TimeUnit;
import jdk.jfr.ContentType;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
public class CacheWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        interceptor.addCacheMapping(CacheControl
                .noCache()
                .cachePrivate(), "/");
        registry.addInterceptor(interceptor);
    }
}
