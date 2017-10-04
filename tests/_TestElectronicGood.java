import org.junit.Assert;
import org.junit.Test;
import org.saponko.main.ElectronicGood;
import org.saponko.main.Good;

public class _TestElectronicGood {

    @Test
    public void getPriceWithVatShouldReturnSamePrice() throws Exception {

        Good electronicGood = new ElectronicGood();

        electronicGood.setProductPrice(99.22);
        Assert.assertEquals(99.22, electronicGood.getPriceWithVat(), 0.0);
    }



    @Test(expected = IllegalArgumentException.class)
    public void settingDeliveryPriceDifferentFromZeroShouldThrowIllegalArgumentException() {
        Good materialGood = new ElectronicGood();
        materialGood.setDeliveryPrice(1.22);
    }


}
