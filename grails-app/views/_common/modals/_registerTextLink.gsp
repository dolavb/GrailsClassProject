<!-- 
This modal is used to show a button that initiates the registration action.
-->

<!-- Button to trigger modal if Javascript is available -->
<button href="#RegisterModal" class="btn btn-block btn-primary" role="button" data-toggle="modal">
    <i class="glyphicon glyphicon-signin"></i>
    <g:message code="security.register.label"/>
</button>

<!-- NOTE: the renderDialog MUST be placed outside the NavBar (at least for Bootstrap 2.1.1): see bottom of kickstart.gsp -->
<%--	<g:render template="/_common/modals/registerDialog" model="[item: item]"/>--%>
