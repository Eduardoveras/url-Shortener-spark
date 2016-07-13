<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div id="chart_div" style="height: 727px;"></div>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script>
            google.charts.load('current', { 'packages': ['map'] });
            google.charts.setOnLoadCallback(drawMap);

            function drawMap() {
                var data = google.visualization.arrayToDataTable([
                    ['Country', 'Population'],
                    <#list allCountries as item>
                        <#if item?is_last>
                                ['${item}',1]
                        <#else>
                                ['${item}',1],
                        </#if>
                    </#list>
                ]);
//STUFFF DONT TOUCH

                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function(position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };

                        infoWindow.setPosition(pos);
                        infoWindow.setContent('Location found.');
                        map.setCenter(pos);
                    }, function() {
                        handleLocationError(true, infoWindow, map.getCenter());
                    });
                } else {
                    // Browser doesn't support Geolocation
                    handleLocationError(false, infoWindow, map.getCenter());
                }

                //YOU CAN TOUHC NOW




                var options = { showTip: true };

                var map = new google.visualization.Map(document.getElementById('chart_div'));

                map.draw(data, options);
            };
        </script>


    </main>
</div>


</body>
