package com.example.SecurityPractiseFormLogin.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyCustomGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object obj) {
        return "VASU-" + System.currentTimeMillis(); // Your custom logic
    }
}