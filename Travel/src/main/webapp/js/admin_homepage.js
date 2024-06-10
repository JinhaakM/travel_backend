$(document).ready(function() {
    var pageSize = 10; 
    var currentPage = 1;
    var $userItems = $('.user-item');
    var totalPages = Math.ceil($userItems.length / pageSize);
    
	showPage(currentPage);
	
    function showPage(page) {
        var startIndex = (page - 1) * pageSize;
        var endIndex = page * pageSize;

        $userItems.hide();
        $userItems.slice(startIndex, endIndex).show();

        $('#page-info').text('유저 목록 ' + page + ' of ' + totalPages);
    }
    
    $('#prev').click(function() {
        if (currentPage > 1) {
            currentPage--;
            showPage(currentPage);
        }
    });
    
    $('#next').click(function() {
        if (currentPage < totalPages) {
            currentPage++;
            showPage(currentPage);
        }
    });
});