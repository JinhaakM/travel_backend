document.addEventListener('DOMContentLoaded', function() {
    initMap();
});

function initMap() {
    // 기본 지도 설정
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 37.5665, lng: 133.9780},
        zoom: 6
    });
}
