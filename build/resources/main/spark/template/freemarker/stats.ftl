<#include "/header.ftl">

<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <#include "/navbar.ftl">
    <#include "/sidebar.ftl">
    <#include "/graphGenerator.ftl">

    <main class="mdl-layout__content mdl-color--grey-100">

        <div class="mdl-grid demo-content">
            <div class="demo-charts mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid">
                <div id="theCountryGraph" style=" min-width: 33%"></div>
                <div id="theBrowserGraph" style=" min-width: 33%"></div>
                <div id="theOsGraph" style=" min-width: 33%"></div>


            </div>
            <div class="demo-graphs mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--8-col">
                <div id="curve_chart"></div>
                <div id="curve_chart2"></div>
            </div>
            <div class="demo-cards mdl-cell mdl-cell--4-col mdl-cell--8-col-tablet mdl-grid mdl-grid--no-spacing">
                <div class="demo-updates mdl-card mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-cell--12-col-desktop">
                    <div class="mdl-card__title mdl-card--expand mdl-color--teal-300" style="  background-image: url(${QrUrl});">
                        <h2 class="mdl-card__title-text">QR Code</h2>
                    </div>
                    <div class="mdl-card__supporting-text mdl-color-text--grey-600">
                        Keep this QR code with you at any time so you can access the short url from anywhere, just scan it and it will direct you to the page of the short URL
                    </div>
                </div>
                <div class="demo-separator mdl-cell--1-col"></div>
                <div class="demo-options mdl-card mdl-color--deep-purple-500 mdl-shadow--2dp mdl-cell mdl-cell--4-col mdl-cell--3-col-tablet mdl-cell--12-col-desktop">
                    <div class="mdl-card__supporting-text mdl-color-text--blue-grey-50">
                        <div id="regions_div" ></div>
                    </div>

                </div>
            </div>
        </div>

    </main>
</div>

</body>