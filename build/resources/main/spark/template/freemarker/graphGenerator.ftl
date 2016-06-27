<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Year', 'Sales'],
        <#list accDates as item>
        <#if item?is_last>
            [${item}]
        <#else>
            [${item}],
        </#if>
        </#list>

        ]);

        var options = {
            title: 'Short Url Stats',
            curveType: 'function',
                height: 280,
            legend: { position: 'bottom' }
        };

        var chart = new google.visualization.AreaChart(document.getElementById('curve_chart'));
        var chart2= new google.visualization.AreaChart(document.getElementById('curve_chart2'));

        chart.draw(data, options);
        chart2.draw(data, options);
    }
</script>

<script type="text/javascript">
    google.charts.load('current', {'packages':['geomap']});
    google.charts.setOnLoadCallback(drawMap);

    function drawMap() {
        var data = google.visualization.arrayToDataTable([
            ['Country', 'Popularity'],
            ['Germany', 200],
            ['United States', 300],
            ['Brazil', 400],
            ['Canada', 500],
            ['France', 600],
            ['RU', 700]
        ]);

        var options = {};
        options['dataMode'] = 'regions';

        var container = document.getElementById('regions_div');
        var geomap = new google.visualization.GeoMap(container);

        geomap.draw(data, options);
    };
</script>