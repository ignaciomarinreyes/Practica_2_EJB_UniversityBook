/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import entities.Subject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Startup
@Singleton
public class LogBean implements LogBeanRemote {
    
    // Ruta guarda log /Users/ignacio/GlassFish_Server/glassfish/domains/domain1/config
    @Override
    public void writeLogEJBInfo(String mensaje) {    
        Logger logger = Logger.getLogger("components.LogEJB");
        FileHandler fh;
        try {
            fh = new FileHandler("logEJB.txt", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            //logger.info(mensaje);
            fh.close();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLogEJB() {
        String result = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("/Users/ignacio/GlassFish_Server/glassfish/domains/domain1/config/logEJB.txt")));
            String linea;
            while ((linea = br.readLine()) != null) {
                result += linea + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}
