$(document).ready(function() {

    $('#ajax').click(function() {

        $('.get-ajax').text('loading . . .');

        $.ajax({
            type:"GET",
            url:"https://api.meetup.com/2/cities",
            // complete: function(data){
            //     alert(data.status);// S1000
            //     alert(data.description);// Success
            //     // for results you have to iterate because it is an array
            //     let len =  data.results.length;
            //     for(let i=0;i<len;i++ ){
            //         alert(data.results[i]);
            //     }
            success: function(data) {
            // lấy từng value trong 1 object Json
//               let json=JSON.stringify(data.results["0"].zip);
//
//               let json2=JSON.stringify(data.results["0"].country);
//
//
//
//                 alert(json);
//
//                 alert(json2);
//
//                 console.log(data.results["0"].zip);
// console.log(data);



                $('.get-ajax').text(JSON.stringify(data));
            },
            dataType: 'jsonp',
        });
    });

    $('#open').click(function(event) {
        $("#title-show").text("Your Title: "+$("#title-input").val());
        $("#name-show").text("Your Name: "+$("#first-name-input").val()+$("#last-name-input").val());
        $("#position-show").text("Your Position: "+$("#position-input").val());
        $("#company-show").text("Your Company: "+$("#company-input").val());
        $("#business-show").text("Your Business: "+$("#business-input").val());
        $("#employee-show").text("Your Employee: "+$("#employee-input").val());
        $("#color-show").text("Your Street + Nt: "+$("#color").val());
        $("#color1-show").text("Your Addition Information: "+$("#color1").val());
        $("#color2-show").text("Your ZipCode: "+$("#color2").val());
        $("#color3-show").text("Your Place: "+$("#color3").val());
        $("#color4-show").text("Your Country: "+$("#color4").val());
        $("#color5-show").text("Your Code+: "+$("#color5").val());
        $("#color6-show").text("Your Phone Number: "+$("#color6").val());
        $("#color7-show").text("Your Email: "+$("#color7").val());
        $('.hop-thoai').addClass('hien-ra');
        $('.nen-mo').addClass('hien-ra');
    });
    $('.btn-close').click(function(event) {
        $('.hop-thoai').removeClass('hien-ra');
        $('.nen-mo').removeClass('hien-ra');
    });
    $('.nen-mo').click(function(event) {
        $('.hop-thoai').removeClass('hien-ra');
        $('.nen-mo').removeClass('hien-ra');
    });
});
