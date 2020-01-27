 let url = location.href;
    let mapping = url.slice(22,url.length);
    let id = mapping.slice(mapping.indexOf("/")+1,url.length);
   $(document).ready( function () {
       $('#addComments').hide();
        $.ajax({
            url: '/api/teapot/' + id,
            type: 'GET',
            cache: false,
            success: (data) => {
                let result = JSON.stringify(data, null, 4);
                $('#feedbackobject').html(result);
            },
            error: (err) => {
                $('#feedbackobject').html(err);
            }
        });

    });
   $('#getComments').submit(function(event){
       $('#getComments').hide();
       $('#addComments').show();
       event.preventDefault();
       $.ajax({
           url: '/comment/' + id,
           type: 'GET',
           cache:false,
           success: (data) => {
               let result = JSON.stringify(data,null,4);
               $('#feedbackcomments').html(result);
           },
           error: (err) => {
               $('#feedbackcomments').html(err);
       }
       });

   });


