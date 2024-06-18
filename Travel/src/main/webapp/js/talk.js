document.addEventListener("DOMContentLoaded", function() {
    // 친구 목록 버튼 클릭 시 패널 토글
    document.getElementById('friendsBtn').addEventListener('click', function() {
        togglePanel('friends');
    });

    // 단톡방 목록 버튼 클릭 시 패널 토글
    document.getElementById('groupBtn').addEventListener('click', function() {
        togglePanel('group');
    });

    // 패널 토글 함수
    function togglePanel(panelId) {
        var panel = document.getElementById(panelId + '-panel');
        var otherPanelId = panelId === 'friends' ? 'group' : 'friends';
        var otherPanel = document.getElementById(otherPanelId + '-panel');

        panel.style.display = 'block';
        otherPanel.style.display = 'none';
    }

    // 메시지 전송 버튼 클릭 시 메시지 추가
    var sendButton = document.querySelector('.chat-input button');
    sendButton.addEventListener('click', function() {
        sendMessage();
    });

    // 메시지 입력창에서 엔터 키 입력 시 메시지 추가
    var inputField = document.querySelector('.chat-input input');
    inputField.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            sendMessage();
        }
    });

    // 채팅 메시지 추가 함수
    function addMessage(sender, message) {
        const chatMessages = document.querySelector('.chat-messages');
        const messageDiv = document.createElement('div');
        messageDiv.classList.add('message');
        messageDiv.innerHTML = `<strong>${sender}:</strong> ${message}`;
        chatMessages.appendChild(messageDiv);
        // 채팅창이 넘치지 않도록 스크롤을 아래로 조정
        chatMessages.scrollTop = chatMessages.scrollHeight;
    }

    // 메시지 전송 함수
    function sendMessage() {
        const input = document.querySelector('.chat-input input');
        const message = input.value.trim();
        if (message !== '') {
            addMessage('나', message);
            input.value = '';
        }
    }

    // 톡 나가기 버튼에 클릭 이벤트 추가
    document.getElementById("exitTalk").addEventListener("click", function() {
        // 다른 jsp 파일로 이동하는 코드
        window.location.href = "../jsp/main.jsp";
    });
});
