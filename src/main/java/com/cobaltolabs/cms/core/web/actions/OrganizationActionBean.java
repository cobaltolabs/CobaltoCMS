package com.cobaltolabs.cms.core.web.actions;

import com.cobaltolabs.cms.core.*;
import com.cobaltolabs.cms.core.services.OrganizationService;
import com.cobaltolabs.cms.core.stripes.JsonResolution;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 13:53
 */
@UrlBinding("/admin/organizations/{$event}/{organization.id}")
public class OrganizationActionBean extends CmsActionBean {
// ------------------------------ FIELDS ------------------------------

    private Organization organization;
    private OrganizationService organizationService;

// -------------------------- STATIC METHODS --------------------------

    @DefaultHandler
    public static Resolution index() {
        return new ForwardResolution("/WEB-INF/jsp/views/organizations.jsp");
    }

    public static Resolution insertForm() {
        return new ForwardResolution("/WEB-INF/jsp/views/modals/insertOrg.jsp");
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

// -------------------------- OTHER METHODS --------------------------

    public Resolution all() throws IOException {
        return new JsonResolution(objectMapper, organizationService.getAll());
    }

    public Resolution delete() throws IOException {
        try {
            organizationService.delete(organization);
            return jsonOkResolution();
        } catch (DeleteException e) {
            return jsonExceptionResolution(e);
        }
    }

    public Resolution deleteForm() throws OrganizationNotFoundException {
        organization = get();
        return new ForwardResolution("/WEB-INF/jsp/views/modals/deleteOrg.jsp");
    }

    private Organization get() throws OrganizationNotFoundException {
        return organizationService.get(organization.getId());
    }

    @SpringBean("organizationService")
    public void injectOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    public Resolution insert() throws IOException {
        try {
            organizationService.insert(organization);
            return jsonOkResolution();
        } catch (InsertException e) {
            return jsonExceptionResolution(e);
        }
    }

    public Resolution update() throws IOException {
        try {
            organizationService.update(organization);
            return jsonOkResolution();
        } catch (UpdateException e) {
            return jsonExceptionResolution(e);
        }
    }

    public Resolution updateForm() throws OrganizationNotFoundException {
        organization = get();
        return new ForwardResolution("/WEB-INF/jsp/views/modals/updateOrg.jsp");
    }
}
