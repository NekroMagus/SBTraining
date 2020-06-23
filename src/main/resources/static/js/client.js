

var stompClient = null;

$(document).ready(function () {
     connect();
});


function connect() {
    var socket = new SockJS('/message');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        alert("Hello");
        stompClient.subscribe('/chat/messages', function(response){
            showGreeting(JSON.parse(response.body).message);
            sendMessage();
        });
    });
}


function sendMessage() {
    stompClient.send("/app/message", {}, JSON.stringify({
        value: "hello",
    }));
}

function showGreeting(message) {
    alert(message);
}