package com.cobaltolabs.cms.core.web.actions;

import com.cobaltolabs.cms.core.stripes.CmsActionBeanContext;
import com.cobaltolabs.cms.core.stripes.JsonResolution;
import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.LocalizableError;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import static com.cobaltolabs.cms.core.CmsUtil.e;
import static com.cobaltolabs.cms.core.CmsUtil.object;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 13:55
 */
public abstract class CmsActionBean implements ActionBean {
// ------------------------------ FIELDS ------------------------------

    protected static final String OK = "ok";
    protected static final String MESSAGE = "message";
    protected CmsActionBeanContext context;
    protected ObjectMapper objectMapper;

// --------------------- GETTER / SETTER METHODS ---------------------

    @Override
    public CmsActionBeanContext getContext() {
        return context;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface ActionBean ---------------------

    @Override
    public void setContext(ActionBeanContext context) {
        this.context = (CmsActionBeanContext) context;
    }

// -------------------------- OTHER METHODS --------------------------

    protected void addError(String key, Object... values) {
        context.getValidationErrors().addGlobalError(new LocalizableError(key, values));
    }

    protected void addMessage(String key, Object... values) {
        context.getMessages().add(new LocalizableMessage(key, values));
    }

    protected RedirectResolution defaultRedirectResolution() {
        return new RedirectResolution(this.getClass());
    }

    @SpringBean("objectMapper")
    public void injectObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected Resolution jsonExceptionResolution(Exception e) throws IOException {
        return new JsonResolution(objectMapper, object(e(OK, false), e(MESSAGE, e.getMessage())));
    }

    protected Resolution jsonOkResolution() throws IOException {
        return new JsonResolution(objectMapper, object(e(OK, true)));
    }
}
