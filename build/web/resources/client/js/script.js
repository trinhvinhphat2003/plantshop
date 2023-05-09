

// $(document).ready(function() {
//     $("#user-table").hover(function() {
//         console.log("them style");
//         $("#sub-menu-user").css("display", "block");
//     }, function() {

//     })
// })
$(document).ready(function() {
    let click = true
    // $("").hover(function () {
    //     console.log("them style");
    //         $("#sub-menu-user").css("display", "block");
    //     }, function () {
    //         $("#sub-menu-user").css("display", "none");
    //     }
    // );
    $("#user-table").click(function (e) { 
        if(click == true) {
            $("#sub-menu-user").css("display", "block");
            click = false;
        } else {
            $("#sub-menu-user").css("display", "none");
            click = true;
        }
    });
})

