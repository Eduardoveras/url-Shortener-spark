<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div id="chart_div" style="height: 730px;"></div>
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
                    <#list urls as url>
                        <#if url?is_last>
                                [${url.getLatitude()},${url.getLongitude()},'<div class="demo-card-wide mdl-card mdl-shadow--2dp"><div class="mdl-card__title mdl-card--expand"><img class="image-pefect" src="${url.getPreviewURL()}"/></div><div class="mdl-card__title mdl-card--expand"><a href="/p/${url.getShortURL()}"><h2 class="mdl-card__title-text">www.acorta.do/${url.getShortURL()}</h2></a></div><div class="mdl-card__supporting-text">Directs to: ${url.getOriginalURL()}</div><div class="mdl-card__actions mdl-card--border"><a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/p/${url.getShortURL()}/stats">VIEW STATS</a></div><div class="mdl-card__menu"><a href="javascript:fbShare("www.acorta.do/${url.getShortURL()}", "Fb Share", "Facebook share popup", "https://www.colourbox.com/preview/2375712-vector-icon-of-scissors-all-layers-are-grouped.jpg", 520, 350)" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect"><i class="material-icons">share</i></a></div></div>']
                        <#else>
                                [${url.getLatitude()},${url.getLongitude()},'<div class="demo-card-wide mdl-card mdl-shadow--2dp"><div class="mdl-card__title mdl-card--expand"><img class="image-pefect" src="${url.getPreviewURL()}"/></div><div class="mdl-card__title mdl-card--expand"><a href="/p/${url.getShortURL()}"><h2 class="mdl-card__title-text">www.acorta.do/${url.getShortURL()}</h2></a></div><div class="mdl-card__supporting-text">Directs to: ${url.getOriginalURL()}</div><div class="mdl-card__actions mdl-card--border"><a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="/p/${url.getShortURL()}/stats">VIEW STATS</a></div><div class="mdl-card__menu"><a href="javascript:fbShare("www.acorta.do/${url.getShortURL()}", "Fb Share", "Facebook share popup", "https://www.colourbox.com/preview/2375712-vector-icon-of-scissors-all-layers-are-grouped.jpg", 520, 350)" class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect"><i class="material-icons">share</i></a></div></div>'],
                        </#if>
                    </#list>
                ]);

                var options = { showTip: true };

                var map = new google.visualization.Map(document.getElementById('chart_div'));
//STUFFF DONT TOUCH

                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function(position) {
                        pos = {
                            lat: position.coords.latitude,
                            lng: position.coords.longitude
                        };
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

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDlk5Vi0hbljWFCIimhVhJPQnjis0JGARQ&signed_in=true&callback=initMap" async defer>
</script>
</body>
