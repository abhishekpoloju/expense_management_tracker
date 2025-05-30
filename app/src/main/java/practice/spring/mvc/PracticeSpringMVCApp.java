/*
 * This source file was generated by the Gradle 'init' task
 */
package practice.spring.mvc;

import org.apache.catalina.startup.Tomcat;
import practice.spring.mvc.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;


public class PracticeSpringMVCApp {

    private static final int PORT = 8083;

    public static void main(String[] args) throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        final File base = createBaseDirectory();
        String appBase = ".";

        final Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(base.getAbsolutePath());
        tomcat.setPort(PORT);
        tomcat.getConnector();
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        tomcat.start();
        tomcat.getServer().await();
    }

    private static File createBaseDirectory() throws IOException {
        final File base = File.createTempFile( "tomcat.", "." + PORT );

        if( !base.delete() ) {
            throw new IOException( "Cannot (re)create base folder: " + base.getAbsolutePath()  );
        }

        if( !base.mkdir() ) {
            throw new IOException( "Cannot create base folder: " + base.getAbsolutePath()  );
        }

        return base;
    }
}
