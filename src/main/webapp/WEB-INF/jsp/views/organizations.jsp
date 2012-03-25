<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 22/02/12
  Time: 13:51  
--%>
<f:message key="organizatios.title" var="title"/>
<s:layout-render name="/WEB-INF/jsp/layouts/admin.jsp" title="${title}">
    <s:layout-component name="main">
        <cms:row>
            <div class="span12">
                <p><a class="btn btn-primary" href="#" id="btnNew">
                    <f:message key="org.new"/>
                </a></p>
            </div>
        </cms:row>
        <cms:row>
            <div class="span12">
                <p>
                <table class="table table-condensed table-bordered span12">
                    <thead>
                    <tr>
                        <th><f:message key="organization.name"/></th>
                        <th><f:message key="organization.desc"/></th>
                        <th><f:message key="actions"/></th>
                    </tr>
                    </thead>
                    <tbody id="organizations">

                    </tbody>
                </table>
                </p>
            </div>
        </cms:row>

        <div class="modal fade hide" id="modal">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">&times;</a>

                <h3>CobaltoCMS</h3>
            </div>
            <div class="modal-body">

            </div>
        </div>
    </s:layout-component>
    <s:layout-component name="scripts">
        <script type="text/javascript">
            $(function () {
                var modal = $('#modal');
                $('#btnNew').on('click', function () {
                    Admin.formModal('<s:url beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" event="insertForm"/>',
                            modal)
                });
                modal.find('.close').click(function () {
                    all()
                });

                var all = function () {
                    Admin.all('<s:url beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" event="all"/>',
                            $('#organizations'),
                            $('#trOrg'),
                            function () {
                                $('a[data-delete="true"]').on('click', function () {
                                    var $this = $(this);
                                    Admin.formModal('<s:url beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" event="deleteForm"/>/' + $this.data('id'),
                                            modal)
                                });
                                $('a[data-update="true"]').on('click', function () {
                                    var $this = $(this);
                                    Admin.formModal('<s:url beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" event="updateForm"/>/' + $this.data('id'),
                                            modal)
                                })
                            });

                };

                all();
            });
        </script>
        <script type="text/template" id="trOrg">
            {{#items}}
            <tr>
                <td>{{ name }}</td>
                <td>{{ description }}</td>
                <td>
                    <a data-update="true" data-id="{{ id }}" class="btn btn-small btn-warning">
                        <f:message key="update"/>
                    </a>
                    <a data-delete="true" data-id="{{ id }}" class="btn btn-small btn-danger">
                        <f:message key="delete"/>
                    </a>
                </td>
            </tr>
            {{/items}}
        </script>

        <cms:alert-template/>
    </s:layout-component>
</s:layout-render>