
document.addEventListener('DOMContentLoaded', function() {
	
	$('#btn_1').on("click", function(){
    window.location.assign("addschedule");
    });
    
    $('#btn_2').on("click", function(){
    window.location.assign("mytrip");
    });

	$('#btn_3').on("click", function(){
    window.location.assign("");
    });
    
	$('#btn_4').on("click", function(){
    window.location.assign("");
    });
    
    $('#btn_plan').on("click", function() {
        window.location.assign("planning/main");
    });

var btn = document.querySelector(".search_button");
btn.addEventListener("click", () => {
    var list = document.querySelector(".list");
    var input = document.querySelector(".search_input");
    var parent = document.querySelector(".search_container");
    parent.classList.toggle("active");
    input.focus();
    list.classList.toggle("active");

    // 입력창 검색 스크립트
    var input = document.querySelector('.search_input');
    var list = document.querySelector('.list');
    var originalOrder = Array.from(list.querySelectorAll('li'));
    input.addEventListener('input', function() {
        var searchText = input.value.trim().toLowerCase();
        var items = Array.from(list.querySelectorAll('li'));
        var matchedItems = [];

        if (searchText === '') {
            // 입력란이 비어있을 때, 리스트를 초기 상태로 복원
            originalOrder.forEach(function(item) {
                list.appendChild(item);
            });
        } else {
            items.forEach(function(item) {
                var button = item.querySelector('.btn_u');
                var nname = button.textContent.trim().toLowerCase();
                if (nname.includes(searchText)) {
                    matchedItems.push(item);
                }
            });

            // 포함된 단어를 가진 국가들을 리스트의 상위로 이동시킴
            matchedItems.forEach(function(item) {
                list.prepend(item);
            });

            // 해당 단어가 첫 번째 글자인 국가명이 가장 상단에 위치하도록 조정
            var firstCharItems = list.querySelectorAll('.btn_u');
            for (var i = 0; i < firstCharItems.length; i++) {
                var firstCharItem = firstCharItems[i];
                var firstChar = firstCharItem.textContent.trim().toLowerCase().charAt(0);
                if (firstChar === searchText) {
                    list.insertBefore(firstCharItem.parentElement, list.firstChild);
                    break;
                }
            }
        }
    });
});

    var buttons = document.querySelectorAll('.btn_u');
    buttons.forEach(function(button) {
        var ncode = button.dataset.n_code;
        var pageUrl = "/planning/" + ncode; // 페이지 URL 설정
        button.addEventListener("click", function() {
            window.location.assign(pageUrl); // 페이지로 이동
        });
    });
});// 페이지 매핑?