package org.saponko.main;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.RoundingMode;

@XmlRootElement
public abstract class Good {
    private static long nextId = 1;
    private long id;

    private double productPrice;
    private double deliveryPrice;

    public Good() {
        this.id = nextId++;
    }

    public Good(double productPrice, double deliveryPrice) {
        this.id = nextId++;
        this.productPrice = productPrice;
        this.deliveryPrice = deliveryPrice;
    }

    public abstract double getPriceWithVat();

    public long getId() {
        return id;
    }
    @XmlAttribute
    public void setId(long id) {
        this.id = id;
    }
    @XmlElement
    public void setDeliveryPrice(double deliveryPrice) {
        if (deliveryPrice >= 0) {
            //rounding value to 2 decimal places
            this.deliveryPrice = new BigDecimal(deliveryPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }

    public double getProductPrice() {
        return productPrice;
    }
    @XmlElement
    public void setProductPrice(double productPrice) {
        //rounding value to 2 decimal places
        this.productPrice = new BigDecimal(productPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (id != good.id) return false;
        if (Double.compare(good.productPrice, productPrice) != 0) return false;
        return Double.compare(good.deliveryPrice, deliveryPrice) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(deliveryPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", productPrice=" + productPrice +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
