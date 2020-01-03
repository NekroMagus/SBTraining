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
$('#create').submit(function (event) {
  event.preventDefault();
  let type = $('#type').val();
  let model = $('#model').val();
  let color = $('#color').val();
  let volume = $('#volume').val();
  let power = $('#power').val();
  $.ajax({
      url: '/teapot/',
      type: 'POST',
      contentType:'application/json',
      succes: (data) => {
          let json = {
              type: type,
              model: model,
              color: color,
              volume: volume,
              power: power
           };
          $('#feedback1').html(json);
      }
  });
});
