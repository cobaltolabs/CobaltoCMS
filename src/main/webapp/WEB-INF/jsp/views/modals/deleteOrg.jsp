<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 23/02/12
  Time: 1:27  
--%>
<%--@elvariable id="actionBean" type="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean"--%>
<s:form beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" method="post" id="deleteForm">
    <div id="messageResponse">

    </div>
    <fieldset>
        <legend><f:message key="delete.org"/>&nbsp;<c:out value="${actionBean.organization.name}"/></legend>
        <div class="form-actions">
            <s:submit name="delete" class="btn btn-primary">
                <f:message key="form.delete"/>
            </s:submit>
        </div>
        <s:hidden name="organization.id"/>
    </fieldset>
</s:form>
<script type="text/javascript">
    $('#deleteForm').validate({
        submitHandler:function (form) {
            $(form).ajaxSubmit({
                dataType:'json',
                clearForm:true,
                success:function (response) {
                    $('input[type="submit"]').attr('disabled','disabled');
                    if (response.ok) {
                        $('#messageResponse').append(Mustache.to_html($('#tempAlert').html(), {type:'alert-success', title:'<f:message key="success"/>', body:'<f:message key="org.deleted"/>'}))
                    } else {
                        $('#messageResponse').append(Mustache.to_html($('#tempAlert').html(), {type:'alert-error', title:'<f:message key="error"/>', body:response.message}))
                    }
                }
            })
        }})
</script>