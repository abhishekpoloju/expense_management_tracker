package sports.management.configuration.webconfig;

import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.DelegatingFilterProxy;
import sports.management.configuration.AppConfig;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.EnumSet;


public class WebServletConfig implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext context){
        AnnotationConfigWebApplicationContext webAppCtx = new AnnotationConfigWebApplicationContext();
        webAppCtx.register(AppConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppCtx);

        ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", dispatcherServlet);

        DelegatingFilterProxy delegateFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain",webAppCtx);

        FilterRegistration.Dynamic securityFilter = context.addFilter("securityFilter", delegateFilterProxy);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.ASYNC);

        securityFilter.addMappingForUrlPatterns(dispatcherTypes, false, "/*");

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
