<%@ tag body-content="scriptless" %>
<script type="text/x-handlebars-template" id="tempAlert">
    <div class="alert alert-block {{ type }}"><a class="close" data-dismiss="alert">&times;</a>
        <h4 class="alert-heading">{{ title }}</h4>
        {{ body }}
    </div>
</script>