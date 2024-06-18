document.addEventListener("DOMContentLoaded", function() {
    var toggleButtons = document.querySelectorAll('.toggle-button');
    toggleButtons.forEach(function(button) {
        button.addEventListener('click', function(event) {
            var options = this.parentElement.querySelector('.options');
            if (options.style.display === "block") {
                options.style.display = "none";
            } else {
                closeAllOptions();
                options.style.display = "block";
            }
            event.stopPropagation();
        });
    });

    document.addEventListener('click', function(event) {
        var options = document.querySelectorAll('.options');
        options.forEach(function(option) {
            if (option.style.display === "block" && !option.contains(event.target)) {
                option.style.display = "none";
            }
        });
    });

    function closeAllOptions() {
        var options = document.querySelectorAll('.options');
        options.forEach(function(option) {
            option.style.display = "none";
        });
    }

    function del_check() {
        return confirm("정말로 이 게시물을 삭제하겠습니까?");
    }

    function search(searchInput, searchType) {
        var searchArray = searchInput.split(",");

        for (var i = 0; i < searchArray.length; i++) {
            var searchTerm = searchArray[i].trim();

            if (searchTerm.startsWith("#")) {
                searchTerm = searchTerm.substring(1).trim();
            }

            searchArray[i] = searchTerm;
        }

        document.getElementById("searchInput").value = searchArray.join(",");

        $.ajax({
            url: "/community_board",
            method: "GET",
            data: {
                searchInput: searchArray.join(","),
                searchType: searchType
            },
            success: function(data) {
                var searchResultsHtml = $(data).find("#search-results").html();
                $("#search-results").html(searchResultsHtml);

                var paginationHtml = $(data).find(".pagination").html();
                $(".pagination").html(paginationHtml);
            },
            error: function(xhr, status, error) {
                console.error("Search request failed:", status, error);
            }
        });

        return false;
    }

    $('.hashtag-item').on('click', function() {
        var hashtagText = $(this).text();
        var searchInput = hashtagText;
        var searchType = "";

        search(searchInput, searchType);
    });

    $('.comment-button').on('click', function() {
        var mateno = $(this).data('mateno');
        var commentSectionId = '#comment-section-' + mateno;
        $(commentSectionId).toggle();
        loadComments(mateno);
    });

    $(document).on('submit', '.commentForm', function(event) {
        event.preventDefault();
        var mateno = $(this).data('mateno');
        var commentText = $(this).find('.commentText').val().trim();

        if (commentText !== '') {
            $.ajax({
                type: 'POST',
                url: '/comments/add/' + mateno,
                contentType: 'application/json',
                data: JSON.stringify({
                    commentText: commentText
                }),
                success: function(response) {
                    console.log('댓글이 성공적으로 추가되었습니다.');
                    loadComments(mateno);
                    $(this).find('.commentText').val('');
                }.bind(this),
                error: function(xhr, status, error) {
                    console.error('댓글 추가 중 오류가 발생했습니다:', xhr.responseText);
                }
            });
        } else {
            alert('댓글 내용을 입력하세요.');
        }
    });

    $(document).on('click', '.edit-comment-button', function() {
        var commentNo = $(this).data('commentid');
        var mateno = $(this).data('mateno');
        var newCommentText = prompt('댓글을 수정하세요:', '');

        if (newCommentText !== null && newCommentText.trim() !== '') {
            $.ajax({
                type: 'PUT',
                url: '/comments/update/' + commentNo,
                contentType: 'application/json',
                data: JSON.stringify({
                    commentText: newCommentText
                }),
                success: function(response) {
                    console.log('댓글이 성공적으로 수정되었습니다.');
                    loadComments(mateno);
                },
                error: function(xhr, status, error) {
                    console.error('댓글 수정 중 오류가 발생했습니다:', xhr.responseText);
                }
            });
        } else {
            alert('댓글 내용을 입력하세요.');
        }
    });

    $(document).on('click', '.delete-comment-button', function() {
        var commentNo = $(this).data('commentno');
        var mateno = $(this).data('mateno');

        if (confirm('이 댓글을 삭제하시겠습니까?')) {
            $.ajax({
                url: '/comments/delete/' + commentNo,
                type: 'DELETE',
                success: function(response) {
                    alert('댓글이 삭제되었습니다.');
                    $('#comment-' + commentNo).remove(); // 해당 댓글만 삭제
                },
                error: function(xhr, status, error) {
                    console.error('댓글 삭제 실패:', error);
                    alert('댓글 삭제에 실패했습니다.');
                }
            });
        }
    });

    function loadComments(mateno) {
        console.log("Loading comments for mateno: " + mateno);
        $.ajax({
            type: 'GET',
            url: '/comments/list/' + mateno,
            success: function(comments) {
                var commentSection = $('#comment-list-' + mateno);
                commentSection.empty();

                if (comments.length > 0) {
                    $.each(comments, function(index, comment) {
                        var commentHtml = `
                            <div class="comment" id="comment-${comment.commentNo}">
                                <p class="comment-writer">${comment.commentWriter}</p>
                                <p class="comment-text">${comment.commentText}</p>
                                <button class="edit-comment-button" data-commentid="${comment.commentNo}" data-mateno="${mateno}">수정</button>
                                <button class="delete-comment-button" data-commentno="${comment.commentNo}" data-mateno="${mateno}">삭제</button>
                            </div>
                        `;
                        commentSection.append(commentHtml);
                    });
                } else {
                    commentSection.append('<p class="no-comments">댓글이 없습니다.</p>');
                }
            },
            error: function(xhr, status, error) {
                console.error('댓글 조회 중 오류가 발생했습니다:', xhr.responseText);
            }
        });
    }
});
