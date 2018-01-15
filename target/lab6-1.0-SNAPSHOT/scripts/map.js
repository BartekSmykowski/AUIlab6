var map;      
var markers = [];
function initialize() {
    var myLatLng = new google.maps.LatLng(54.552163, 18.485913);
    var myOptions = {
      zoom: 15,
      center: myLatLng,
      disableDefaultUI: true,
      zoomControl: true
    };
    map = new google.maps.Map(document.getElementById('mapDiv'),
    myOptions);
    var marker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        title: 'Trefl'
    });          
    
    map.addListener('click', getLonLat);
}

function getLonLat(event){
    deleteMarkers();
    var lat = event.latLng.lat();
    var lon = event.latLng.lng();
    $('#lonField').val(lon);
    $('#latField').val(lat);
    addMarker(event.latLng);
}

function addMarker(location) {
    var marker = new google.maps.Marker({
        position: location,
        map: map
    });
    markers.push(marker);
}

function deleteMarkers() {
    clearMarkers();
    markers = [];
}

function clearMarkers() {
    setMapOnAll(null);
}

function setMapOnAll(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }
}

google.maps.event.addDomListener(window, 'load', initialize);
        

