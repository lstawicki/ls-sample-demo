package org.example.xmsample.utils;

import org.example.xmsample.data.CryptoPrice;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class CryptoPriceReader extends FlatFileItemReader<CryptoPrice> implements ItemReader<CryptoPrice> {

    public CryptoPriceReader() {
        setLinesToSkip(1);
        setLineMapper(getDefaultLineMapper());
    }

    @Override
    public CryptoPrice read() throws Exception {
        return super.read();
    }

    private LineMapper<CryptoPrice> getDefaultLineMapper() {
        DefaultLineMapper<CryptoPrice> defaultLineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames("timestamp", "symbol", "price");
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        BeanWrapperFieldSetMapper<CryptoPrice> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(CryptoPrice.class);
        beanWrapperFieldSetMapper.setConversionService(createConversionService());
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return defaultLineMapper;
    }


    public ConversionService createConversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        DefaultConversionService.addDefaultConverters(conversionService);
        conversionService.addConverter((Converter<String, Date>) text -> new Date((new BigDecimal(text)).longValue()));
        return conversionService;
    }
}
