package org.saponko.main;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ListOfGoods")
@XmlAccessorType(XmlAccessType.FIELD)
public class DbStub {

     @XmlElements({
             @XmlElement(name = "materialGood", type=MaterialGood.class),
             @XmlElement(name = "electronicGood", type=ElectronicGood.class)
     })
     private List<Good> goods = new ArrayList<>();

     {
        goods.add(new MaterialGood(12.22, 1.11));
        goods.add(new MaterialGood(8.13, 0.43));
        goods.add(new MaterialGood(77.55, 2.57));
        goods.add(new MaterialGood(52.89, 3.34));
        goods.add(new MaterialGood(2.18, 0.3));
        goods.add(new ElectronicGood(18.33, 0));
        goods.add(new ElectronicGood(14.21, 1.45));
        goods.add(new ElectronicGood(24.24, 0));
        goods.add(new ElectronicGood(60.91, 0));
        goods.add(new ElectronicGood(22.45, 0));
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
