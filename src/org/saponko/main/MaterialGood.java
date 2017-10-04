package org.saponko.main;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.RoundingMode;

@XmlRootElement
public class MaterialGood extends Good {

    public MaterialGood() {
    }

    public MaterialGood(double productPrice, double deliveryPrice) {
        super(productPrice, deliveryPrice);
    }

    @Override
    public double getPriceWithVat() {
        return new BigDecimal(getProductPrice() * 1.2)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }



}
