package com.cobaltolabs.cms.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 24/03/12
 *         Time: 22:21
 */
@ContextConfiguration("classpath:spring-infrastructure.xml")
@ActiveProfiles("test")
public class CmsTest extends AbstractTransactionalTestNGSpringContextTests {
}
