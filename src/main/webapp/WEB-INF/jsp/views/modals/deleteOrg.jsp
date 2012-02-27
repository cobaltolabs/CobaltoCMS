<%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 23/02/12
  Time: 1:27  
--%>
<s:form beanclass="com.cobaltolabs.cms.core.web.actions.OrganizationActionBean" method="post" class="form-horizontal"
        id="insertForm">
    <div id="messageResponse">

    </div>
    <fieldset>
        <legend><f:message key="insert.new.org"/></legend>
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
            <s:submit name="insert" class="btn btn-primary">
                <f:message key="form.insert"/>
            </s:submit>
        </div>
    </fieldset>
</s:form>
<script type="text/javascript">
    $('#insertForm').validate({
        submitHandler:function (form) {
            $(form).ajaxSubmit({
                dataType:'json',
                clearForm:true,
                success:function (response) {
                    if (response.ok) {
                        $('#messageResponse').append(Mustache.to_html($('#tempAlert').html(), {type:'alert-success', title:'<f:message key="success"/>', body:'<f:message key="org.added"/>'}))
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