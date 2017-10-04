package org.saponko.main;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ElectronicGood extends Good {

    public ElectronicGood() {
    }

    public ElectronicGood(double productPrice, double deliveryPrice) {
        //also have to throw exception???
        super(productPrice, 0);
    }

    @Override
    public double getPriceWithVat() {
        return getProductPrice();
    }

    @Override
    public void setDeliveryPrice(double deliveryPrice) {
        if (deliveryPrice != 0) {
            throw new IllegalArgumentException("DeliveryPrice for electronic good must be equals 0");
        } else {
            //unnecessary call, can be remove after approval of the Teamlead
            super.setDeliveryPrice(deliveryPrice);
        }
    }
}
