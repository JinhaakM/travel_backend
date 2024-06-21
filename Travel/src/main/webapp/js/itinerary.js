document.addEventListener('DOMContentLoaded', function() {
	function initMap() {
    // 지도의 중심 좌표를 설정
    var myLatLng = {lat: latitude, lng: longitude};
    // 지도 생성
    map = new google.maps.Map(document.getElementById('map'), {
        center: myLatLng,
        zoom: 10 // 줌 레벨을 조정할 수 있습니다.
    });
    };
    initMap();
});