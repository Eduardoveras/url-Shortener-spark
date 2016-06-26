<#include "/header.ftl">

<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <#include "/navbar.ftl">
    <#include "/sidebar.ftl">
    <#include "/graphGenerator.ftl">

    <main class="mdl-layout__content mdl-color--grey-100">
        <div id="curve_chart" style="width: 900px; height: 500px"></div>
    </main>

</div>

</body>