package util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XsltProcessor {

    private String pathFirstXSL;

    public XsltProcessor(String nameFirstXSL) {
        this.pathFirstXSL = "/Users/ignacio/GoogleDrive/Ingenieria_informatica/4_2/Arquitectura_sofware/Entregas_AS/Practica_2_EJBs/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-war/web/xsl/" + nameFirstXSL;
    }

    public String getTransformation(String xmlEntity) {
        return secondTransformation(firstTransformation(xmlEntity));
    }

    private String firstTransformation(String xmlEntity) {
        String strResult = null;
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource source = new StreamSource(new StringReader(xmlEntity));
            Source xslDoc = new StreamSource(pathFirstXSL);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(source, result);
            strResult = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }

    private String secondTransformation(String formatFirstTransformation) {
        String strResult = null;
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource source = new StreamSource(new StringReader(formatFirstTransformation));
            Source xslDoc = new StreamSource("/Users/ignacio/GoogleDrive/Ingenieria_informatica/4_2/Arquitectura_sofware/Entregas_AS/Practica_2_EJBs/Practica_2_EJB_UniversityBook/Practica_2_EJB_UniversityBook-war/web/xsl/actual/second_actual.xsl");
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(source, result);
            strResult = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResult;
    }
}
