<script type="text/javascript">
    google.charts.load('current', {'packages':['geochart','corechart']});
    //google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    google.charts.setOnLoadCallback(drawRegionsMap);

    function drawRegionsMap() {

        var data = google.visualization.arrayToDataTable([
            ['Country', 'Popularity'],
            ['DO', 2]
        ]);

        var options = {
            backgroundColor: '#81d4fa'
        };

        var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

        chart.draw(data, options);
    }



    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Year', 'Visits'],
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
