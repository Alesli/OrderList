package com.example.unmarshal;

import com.example.entity.Product;
import com.example.service.OrderDetailsService;
import com.example.service.impl.OrderDetailsServiceImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.List;

public class UnMarshalProduct {

    private Product getUnMarshal() {
//        String parh = "product.xml";
//        InputStream stream = getClass().getClassLoader().getResourceAsStream(parh);
        File xmlFile = new File("src/main/resources/product.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Product.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Product) jaxbUnmarshaller.unmarshal(xmlFile);

        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProduct() {
        Product product = getUnMarshal();
        Product productForSave = new Product();

        productForSave.setSerialNumber(product.getSerialNumber());
        productForSave.setName(product.getName());
        productForSave.setDescription(product.getDescription());
        productForSave.setDateProduct(product.getDateProduct());

        return productForSave;
    }
}
