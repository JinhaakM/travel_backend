document.addEventListener('DOMContentLoaded', function() {
	
const calendarDates = document.getElementById("calendarDates");
const currentMonthElement = document.getElementById("currentMonth");
const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");

const today = new Date(); // 현재 날짜를 나타내는 Date 객체를 저장한다.
let currentMonth = today.getMonth();
// 현재 월을 나타내는 값을 저장한다. getMonth()는 0부터 시작하는 월을 반환 1월이면 0, 2월이면 1을 반환한다.
let currentYear = today.getFullYear(); // 변수에 현재 연도를 나타내는 값을 저장한다.

let departureDate= null;
let arrivalDate= null;
let startDayOfWeek= null;

function renderCalendar() {
    //renderCalendar()는 캘랜더를 생성하고 표시하는 함수
    const firstDayOfMonth = new Date(currentYear, currentMonth, 1);
    //firstDayOfMonth 변수에 현재 월의 첫 번째 날짜를 나타내는 Date 객체를 저장한다. 해당 월의 첫 번째 날짜에 대한 정보를 얻는다.
    const daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();
    // daysInMonth 변수에 현재 월의 총 일 수를 나타내는 값을 저장 해당 월이 몇 일까지 있는지 알 수 있다.
    startDayOfWeek = firstDayOfMonth.getDay();
    // 현재 월의 첫 번째 날짜의 요일을 나타내는 값을 저장 해당 월의 첫 번째 날짜가 무슨 요일인지 알 수 있다.
    currentMonthElement.textContent = `${currentYear}년 ${currentMonth + 1}월`;
    // 월을 나타내는 요소에 현재 월과 연도를 설정하여 표시

    calendarDates.innerHTML = ""; // 그리드 컨테이너를 비우기

    // 빈 날짜(이전 달)
    for (let i = 0; i < startDayOfWeek; i++) {
        const emptyDate = document.createElement("div");
        //  빈 날짜를 나타내는 div 요소를 생성
        emptyDate.classList.add("date", "empty");
        // div 요소에 "date"와 "empty" 클래스를 추가
        calendarDates.appendChild(emptyDate);
        // 생성한 빈 날짜 요소를 캘린더 그리드에 추가
    }

    // 현재 달의 날짜
    for (let i = 1; i <= daysInMonth; i++) {
        const dateElement = document.createElement("div");
        dateElement.classList.add("date");// 날짜마다 고유 클래스 추가
        const date= new Date(currentYear, currentMonth, i);
        const dayOfWeek= date.getDay();// 현재 날짜의 요일을 가져온다 0~6으로 일~토
    
        dateElement.classList.add("date");
    
        dateElement.textContent = i;
        dateElement.addEventListener("click",() => dateClick(i));
        calendarDates.appendChild(dateElement);
    
        if(dayOfWeek == 0){
	        const uniqueId = `sunday`; // 일요일에만 Id 생성
            dateElement.id = uniqueId; // 생성한 ID를 할당
	    }
	    if(dayOfWeek == 6){
	        const uniqueId = `saturday`; // 일요일에만 Id 생성
            dateElement.id = uniqueId; // 생성한 ID를 할당
        }
    }
  /* 
  1. for 문을 이용하여 현재 월의 총 일 수만큼 반복하여 월의 날짜를 순서대로 표시한다.
  2. const dateElement = document.createElement("div");를 통해 날짜를 나타내는 div 요소를 생성
  3. dateElement.classList.add("date");를 통해 생성한 div 요소에 "date" 클래스를 추가
  4. dateElement.textContent = i;를 통해 해당 날짜 값을 div 요소의 텍스트로 설정
  5. calendarDates.appendChild(dateElement);를 통해 생성한 날짜 요소를 캘린더 그리드에 추가
  */
 
 highlightSelectedDates();
}

function dateClick(day){
	const selectedDate= new Date(currentYear, currentMonth, day);// 선택된 날짜 생성
	
	if(! departureDate || (departureDate && arrivalDate)){
	// 출발일이 없는경우, 출발일과 도착일이 모두 존재하는 경우, 선택한 날짜가 출발일 이후인 경우
		departureDate = selectedDate; // 출발일을 선택날짜로 설정
		arrivalDate= null;// 도착일 초기화
		clearSelectedDates();// 선택날짜 초기화
	}else if (!arrivalDate && selectedDate > departureDate){
		arrivalDate= selectedDate;//선택한 날짜를 도착일로 설정
	}
	
		highlightSelectedDates();
		displaySelectedDates();
}


function highlightSelectedDates(){
	if(!departureDate || !arrivalDate) return;// 출발일, 도착일이 없으면 종료
	
	const start= departureDate < arrivalDate ? departureDate : arrivalDate;//시작일 설정
	const end= departureDate > arrivalDate ? departureDate : arrivalDate;// 종료일 설정
	
	// 모든 날짜에 대해 반복
	const dateElements= document.querySelectorAll(".date");
	dateElements.forEach(dateElement =>{
		const day= parseInt(dateElement.textContent);// 날짜를 숫자로 파싱
		const date= new Date(currentYear, currentMonth, day);// 해당월의 날짜 생성
        
		if (date >= start && date <= end){// 범위내에 있는 경우 날짜 요소에 selected 클래스 추가
			dateElement.classList.add("selected");
			//선택한 날짜가 시작일과 같으면 departureDate id 할당
	    if (date.getTime() === start.getTime()){
			dateElement.id= "departureDate";
			// 선택한 날짜가 종료일과 같으면 arrivalDate id 할장
		}else if(date.getTime()=== end.getTime()){
			dateElement.id="arrivalDate";
		}
		}
	});
}

function displaySelectedDates(){
	const departureText = departureDate ? `${formatDate(departureDate)} (${getDayOfWeek(departureDate)})` : "";
    const arrivalText = arrivalDate ? `${formatDate(arrivalDate)} (${getDayOfWeek(arrivalDate)})` : "";
	document.getElementById("selectedDates").textContent = `${departureText} - ${arrivalText}`;
}

function clearSelectedDates(){
	const dateElements= document.querySelectorAll(".date");
	dateElements.forEach(dateElement =>{
		dateElement.classList.remove("selected");// class 제거
	});
	
	displaySelectedDates();
}

function formatDate(date){
	const year= date.getFullYear();
	const month= String(date.getMonth() +1).padStart(2, '0');
	const day= String(date.getDate()).padStart(2, '0');
	return year+ '-'+ month+ '-'+ day;
}

function getDayOfWeek(date){
	const daysOfWeek= ['일', '월', '화', '수', '목', '금', '토'];
	return daysOfWeek[date.getDay()];
}

renderCalendar();
// 페이지가 로드되면 renderCalendar 함수를 실행하여 초기 캘린더를 표시

prevBtn.addEventListener("click", () => {
  currentMonth--;
  if (currentMonth < 0) {
    currentMonth = 11;
    currentYear--;
  }
renderCalendar();
});
// prevBtn클릭하면 이전월로 변경, 년도가 바뀌어야한다면 년도 변경 후 renderCalendar()로 캘린더 표시

nextBtn.addEventListener("click", () => {
  currentMonth++;
  if (currentMonth > 11) {
    currentMonth = 0;
    currentYear++;
  }
renderCalendar();
});
// nextBtn클릭하면 다음월로 변경, 년도가 바뀌어야한다면 년도 변경 후 renderCalendar()로 캘린더 표시
const createBtn= document.getElementById('create_btn');
const travelForm = document.getElementById('travelForm');
const departureDateInput = document.getElementById('departureDateInput');
const arrivalDateInput = document.getElementById('arrivalDateInput');
const destinationInput = document.getElementById('destinationInput');
createBtn.addEventListener('click', function() {
    // 출발일과 도착일, 그리고 도착지 정보를 hidden input 요소에 할당합니다.
    departureDateInput.value = departureDate ? formatDate(departureDate) : '';
    arrivalDateInput.value = arrivalDate ? formatDate(arrivalDate) : '';

    // 선택된 도시들의 정보를 수집하여 도착지 정보로 설정합니다.
    const selectedCities = document.querySelectorAll('.select_city.selected');
    const destinationInfo = Array.from(selectedCities).map(city => city.getAttribute('data-cityCode')).join(', ');
    destinationInput.value = destinationInfo;
    const nationalCode= document.getElementById('create_btn').getAttribute('data-nationalCode');
    const actionUrl= "/itinerary/"+ nationalCode;
    travelForm.action= actionUrl;
    // 폼을 서버로 제출합니다.
    travelForm.submit();
    });
});