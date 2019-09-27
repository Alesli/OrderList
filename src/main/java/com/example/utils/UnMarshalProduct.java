package com.example.utils;

import com.example.entity.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Properties;

public class UnMarshalProduct {

    private Product getUnMarshal() {

        Properties properties = PropertyReader.getProperties("application.properties");
        String xmlFilePath = properties.getProperty("xml_file_path");
        File xmlFile = new File(xmlFilePath);
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
        if (product != null) {
            productForSave.setSerialNumber(product.getSerialNumber());
            productForSave.setName(product.getName());
            productForSave.setDescription(product.getDescription());
            productForSave.setDateProduct(product.getDateProduct());
        }
        return productForSave;
    }
}
