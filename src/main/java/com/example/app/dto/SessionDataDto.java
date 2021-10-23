package com.example.app.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionDataDto implements Serializable{
    private static final long serialVersionUID = 1L;
    String str1;
    String str2;
    String str3;
}
