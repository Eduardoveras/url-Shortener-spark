<#include "/header.ftl">

<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <#include "/navbar.ftl">
    <#include "/sidebar.ftl">
    <#include "/graphGenerator.ftl">

    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="width: 60%; margin: 0 auto;">
            <div class="mdl-card__supporting-text" style="width: 100%; margin: 0 auto;">
                <div id="curve_chart" style="width: 900px; height: 500px; margin: 0 auto"></div>
            </div>
        </div>
    </main>
</div>

</body>