$(document).ready(function () {
   for(let id=1;id<=6;id++) {
       $.ajax({
           url: '/good/teapot/' + id,
           type: 'GET' ,
           cache: false,
           success: (data) => {
               let teapot = JSON.stringify(data, null, 4);
               let photo = $('#photo' + id);
               photo.removeAttr("src");
               photo.attr("src",teapot[7])
               $('#model' + id).html(teapot[2]);
               let model  = $('#model' + id);
               model.removeAttr("src");
               model.attr("src","/api/teapot/" + id);
           }
       });
   }
});