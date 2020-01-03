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
  let json =
   JSON.stringify( {
        type : $('#type').val(),
        model : $('#model').val(),
        color : $('#color').val(),
        volume : $('#volume').val(),
        power : $('#power').val()
    });
   $.ajax({
      url: '/teapot',
      type: "POST",
       data: json,
      contentType:'application/json',
      success: (data) => {
          alert(data);
      }
  });
});
 $('#update').submit(function(event) {
    event.preventDefault();
    let json = JSON.stringify({
        id: $('#id').val(),
        type : $('#typeUpdate').val(),
        model : $('#modelUpdate').val(),
        color : $('#colorUpdate').val(),
        volume : $('#volumeUpdate').val(),
        power : $('#powerUpdate').val()
    });
     $.ajax({
         url: '/teapot',
         type: "PUT",
         data: json,
         contentType: 'application/json',
         success: (data) => {
             alert(data);
         }
     });
 });
 $('#delete').submit(function (event) {
  event.preventDefault();
  let id = $('#idDelete').val();
  $.ajax({
      url: '/teapot/' + id,
      type: "DELETE",
      success: (data) => {
          alert(data);
     }
  });
 });
 $('#getAll').submit(function (event) {
   $.ajax({
      url: '/teapot',
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