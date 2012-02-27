package com.cobaltolabs.cms.core.daos.impl;

import com.cobaltolabs.cms.core.Organization;
import com.cobaltolabs.cms.core.OrganizationNotFoundException;
import com.cobaltolabs.cms.core.daos.OrganizationDao;
import com.cobaltolabs.cms.core.daos.mybatis.OrganizationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cobaltolabs.cms.core.daos.DaoUtils.manageNull;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 14:52
 */
public class OrganizationDaoImpl extends AbstractMyBatisCmsDao<Integer, Organization, OrganizationNotFoundException> implements OrganizationDao {
    private static final Logger log = LoggerFactory.getLogger(OrganizationDaoImpl.class);
// ------------------------ INTERFACE METHODS ------------------------

    private OrganizationMapper organizationMapper;
// --------------------- Interface CmsDao ---------------------

    @Override
    public Organization find(Integer id) throws OrganizationNotFoundException {
        log.debug("Finding organization with id {}", id);
        return manageNull(organizationMapper.findById(id), new OrganizationNotFoundException());
    }

// --------------------- Interface InitializingBean ---------------------


    @Override
    public void afterPropertiesSet() throws Exception {
        organizationMapper = (OrganizationMapper) mapper;
    }
}
