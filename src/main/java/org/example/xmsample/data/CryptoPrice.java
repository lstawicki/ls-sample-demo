package org.example.xmsample.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CryptoPrice {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private Date timestamp;
    private String symbol;
    private Double price;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CryptoPrice that = (CryptoPrice) o;

        if (!timestamp.equals(that.timestamp)) return false;
        if (!symbol.equals(that.symbol)) return false;
        return price.equals(that.price);
    }

    @Override
    public int hashCode() {
        int result = timestamp.hashCode();
        result = 31 * result + symbol.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CryptoPrice{" +
                "timestamp=" + timestamp +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
