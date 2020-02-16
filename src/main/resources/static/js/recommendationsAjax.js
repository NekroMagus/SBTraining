$(document).ready(function () {
       $.ajax({
           url: '/api/teapot',
           type: 'GET' ,
           cache: false,
           success: (data) => {
               let teapot = JSON.stringify(data, null, 4);

               let photo1=$('#photo1');
               let photo2=$('#photo2');
               let photo3=$('#photo3');
               let photo4=$('#photo4');
               let photo5=$('#photo5');
               let photo6=$('#photo6');

               photo1.removeAttr("src");
               photo1.attr("src",teapot[0].wayPhotoFile);

               photo2.removeAttr("src");
               photo2.attr("src",teapot[1].wayPhotoFile);

               photo3.removeAttr("src");
               photo3.attr("src",teapot[2].wayPhotoFile);

               photo4.removeAttr("src");
               photo4.attr("src",teapot[3].wayPhotoFile);

               photo5.removeAttr("src");
               photo5.attr("src",teapot[4].wayPhotoFile);

               photo6.removeAttr("src");
               photo6.attr("src",teapot[5].wayPhotoFile);


               let model1=$('#model1');
               let model2=$('#model2');
               let model3=$('#model3');
               let model4=$('#model4');
               let model5=$('#model5');
               let model6=$('#model6');

               model1.removeAttr("href");
               model1.attr("href","/api/teapot/1");
               $('#model1').html(teapot[0].model);

               model2.removeAttr("href");
               model2.attr("href","/api/teapot/2");
               $('#model2').html(teapot[1].model);

               model3.removeAttr("href");
               model3.attr("href","/api/teapot/3");
               $('#model3').html(teapot[2].model);

               model4.removeAttr("href");
               model4.attr("href","/api/teapot/4");
               $('#model4').html(teapot[3].model);

               model5.removeAttr("href");
               model5.attr("href","/api/teapot/5");
               $('#model5').html(teapot[4].model);

               model6.removeAttr("href");
               model6.attr("href","/api/teapot/6");
               $('#model6').html(teapot[5].model);

           }
       });
