/**
 * 
 */
$(document).ready(function(){
			wsOpen();
			var checkw="ws://" + location.host + "/planGoTotal";
			console.log(checkw);
});
		var ws;
        function wsOpen() {
            ws = new WebSocket("ws://" + location.host + "/planGoTotal");

            ws.onmessage = function(event) {
                var message = event.data;
                document.getElementById("seoul").innerText = message;
            };

            ws.onclose = function(event) {
                console.log("WebSocket connection closed");
            };
        }

        
        
    