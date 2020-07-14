$('#password').submit(function (event) {
   event.preventDefault();
   check();
});
let json =
    JSON.stringify({
        login: $('#login').val(),
        password: $('#password').val(),
    });

function check() {
    alert("checking....");
    $.ajax({
        url: '/check',
        type: 'POST',
        data: json,
        cache: false,
        success: (data) => {
            if(data!="null") {
               log_in(data);
            }
            else if (data=="null") {

            }
        },
        error: (err) => {
            console.log("Something wrong");
        }
    });
}

function log_in(token) {
    alert(token);
    $.ajax({
        url: '/login',
        type: 'POST',
        data: json,
        Authorization: "Bearer " + token,
        cache: false,
        success: (data) => {
          if(data) document.getElementById('app').innerHTML="<p>You have been authorized</p>";
          else console.log("Something wrong");
        },
        error: (err) => {
            console.log("no");
        }
    });
}

function regPage() {

}