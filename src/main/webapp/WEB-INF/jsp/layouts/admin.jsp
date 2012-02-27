<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 22/02/12
  Time: 13:30  
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="title" type="java.lang.String"--%>
<s:layout-definition>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <title><c:out value="${title}"/>:Cobalto CMS Admin</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="CobaltoCMS Admin">
        <meta name="author" content="Cobalto Labs SAS">

        <!-- Le styles -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <style>
            body {
                padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
            }
        </style>
        <link href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le fav and touch icons -->

    </head>

    <body>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">Cobalto CMS</a>

                <div class="nav-collapse">
                    <ul class="nav">
                        <li>
                            <s:link beanclass="com.cobaltolabs.cms.core.web.actions.DashboardActionBean">
                                <f:message key="dashboard.title"/>
                            </s:link>
                        </li>
                        <li class="dropdown" id="menuConfig">
                            <a class="dropdown-toggle" href="#menuConfig" data-toggle="dropdown">
                                <f:message key="config.title"/>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <s:link beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean">
                                        <f:message key="organizatios.title"/>
                                    </s:link>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
    </div>

    <div class="container">
        <div class="page-header">
            <h1><c:out value="${title}"/></h1>
        </div>
        <s:layout-component name="main"/>
    </div>
    <!-- /container -->

    <!-- Le javascript
   ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.form.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/mustache.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/admin.js"/>"></script>
    <s:layout-component name="scripts"/>
    </body>
    </html>
</s:layout-definition>
