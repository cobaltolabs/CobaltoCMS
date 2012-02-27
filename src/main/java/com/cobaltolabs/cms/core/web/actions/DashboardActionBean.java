package com.cobaltolabs.cms.core.web.actions;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 18:59
 */
@UrlBinding("/admin/dashboard")
public class DashboardActionBean extends CmsActionBean {
// -------------------------- STATIC METHODS --------------------------

    public static Resolution index(){
        return new ForwardResolution("/WEB-INF/jsp/views/dashboard.jsp");
    }
}
