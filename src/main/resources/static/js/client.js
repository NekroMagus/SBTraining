$(document).ready(function() {
    connect();
});

let stompClient=null;
function connect() {
    var socket = new SockJS('/client');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/messages', function (response) {
            let data = JSON.parse(response.body);
            $('#userMessage').html(data.message);
        });
    });
}