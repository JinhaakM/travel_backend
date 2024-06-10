<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="../css/main.css">
  
<h2 class="user-font">함께 여행을 떠나는 친구를 찾는 공간</h2>
  
<div class="post-container">
  <div class="search-container">
    <input type="text" placeholder="#해시태그로 검색해보세요..." id="search-input" class="user-font user-text-color"> <!-- 사용자 폰트 및 텍스트 색상 적용 -->
    <button type="button" id="search-button" class="user-background-color">검색</button> <!-- 사용자 배경색 적용 -->
  </div>
</div>

<div class="sidebar">
  <ul>
    <li><a href="../jsp/postMake.jsp" class="user-text-color">게시물 만들기</a></li> <!-- 게시물 만들기 버튼에 텍스트 색상 적용 -->
    <li><a href="../jsp/talk.jsp" class="user-text-color">톡(TALK)</a></li> <!-- 톡(TALK) 버튼에 텍스트 색상 적용 -->
        <!-- 필요한 만큼 카테고리를 추가할 수 있습니다. -->
  </ul>
</div>

<div class="container3">
  <button id="openPopup" class="user-background-color user-text-color">수락한 인원 보기</button> <!-- 수락한 인원 보기 버튼에 배경색 및 텍스트 색상 적용 -->
  <div class="popup" id="popup"> <!-- 팝업창 -->
    <span class="close" id="closePopup">&times;</span> <!-- 팝업창 닫기 버튼 -->
    <h2 id="popup-header" class="user-font">수락한 인원</h2>
    <ul id="acceptedList">
      <!-- 여기에 수락한 인원들이 동적으로 추가될 예정입니다. -->
    </ul>
  </div>
</div>

<div class="post-container">
  <!-- 인스타그램 스타일의 게시물 폼 추가 -->
  <div class="instagram-post">
    <div class="profile">
      <img src="../images/profile.jpg" alt="프로필 사진">
      <span class="username user-font user-text-color">username1</span>
    </div>
    <div class="post-content">
      <img src="../images/post-image1.jpg" alt="게시된 사진">
      <p class="user-font">게시된 텍스트 내용</p>
      <p class="user-font">게시된 날짜 및 시간</p>
      <div class="interactions">
        <button class="like-button">좋아요</button>
        <button class="comment-button">댓글</button>
      </div>
    </div>
  </div>
</div>

<div class="post-container">
  <div class="instagram-post">
    <div class="profile">
      <img src="../images/profile.jpg" alt="프로필 사진">
      <span class="username user-font user-text-color">username2</span>
    </div>
    <div class="post-content">
      <img src="../images/post-image2.jpg" alt="게시된 사진">
      <p class="user-font">게시된 텍스트 내용</p>
      <p class="user-font">게시된 날짜 및 시간</p>
      <div class="interactions">
        <button class="like-button">좋아요</button>
        <button class="comment-button">댓글</button>
      </div>
    </div>
  </div>
</div>

<jsp:include page="../include/footer.jsp" /> <!-- 외부 footer를 포함시킵니다. -->
<script src="../script/main.js"></script> <!-- 외부 JavaScript 파일 로드 -->
