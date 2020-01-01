$('#findButton').submit(function (event) {
event.preventDefault();
let id = $('#findInput').val();
$.ajax({
    type: "GET",
   url: '/teapot/' + id
});
});
