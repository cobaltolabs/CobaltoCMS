package com.cobaltolabs.cms.core.daos;

import com.cobaltolabs.cms.core.Organization;
import com.cobaltolabs.cms.core.OrganizationNotFoundException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 14:51
 */
public interface OrganizationDao extends CmsDao<Integer, Organization, OrganizationNotFoundException> {
}
