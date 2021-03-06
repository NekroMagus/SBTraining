$('#findButton').submit(function (event) {
    event.preventDefault();
    let id = $('#findInput').val();
    $.ajax({
        url: '/check',
        type: 'POST',
        cache: false,
        success: (data) => {
            let result = JSON.stringify(data, null, 4);
            $('#feedback').html(result);
        },
        error: (err) => {
            $('#feedback').html(err);
        }
    });
});
$('#create').submit(function (event) {
    event.preventDefault();
    let json =
        JSON.stringify({
            type: $('#type').val(),
            model: $('#model').val(),
            color: $('#color').val(),
            volume: $('#volume').val(),
            power: $('#power').val()
        });
    $.ajax({
        url: '/teapot',
        type: "POST",
        data: json,
        cache: false,
        contentType: 'application/json',
        success: (data) => {
            alert(data);
        },
        error: (err) => {
            alert(err);
        }
    });
});
$('#update').submit(function (event) {
    event.preventDefault();
    let json = JSON.stringify({
        id: $('#id').val(),
        type: $('#typeUpdate').val(),
        model: $('#modelUpdate').val(),
        color: $('#colorUpdate').val(),
        volume: $('#volumeUpdate').val(),
        power: $('#powerUpdate').val()
    });
    $.ajax({
        url: '/teapot',
        type: "PUT",
        cache: false,
        data: json,
        contentType: 'application/json',
        success: (data) => {
            alert(data);
        },
        error: (err) => {
            alert(err);
        }
    });
});
$('#delete').submit(function (event) {
    event.preventDefault();
    let id = $('#idDelete').val();
    $.ajax({
        url: '/teapot/' + id,
        cache: false,
        type: "DELETE",
        success: (data) => {
            alert(data);
        },
        error: (err) => {
            alert(err);
        }
    });
});
$('#getAll').submit(function (event) {
    event.preventDefault();
    $.ajax({
        url: '/teapot',
        cache: false,
        type: "GET",
        success: (data) => {
            let result = JSON.stringify(data, null, 4);
            $('#feedback').html(result);
        },
        error: (err) => {
            $('#feedback').html(err);
        }
    });
});





