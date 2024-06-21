document.addEventListener('DOMContentLoaded', function() {
   // 버튼 요소 가져와서 정의
    const firstBtn = document.querySelector('.first_btn');
    const secondBtn = document.querySelector('.second_btn');
    const thirdBtn = document.querySelector('.third_btn');
    
    const countryMain= document.querySelector('.country_main');
    const dateContainer= document.querySelector('.c_container');
    const cityMain= document.querySelector('.city_main');
		
// 현재 URL 가져오기
    var currentUrl = window.location.href;
    // URL에 "main"이 포함되어 있는지 확인
    
if (currentUrl.includes("main")) {
function initdefaultMap() {
        // 지도의 중심 좌표를 설정합니다. 위도(latitude)와 경도(longitude) 값을 지정합니다.
        var myLatLng = {lat: 37.5665, lng: 126.9780};

        // 지도를 생성하고 #map 요소에 표시합니다.
        var map = new google.maps.Map(document.getElementById('map'), {
            center: myLatLng,
            zoom: 10 // 줌 레벨을 조정할 수 있습니다.
        });
    }
initdefaultMap();

    // main과 관련된 테이블 내용 수정
   countryMain.innerHTML= "<tr><th>선택된 국가가 없습니다.</th></tr>"
   dateContainer.innerHTML="<div>날짜를 선택할 수 없습니다.</div>"
   cityMain.innerHTML= "<tr><th>도시를 선택할 수 없습니다.</th></tr>"
   
// 각 버튼에 클릭 이벤트 리스너를 추가
    firstBtn.addEventListener('click', () => {// 선택된 버튼에만 .selected 클래스를 추가하고 선택된 버튼에 해당하는 테이블 표시
        firstBtn.classList.add('selected');
        secondBtn.classList.remove('selected');
        thirdBtn.classList.remove('selected');
        tbCountry.style.display= 'table';

    });

    firstBtn.click()// firstBtn클릭
    
    secondBtn.addEventListener('click', () => {
        firstBtn.classList.remove('selected');
        secondBtn.classList.add('selected');
        thirdBtn.classList.remove('selected');
        dateContainer.style.display= 'flex';

    });

    thirdBtn.addEventListener('click', () => {
        firstBtn.classList.remove('selected');
        secondBtn.classList.remove('selected');
        thirdBtn.classList.add('selected');
        tbCity.style.display= 'table';
    });
    
}else {// url에 main이 포함되어있는지 확인하는 if()
       // main이 포함되어 있지 않은 경우 실행
        // 지도 초기화

var openModalBtn= document.getElementById('createPlan');
    var modal= document.querySelector('.t_modal');
    var modalBackGround= document.getElementById("modalBackGround");
    var closeModalBtn= document.getElementById('closeModal');
        openModalBtn.onclick= function(){
			var hasDateSelectedClass= document.querySelector('.date.selected') !== null;
			var hascitySelectedClass= document.querySelector('.select_city.selected') !== null;
			if(hasDateSelectedClass){
			    if(hascitySelectedClass){
				modal.style.display= 'block';// 모달창 띄우기
				modalBackGround.style.display= 'block';
			    }else{
					alert('여행지를 선택해 주세요');
				}
			}else{
				alert('여행 날짜를 선택해 주세요');
			}
		}// 모달창 열기
	
		closeModalBtn.onclick= function(){
			modal.style.display= 'none';
			modalBackGround.style.display= 'none';
		}// 모달창 확인(모달창 닫기)
	var links= document.querySelectorAll('.airlineTickets img');
	
	function openLink(url){
		window.open(url, '_blank');
	}
	
	links.forEach(function(link){
		link.addEventListener('click', function(click){
			click.preventDefault();
			var id= click.target.id;
			if(id === 'expedia'){
				openLink('https://www.expedia.co.kr');
			}else if(id === 'skyscanner'){
				openLink('https://www.skyscanner.co.kr');
			}else if(id === 'kayak'){
				openLink('https://www.kayak.com');
			}else if( id=== 'tripcom'){
				openLink('https://www.trip.com');
			}
		});
	});
var markers= [];
var map

function initMap() {
    // 지도의 중심 좌표를 설정
    var myLatLng = {lat: latitudes[0], lng: longitudes[0]};
    // 지도 생성
    map = new google.maps.Map(document.getElementById('map'), {
        center: myLatLng,
        zoom: 10 // 줌 레벨을 조정할 수 있습니다.
    });
    // 각 버튼에 대한 클릭 이벤트 리스너를 추가합니다.
    const selectCityButtons= document.querySelectorAll('.select_city');
    selectCityButtons.forEach(function(button) {
		button.addEventListener('click', function(){
			this.classList.toggle('selected');
			const latitude = parseFloat(this.dataset.latitude);
            const longitude = parseFloat(this.dataset.longitude);
            
			// 마커를 표시할 위치 생성
			var cityLatLng = {lat: latitude, lng: longitude};
        // 선택된 마커로 지도 이동
        map.setCenter(cityLatLng);
        map.setZoom(12); // 선택된 마커에 맞게 줌 레벨 조정

        });
	});
    
 const initAutoComplete = () => {
            const input = document.getElementById("placeSearch");
            const options = {
                componentRestrictions: { country: nationalCode },
                fields: ["address_components", "geometry", "name"],
            };

            const autocomplete = new google.maps.places.Autocomplete(input, options);

            autocomplete.addListener("place_changed", () => {
                const place = autocomplete.getPlace();
                if (!place.geometry) {
                    console.error("Place details not found for input: ", input.value);
                    return;
                }

                const lat = place.geometry.location.lat();
                const lng = place.geometry.location.lng();
				const placeName= place.name;
				// form태그 부모 요소 선택
				const form= document.getElementById('travelForm');
				
				// hidden요소 생성 및 설정
				const latInput= document.createElement('input');
				latInput.type= 'hidden';
				latInput.name= 'placeLatitude[]';
				latInput.value= lat;
				form.appendChild(latInput);// form에 추가
				
				const lngInput= document.createElement('input');
				lngInput.type= 'hidden';
				lngInput.name= 'placeLongitude[]';
				lngInput.value= lng;
				form.appendChild(lngInput);
				
				const placeNameInput= document.createElement('input');
				placeNameInput.type= 'hidden';
				placeNameInput.name= 'placeName[]';
				placeNameInput.value= placeName;
				form.appendChild(placeNameInput);
				
                addMarker({lat: lat, lng: lng});
                map.setCenter({ lat, lng });
                
                input.value= '';
            });
        };// initAutoComplete()

function addMarker(position){
	var newMarker= new google.maps.Marker({
		position: position,
		map: map,
		title: 'selected Place',
		icon:{
			url: '../images/map-marker.png'
		}
	});
	// 마커 클릭 이벤트로 마커 삭제 기능추가
	newMarker.addListener('click', function(){
		removeMarker(newMarker);// 클릭한 마커 삭제
	});// newMarker()
	
	markers.push(newMarker);// 배열에 마커 추가하기
    map.setCenter(position);// 지도 이동
    
function removeMarker(markerRemove){
	// markers 배열에서 클릭한 마커 찾기
	markers= markers.filter(function(marker){
		if(marker === markerRemove){
			marker.setMap(null);// 지도에서 마커 제거
			return false;// 배열에서도 마커 제거
		}// if
		return true;// 제거한 마커외 다른 마커 유지
	});// markers 
}// removeMarker()
}// addMarker()
        initAutoComplete();
}// initMap();

initMap();

        // 각 버튼에 클릭 이벤트 리스너를 추가
        firstBtn.addEventListener('click', () => {
            // 선택된 버튼에만 .selected 클래스를 추가하고 선택된 버튼에 해당하는 테이블 표시
            firstBtn.classList.add('selected');
            secondBtn.classList.remove('selected');
            thirdBtn.classList.remove('selected');
            countryMain.style.display = 'flex';
            dateContainer.style.display = 'none';
            cityMain.style.display = 'none';

        });

        firstBtn.click(); // firstBtn 클릭
        
        secondBtn.addEventListener('click', () => {
            firstBtn.classList.remove('selected');
            secondBtn.classList.add('selected');
            thirdBtn.classList.remove('selected');
            countryMain.style.display = 'none';
            dateContainer.style.display = 'flex';
            cityMain.style.display = 'none';

        });

        thirdBtn.addEventListener('click', () => {
            firstBtn.classList.remove('selected');
            secondBtn.classList.remove('selected');
            thirdBtn.classList.add('selected');
            countryMain.style.display = 'none';
            dateContainer.style.display = 'none';
            cityMain.style.display = 'table';

        });
    }

});