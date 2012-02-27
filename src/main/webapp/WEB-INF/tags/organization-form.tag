<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ tag body-content="scriptless" %>
<%@ attribute name="method" required="true" type="java.lang.String" rtexprvalue="true" %>
<s:form beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" method="post" class="form-horizontal"
        id="${method}Form">
    <div id="messageResponse">

    </div>
    <fieldset>
        <legend><f:message key="${method}.org"/></legend>
        <div class="control-group">
            <label class="control-label" for="organization.name">
                <f:message key="organization.name"/>
            </label>

            <div class="controls">
                <s:text name="organization.name" id="organization.name"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="organization.description">
                <f:message key="organization.desc"/>
            </label>

            <div class="controls">
                <s:textarea name="organization.description" id="organization.description"/>
            </div>
        </div>
        <div class="form-actions">
            <s:submit name="${method}" class="btn btn-primary">
                <f:message key="form.${method}"/>
            </s:submit>
        </div>
        <c:if test="${method eq 'update'}">
            <s:hidden name="organization.id"/>
        </c:if>
    </fieldset>
</s:form>
<script type="text/javascript">

    $('#${method}Form').validate({
        submitHandler:function (form) {
            $(form).ajaxSubmit({
                dataType:'json',
                success:function (response) {
                    $('input[type="submit"]').attr('disabled', 'disabled');
                    if (response.ok) {
                        $('#messageResponse').append(Mustache.to_html($('#tempAlert').html(), {type:'alert-success', title:'<f:message key="success"/>', body:'<f:message key="org.${method}"/>'}))
                    } else {
                        $('#messageResponse').append(Mustache.to_html($('#tempAlert').html(), {type:'alert-error', title:'<f:message key="error"/>', body:response.message}))
                    }
                }
            })
        },
        errorElement:'spam',
        errorClass:'help-inline',
        rules:{
            'organization.name':{
                required:true,
                maxlength:32
            },
            'organization.description':{
                required:true,
                maxlength:256
            }
        },
        messages:{
            required:'*',
            maxlength:'<f:message key="max.length"/>'
        }
    })
</script>