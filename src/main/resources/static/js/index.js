$('#findButton').submit(function (event) {
event.preventDefault();
let id = $('#findInput').val();
$.ajax({
   url: '/teapot/' + id
});
});
