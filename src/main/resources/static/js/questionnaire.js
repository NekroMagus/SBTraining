$('#buttons').submit(function (event) {
    event.preventDefault();
    $.ajax({
        url: '/check' + $('#buttons').val(),
        type: 'GET',
        cache: false,
        success: (data) => {
        let result = JSON.stringify(data, null, 4);
        alert(result);
},
    error: (err) => {
        alert(err);
    }
    });
})