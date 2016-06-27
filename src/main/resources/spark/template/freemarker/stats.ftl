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

        <!-- Image card -->
        <style>
            .demo-card-image.mdl-card {
                width: 256px;
                height: 256px;
                background: url('http://api.qrserver.com/v1/create-qr-code/?data=http://www.google.com&size=150x150&color=0-0-0&bgcolor=FFFFFF&format=png') center / cover;
            }
            .demo-card-image > .mdl-card__actions {
                height: 52px;
                padding: 16px;
                background: rgba(0, 0, 0, 0.2);
            }
            .demo-card-image__filename {
                color: #fff;
                font-size: 14px;
                font-weight: 500;
            }
        </style>

        <div class="demo-card-image mdl-card mdl-shadow--2dp">
            <div class="mdl-card__title mdl-card--expand"></div>
            <div class="mdl-card__actions">
                <span class="demo-card-image__filename">Image.jpg</span>
            </div>
        </div>
    </main>
</div>

</body>