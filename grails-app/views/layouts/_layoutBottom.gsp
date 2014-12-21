<!-- Enable to insert additional components (e.g., modals, javascript, etc.) by any individual page -->
<g:if test="${pageProperty(name: 'page.include.bottom')}">
    <g:pageProperty name="page.include.bottom"/>
</g:if>
<g:else>
    <!-- Insert a modal dialog for registering (for an open site registering is possible on any page) -->
    <g:render template="/_common/modals/registerDialog" model="[item: item]"/>
</g:else>

<!-- Included Javascript files and other resources -->

<r:layoutResources/>
