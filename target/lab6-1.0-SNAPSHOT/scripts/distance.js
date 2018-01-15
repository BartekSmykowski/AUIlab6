function getDistance(){
    $('#distance').html('');
    var latSrc = $('#latField').val();
    var lonSrc = $('#lonField').val();
    var latDst = 54.552163;
    var lonDst = 18.485913;
    var url = "http://localhost:8080/lab6/resources/distance?latSrc="+latSrc+"&lonSrc="+lonSrc + "&latDst="+latDst+"&lonDst="+lonDst;
    $.getJSON(url ,function(data){
        $('#distance').text(data.rows[0].elements[0].distance.text);
        $('#destination').text(data.destination_addresses[0]);
        $('#source').text(data.origin_addresses[0]);
    });
}
