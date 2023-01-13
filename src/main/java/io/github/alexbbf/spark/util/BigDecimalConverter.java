package io.github.alexbbf.spark.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    public BigDecimal converter(String value){
        if(value == null){
            return null;
        }
        value = value.replace(".","").replace(",",".").replace("R$","");
        return new BigDecimal(value);
    }
}
