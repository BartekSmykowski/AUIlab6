function getWeather(){
    $('#weatherDiv').html('');
    var lat = $('#latField').val();
    var lon = $('#lonField').val();
    var cnt = $('#cntField').val();
    var units = "metric";
    var key = "2508abecb6d9037229e719a6adc445af";
    var url = "http://api.openweathermap.org/data/2.5/forecast/daily?lat="+lat+"&lon="+lon+"&cnt="+cnt+"&units=" + units +"&APPID=" + key;
    $.getJSON(url ,function(data){
        $.each(data.list, function (i, day) {
            var div = $('<div>').addClass('weatherDayDiv').appendTo($('#weatherDiv'));
            var icon = day.weather[0].icon;
            var iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
            $('<img>').attr('src', iconUrl).appendTo(div);
            $('<div>').text("Temperatura:" + day.temp.day).appendTo(div);
            $('<div>').text("Ciśnienie:" + day.pressure).appendTo(div);
            $('<div>').text("Wilgotność:" + day.humidity).appendTo(div);
            $('<div>').text("Prędkość wiatru:" + day.speed).appendTo(div);
            $('<div>').text("Miejsce:" + data.city.name).appendTo(div);
        });
    });
}