package org.saponko.main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GoodsService {

    public static void writeGoodToXml(String filePath, Good object) throws JAXBException {
        File file = new File(filePath);
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, file);
        //should be remove after test
        marshaller.marshal(object, System.out);
    }

    public static Good readGoodFromXml(String filePath, Class<? extends Good> clazz) throws JAXBException {
        File file = new File(filePath);
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Good good = null;
        if (clazz == MaterialGood.class) {
            good = (MaterialGood)unmarshaller.unmarshal(file);
        } else if (clazz == ElectronicGood.class) {
            good = (ElectronicGood)unmarshaller.unmarshal(file);
        }
        //should be remove after test
        System.out.println(good);
        return good;
    }

    public static void writeAllGoodsToXml(String filePath, DbStub goods) throws JAXBException {
        File file = new File(filePath);
        JAXBContext context = JAXBContext.newInstance(DbStub.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(goods, file);
        //should be remove after test
        marshaller.marshal(goods, System.out);
    }

    public static DbStub readListOfGoodsFromXml(String filePath) throws JAXBException {
        File file = new File(filePath);
        JAXBContext context = JAXBContext.newInstance(DbStub.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        DbStub stub = (DbStub)unmarshaller.unmarshal(file);
        //should be remove after test
        stub.getGoods().forEach(System.out::println);
        return stub;
    }

    public List<Good> getGoodsInDescendProductPriceOrder(DbStub goods) {

        List<Good> result = new ArrayList<>(goods.getGoods());
        result.sort(Comparator.comparingDouble(Good::getProductPrice).reversed());
        return result;
    }
    public MaterialGood getMaterialGoodWithMaxDeliveryPrice(DbStub goods) {
        if (goods.getGoods() != null && !goods.getGoods().isEmpty()) {
            return (MaterialGood) goods.getGoods()
                    .stream()
                    .filter(p -> p.getClass().equals(MaterialGood.class))
                    .max(Comparator.comparingDouble(Good::getDeliveryPrice))
                    .get();
        }
        return null;
    }
}
