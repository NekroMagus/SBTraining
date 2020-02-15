$(document).ready(function () {
       $.ajax({
           url: '/api/teapot',
           type: 'GET' ,
           cache: false,
           success: (data) => {
               /* let teapot = JSON.stringify(data, null, 4);
               let photo = $('#photo' + id);
               photo.removeAttr("src");
               photo.attr("src",teapot[7]);
               $('#model' + id).html(teapot[2]);
               let model  = $('#model' + id);
               model.removeAttr("src");
               model.attr("src","/api/teapot/" + id);

                */
               let teapot = JSON.stringify(data,null,4);
               $('#feedback').html(teapot);
           },
           error: (err) => {
               $('#feedback').html(err);
           }
       });
});