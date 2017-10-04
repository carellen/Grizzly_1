

import org.junit.Assert;
import org.junit.Test;
import org.saponko.main.Good;
import org.saponko.main.MaterialGood;

public class _TestMaterialGood {


    @Test
    public void gettingPriceWithVatShouldAdd20PercentToProductPrice() {

        Good materialGood = new MaterialGood();

        materialGood.setProductPrice(99.22);
        Assert.assertEquals(119.06, materialGood.getPriceWithVat(), 0.0);
    }


}
