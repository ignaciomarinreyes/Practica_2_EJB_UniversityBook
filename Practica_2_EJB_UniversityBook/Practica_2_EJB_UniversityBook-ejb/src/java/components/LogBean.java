package components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class LogBean implements LogBeanRemote {

    private File file;
    private long sizeFile;
    ArrayList<String> log = new ArrayList();

    @PostConstruct
    public void init() {
        file = new File("/Users/ignacio/GlassFish_Server/glassfish/domains/domain1/config/logEJB.txt");
    }

    @PreDestroy
    public void destroy() {
    }

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
            log.add(mensaje);
            logger.info(mensaje);
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
        for (String line : log) {
            result += line + "\n";
        }
        return result;
    }

    @Schedule(second = "*/5", minute = "*", hour = "*")
    public void timeoutAllUsersInactive() {
        if (sizeFile == file.length()) {
            writeLogEJBInfo("Ningún usuario a interaccionado con el sistema durante 5 segundos");
        } else {
            sizeFile = file.length();
        }
    }

}
