$('#login').submit(function (event) {
    alert("true");
    event.preventDefault();
    let json =
        JSON.stringify({
            login:$('#username').val(),
            password:$('#password').val()
        });
    $.ajax({
        url: '/login',
        type: "POST",
        data: json,
        cache: false,
        contentType: 'application/json',
        success: (data) => {
        alert("helloooooooooo");
    },
    error: (err) => {
        alert("noooooooooooo");
    }
});
});