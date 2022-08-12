package org.example.xmsample.utils;

import org.example.xmsample.data.CryptoPrice;
import org.example.xmsample.repo.CryptoRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CryptoPriceWriter implements ItemWriter<CryptoPrice> {

    Logger logger = Logger.getLogger(CryptoPriceWriter.class.getName());
    CryptoRepository cryptoRepository;


    @Autowired
    CryptoPriceWriter(CryptoRepository cryptoRepository){
        this.cryptoRepository = cryptoRepository;
    }

    @Override
    public void write(List<? extends CryptoPrice> list) {

        list.forEach(cryptoPrice -> {
            String msg = "CryptoPriceWriter    : Saving data    : " + cryptoPrice.toString();
            System.out.println(msg);
            logger.info(msg);
            cryptoRepository.save(cryptoPrice);
        });
    }
}
