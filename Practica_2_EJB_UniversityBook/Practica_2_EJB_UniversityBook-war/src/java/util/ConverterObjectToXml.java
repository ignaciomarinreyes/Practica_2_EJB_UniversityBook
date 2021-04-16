package util;

import entities.Degree;
import entities.University;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ConverterObjectToXml {

    public static String toXmlDegree(Class object, Degree element) {
        String result = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(object);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(element, sw);
            result = sw.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(ConverterObjectToXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String toXmlUniversity(Class object, University element) {
        String result = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(object);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            marshaller.marshal(element, sw);
            result = sw.toString();
        } catch (JAXBException ex) {
            Logger.getLogger(ConverterObjectToXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
