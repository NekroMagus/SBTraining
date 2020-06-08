$(document).ready(function () {
   $.ajax({
       url: '/add2',
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
});