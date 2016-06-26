<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Year', 'Sales'],
        <#list accDates as item>
            ['2004',  new Date(${item?string["yyyy,MM,dd"]})],
        </#list>
            ['2005',  new Date(2000, 8, 5)],
            ['2006',  new Date(2000, 10, 5)],
            ['2007',  new Date(2000, 12, 5)]
        ]);

        var options = {
            title: 'Company Performance',
            curveType: 'function',
            legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
    }
</script>