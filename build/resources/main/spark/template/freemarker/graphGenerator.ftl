<script type="text/javascript">
    google.charts.load('current', {'packages':['geochart','corechart','line',"calendar"]});
    //google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    google.charts.setOnLoadCallback(drawRegionsMap);
    google.charts.setOnLoadCallback(drawBrowsers);
    google.charts.setOnLoadCallback(drawCountries);
    google.charts.setOnLoadCallback(drawOs);



    function drawRegionsMap() {

        var data = google.visualization.arrayToDataTable([
            ['Country', 'Popularity'],
        <#list allCountries as item>
            <#if item?is_last>
                    [${item}]
            <#else>
                    [${item}],
            </#if>
        </#list>
        ]);

        var options = {
            backgroundColor: '#663399'
        };

        var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

        chart.draw(data, options);
    }



    function drawChart() {
        var dataTable = new google.visualization.DataTable();
        dataTable.addColumn({ type: 'date', id: 'Date' });
        dataTable.addColumn({ type: 'number', id: 'Won/Loss' });

        dataTable = google.visualization.arrayToDataTable([
            ['Year', 'Visits'],
        <#list accDates as item>
        <#if item?is_last>
            [${item}]
        <#else>
            [${item}],
        </#if>
        </#list>

        ]);



        var chart = new google.visualization.Calendar(document.getElementById('curve_chart'));
        var chart2 = new google.visualization.Calendar(document.getElementById('curve_chart2'));

        var options = {
            title: "Red Sox Attendance",
            height: 350
        };

        chart.draw(dataTable, options);
        chart2.draw(dataTable, options);
    }


    function drawOs() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
        <#list allOs as item>
            <#if item?is_last>
                    [${item}]
            <#else>
                    [${item}],
            </#if>
        </#list>
        ]);

        var options = {
            title: 'Operating System usage',
            'width':300,
            'height':300,
            legend: 'none'
        };

        var chart = new google.visualization.PieChart(document.getElementById('theOsGraph'));

        chart.draw(data, options);
    }

    function drawBrowsers() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
        <#list allBrowsers as item>
            <#if item?is_last>
                    [${item}]
            <#else>
                    [${item}],
            </#if>
        </#list>
        ]);

        var options = {
            title: 'Browser Usage',
            'width':300,
            'height':300,
            legend: 'none'
        };

        var chart = new google.visualization.PieChart(document.getElementById('theBrowserGraph'));

        chart.draw(data, options);
    }

    function drawCountries() {

        var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
        <#list allCountries as item>
            <#if item?is_last>
                    [${item}]
            <#else>
                    [${item}],
            </#if>
        </#list>
        ]);

        var options = {
            title: 'Countries visits',
            'width':300,
            'height':300,
            legend: 'none'
        };

        var chart = new google.visualization.PieChart(document.getElementById('theCountryGraph'));

        chart.draw(data, options);
    }
</script>
