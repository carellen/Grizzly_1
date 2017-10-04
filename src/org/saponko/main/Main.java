package org.saponko.main;

import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Marshalling single product...");
        try {
            GoodsService.writeGoodToXml("C:\\Users\\user\\IdeaProjects\\Grizzly_1\\testfile",
                    new MaterialGood(333.33, 33.3));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Unmarshalling single product...");
        try {
            GoodsService.readGoodFromXml("C:\\Users\\user\\IdeaProjects\\Grizzly_1\\testfile",
                    MaterialGood.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        GoodsService service = new GoodsService();
        DbStub stub = new DbStub();
        System.out.println("-----------------------------------------------");
        System.out.println("List of goods in descend product price order:");
        service.getGoodsInDescendProductPriceOrder(stub).forEach(System.out::println);
        System.out.println("-----------------------------------------------");
        System.out.println("Material good with max delivery price:");
        System.out.println(service.getMaterialGoodWithMaxDeliveryPrice(stub));
        System.out.println("-----------------------------------------------");
        System.out.println("Marshalling all products...");
        try {

            GoodsService.writeAllGoodsToXml("C:\\Users\\user\\IdeaProjects\\Grizzly_1\\testfile", stub);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Unmarshalling all products...");
        try {
            GoodsService.readListOfGoodsFromXml("C:\\Users\\user\\IdeaProjects\\Grizzly_1\\testfile");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
