document.addEventListener("DOMContentLoaded", function() {
  const acceptedPeople = ["User1", "User2", "User3"];

  // 수락한 인원 동적 추가
  const acceptedList = document.getElementById("acceptedList");
  acceptedPeople.forEach(person => {
    const listItem = document.createElement("li");
    listItem.textContent = person;
    acceptedList.appendChild(listItem);
  });

  const popup = document.getElementById("popup");
  let isDragging = false;
  let startX, startY, popupStartX, popupStartY;

  // 팝업의 초기 위치를 조정합니다.
  const popupRect = popup.getBoundingClientRect();
  const initialX = (window.innerWidth - popupRect.width) / 2 - 100; // 오른쪽 여백 100px
  const initialY = (window.innerHeight - popupRect.height) / 2; // 세로 중앙 정렬

  popup.style.left = initialX + 'px';
  popup.style.top = initialY + 'px';

  function handleDragStart(event) {
    isDragging = true;
    const rect = popup.getBoundingClientRect();
    startX = event.clientX;
    startY = event.clientY;
    popupStartX = rect.left;
    popupStartY = rect.top;
    event.stopPropagation();
  }

  function handleDragEnd() {
    isDragging = false;
  }

  function handleMouseMove(event) {
    if (isDragging) {
      const offsetX = event.clientX - startX;
      const offsetY = event.clientY - startY;
      const newPopupX = popupStartX + offsetX;
      const newPopupY = popupStartY + offsetY;
      popup.style.left = newPopupX + 'px';
      popup.style.top = newPopupY + 'px';
      event.stopPropagation();
    }
  }

  function handleSearchButtonClick(event) {
    const searchTerm = document.getElementById("search-input").value;
    // 검색에 대한 동작 구현
    // 예: 검색어를 가지고 필터링하여 해당하는 결과를 표시하는 등의 동작
    event.stopPropagation();
  }

  function handleOpenPopupClick(event) {
    if (!isDragging) {
      popup.style.display = "block"; // 드래그 중이 아닐 때만 팝업 창을 보이도록 함
    }
    event.stopPropagation();
  }

  function handleClosePopupClick(event) {
    popup.style.display = "none"; // 팝업 창을 숨김
    event.stopPropagation();
  }

  popup.addEventListener('mousedown', handleDragStart);
  document.addEventListener('mouseup', handleDragEnd);
  document.addEventListener('mousemove', handleMouseMove);
  document.getElementById("search-button").addEventListener("click", handleSearchButtonClick);
  document.getElementById("openPopup").addEventListener("click", handleOpenPopupClick);
  document.getElementById("closePopup").addEventListener("click", handleClosePopupClick);
});
