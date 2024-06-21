function initMap() {
  var myLatLng = {lat: -25.363, lng: 131.044}; // 지도 초기 위치를 설정합니다.
  
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 4,
    center: myLatLng
  });
  
  var marker = new google.maps.Marker({
    position: myLatLng,
    map: map,
    title: 'Hello'
  });
}

// 버튼 요소를 가져옵니다.
const firstBtn = document.querySelector('.first_btn');
const secondBtn = document.querySelector('.second_btn');
const thirdBtn = document.querySelector('.third_btn');

// 각 버튼에 클릭 이벤트 리스너를 추가합니다.
firstBtn.addEventListener('click', () => {
    // 선택된 버튼에만 .selected 클래스를 추가합니다.
    firstBtn.classList.add('selected');
    secondBtn.classList.remove('selected');
    thirdBtn.classList.remove('selected');
});

secondBtn.addEventListener('click', () => {
    // 선택된 버튼에만 .selected 클래스를 추가합니다.
    firstBtn.classList.remove('selected');
    secondBtn.classList.add('selected');
    thirdBtn.classList.remove('selected');
});

thirdBtn.addEventListener('click', () => {
    // 선택된 버튼에만 .selected 클래스를 추가합니다.
    firstBtn.classList.remove('selected');
    secondBtn.classList.remove('selected');
    thirdBtn.classList.add('selected');
});
