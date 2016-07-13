<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div id="chart_div" style="height: 727px;"></div>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script>
            google.charts.load('current', { 'packages': ['map'] });
            google.charts.setOnLoadCallback(drawMap);

            function drawMap() {
                var pos = {
                    lat: -34.397,
                    lng: 150.644
                };



                var data = google.visualization.arrayToDataTable([
                    ['Lat', 'Long', 'Name'],
                    <#list allCountries as item>
                        <#if item?is_last>
                                [pos.lat,pos.lng,1]
                        <#else>
                                [pos.lat,pos.lng,1],
                        </#if>
                    </#list>
                ]);

                var options = { showTip: true };

                var map = new google.visualization.Map(document.getElementById('chart_div'));
//STUFFF DONT TOUCH

                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function(position) {
                        var pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
                        data.addRow([pos.lat,pos.lng,1]);
                        map.draw(data, options);
                    }, function() {
                        handleLocationError(true, infoWindow, map.getCenter());
                    });
                } else {
                    // Browser doesn't support Geolocation
                    handleLocationError(false, infoWindow, map.getCenter());
                }

                //YOU CAN TOUHC NOW







            };
        </script>


    </main>
</div>


</body>
