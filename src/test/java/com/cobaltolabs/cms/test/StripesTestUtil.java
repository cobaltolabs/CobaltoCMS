package com.cobaltolabs.cms.test;

import net.sourceforge.stripes.controller.DispatcherServlet;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.mock.MockServletContext;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 24/03/12
 *         Time: 14:55
 */

public final class StripesTestUtil {
    private StripesTestUtil() {
    }

    public static MockServletContext buildMockServletContext() {
        MockServletContext context = new MockServletContext("cms");
        context.addInitParameter("contextConfigLocation", "classpath:spring-infrastructure.xml");
        context.addInitParameter("spring.profiles.active", "test");
        ContextLoaderListener listener = new ContextLoaderListener();
        listener.contextInitialized(new ServletContextEvent(context));
        Map<String, String> filterParams = new HashMap<String, String>(8);
        filterParams.put("ActionResolver.Packages", "com.cobaltolabs");
        filterParams.put("Stripes.EncryptionKey", "cobalto");
        filterParams.put("Interceptor.Classes", "net.sourceforge.stripes.integration.spring.SpringInterceptor");
        filterParams.put("ActionBeanContext.Class", "com.cobaltolabs.cms.core.stripes.CmsActionBeanContext");
        filterParams.put("LocalePicker.Locales", "en:UTF-8,es:UTF-8");
        context.addFilter(StripesFilter.class, "StripesFilter", filterParams);
        context.setServlet(DispatcherServlet.class, "DispatcherServlet", null);
        return context;
    }
}
