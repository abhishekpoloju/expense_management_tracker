package sports.management.configuration.webconfig;

import jakarta.servlet.*;
import sports.management.configuration.AppConfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebServletConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext context){
        AnnotationConfigWebApplicationContext webAppCtx = new AnnotationConfigWebApplicationContext();
        webAppCtx.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppCtx);

        ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
