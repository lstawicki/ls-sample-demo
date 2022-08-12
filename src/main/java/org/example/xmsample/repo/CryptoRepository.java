package org.example.xmsample.repo;

import org.example.xmsample.data.CryptoPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "cryptoprices", path = "cryptoprices")
public interface CryptoRepository extends JpaRepository<CryptoPrice, Integer> {

    List<CryptoPrice> findBySymbol(@Param("symbol")String symbol);

    CryptoPrice findTopBySymbolOrderByPriceAsc(@Param("symbol")String symbol);

    CryptoPrice findTopBySymbolOrderByPriceDesc(@Param("symbol")String symbol);

    CryptoPrice findTopBySymbolAndTimestampLessThanOrderByPriceAsc(@Param("symbol")String symbol,
                                                                   @Param("timestamp") @DateTimeFormat(pattern="yyyy-mm-dd") Date timestamp);

    CryptoPrice findTopBySymbolAndTimestampLessThanOrderByPriceDesc(@Param("symbol")String symbol,
                                                                   @Param("timestamp") @DateTimeFormat(pattern="yyyy-mm-dd") Date timestamp);

    CryptoPrice findTopBySymbolOrderByTimestampAsc(@Param("symbol")String symbol);

    CryptoPrice findTopBySymbolOrderByTimestampDesc(@Param("symbol")String symbol);

    @Query("SELECT DISTINCT c.symbol FROM CryptoPrice c")
    List<String> findDistinctSymbol();

}
