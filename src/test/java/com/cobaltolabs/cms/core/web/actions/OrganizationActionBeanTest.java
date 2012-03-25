package com.cobaltolabs.cms.core.web.actions;

import com.cobaltolabs.cms.core.Organization;
import com.cobaltolabs.cms.core.OrganizationNotFoundException;
import com.cobaltolabs.cms.core.services.OrganizationService;
import com.cobaltolabs.cms.core.stripes.JsonResolution;
import com.cobaltolabs.cms.test.CmsTest;
import net.sourceforge.stripes.action.ForwardResolution;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.testng.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 24/03/12
 *         Time: 22:05
 */
public class OrganizationActionBeanTest extends CmsTest {
// ------------------------------ FIELDS ------------------------------

    public static final String COBALTO_LABS_SAS = "Cobalto Labs SAS";
    public static final String COBALTO = "Cobalto";
    private OrganizationActionBean actionBean;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private ObjectMapper objectMapper;

// -------------------------- OTHER METHODS --------------------------

    @Test
    public void all() throws IOException {
        final JsonResolution all = (JsonResolution) actionBean.all();
        assertThat(((List<Organization>) all.getObject()).size(), equalTo(1));
    }

    @Test
    public void badDeleteForm() {
        Organization organization = new Organization();
        organization.setId(-1);
        actionBean.setOrganization(organization);
        try {
            actionBean.deleteForm();
            fail();
        } catch (OrganizationNotFoundException e) {
            //expected
        }
    }

    @Test
    public void badInsert() throws IOException {
        Organization organization = new Organization();
        organization.setName(COBALTO_LABS_SAS);
        organization.setDescription("Copy");
        actionBean.setOrganization(organization);
        final JsonResolution insert = (JsonResolution) actionBean.insert();
        Map<String, Object> result = (Map<String, Object>) insert.getObject();
        assertThat(((Boolean) result.get("ok")), equalTo(false));
    }

    @Test
    public void badUpdateForm() {
        Organization organization = new Organization();
        organization.setId(-1);
        actionBean.setOrganization(organization);
        try {
            actionBean.updateForm();
            fail();
        } catch (OrganizationNotFoundException e) {
            //expected
        }
    }

    @Test
    public void delete() throws IOException {
        Organization organization = new Organization();
        organization.setId(1);
        actionBean.setOrganization(organization);
        actionBean.delete();
        assertThat(organizationService.getAll().size(), equalTo(0));
    }

    @Test
    public void deleteForm() throws IOException, OrganizationNotFoundException {
        Organization organization = new Organization();
        organization.setId(1);
        actionBean.setOrganization(organization);
        final ForwardResolution deleteForm = (ForwardResolution) actionBean.deleteForm();
        assertThat(actionBean.getOrganization(), hasProperty("name", equalTo(COBALTO_LABS_SAS)));
        assertThat(deleteForm.getPath(), equalTo("/WEB-INF/jsp/views/modals/deleteOrg.jsp"));
    }

    @Test
    public void index() throws Exception {
        final ForwardResolution index = (ForwardResolution) OrganizationActionBean.index();
        assertThat(index.getPath(), equalTo("/WEB-INF/jsp/views/organizations.jsp"));
    }

    @Test
    public void insert() throws IOException {
        Organization organization = new Organization();
        organization.setDescription("Test");
        organization.setName("test");
        actionBean.setOrganization(organization);
        actionBean.insert();
        assertThat(organizationService.getAll().size(), equalTo(2));
    }

    @Test
    public void insertForm() {
        final ForwardResolution insertForm = (ForwardResolution) OrganizationActionBean.insertForm();
        assertThat(insertForm.getPath(), equalTo("/WEB-INF/jsp/views/modals/insertOrg.jsp"));
    }

    @BeforeClass
    public void setup() {
        actionBean = new OrganizationActionBean();
        actionBean.injectOrganizationService(organizationService);
        actionBean.injectObjectMapper(objectMapper);
    }

    @Test
    public void update() throws IOException, OrganizationNotFoundException {
        Organization organization = new Organization();
        organization.setId(1);
        organization.setName(COBALTO);
        organization.setDescription("New description");
        actionBean.setOrganization(organization);
        actionBean.update();
        final Organization updatedOrg = organizationService.get(1);
        assertThat(updatedOrg, hasProperty("name", equalTo(COBALTO)));
    }

    @Test
    public void updateForm() throws IOException, OrganizationNotFoundException {
        Organization organization = new Organization();
        organization.setId(1);
        actionBean.setOrganization(organization);
        final ForwardResolution updateForm = (ForwardResolution) actionBean.updateForm();
        assertThat(actionBean.getOrganization(), hasProperty("name", equalTo(COBALTO_LABS_SAS)));
        assertThat(updateForm.getPath(), equalTo("/WEB-INF/jsp/views/modals/updateOrg.jsp"));
    }
}
