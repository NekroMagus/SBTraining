$('#findButton').submit(function (event) {
    event.preventDefault();
    let id = $('#findInput').val();
    $.ajax({
        url: '/teapot/' + id,
        type: 'GET',
        success: (data) => {
            let result = JSON.stringify(data, null, 4);
            $('#feedback').html(result);
        },
        error: (err) => {
            $('#feedback').html(err);
        }
    });
});
