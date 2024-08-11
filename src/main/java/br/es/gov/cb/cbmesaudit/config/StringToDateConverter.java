package br.es.gov.cb.cbmesaudit.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format. Please use yyyy-MM-dd");
        }
    }
}
