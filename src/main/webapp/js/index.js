$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });


});

function autenticarUsuario() {

    let username = $("#usuario").val();
    let password_user = $("#password_user").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            password_user: password_user
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.html?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
function registrarUsuario() {

    let username = $("#input-username").val();
    let password_user = $("#input-password_user").val();
    let password_userConfirmacion = $("#input-password_user-repeat").val();
    let nombres_user = $("#input-nombres_user").val();
    let apellidos_user = $("#input-apellidos_user").val();
    let email_user = $("#input-email_user").val();
    let saldo_user = $("#input-saldo_user").val();
    let premium_user= $("#input-premium_user").prop("checked");

    if (password_user == password_userConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                username: username,
                password_user: password_user,
                nombres_user: nombres_user,
                apellidos_user: apellidos_user,
                email_user: email_user,
                saldo_user: saldo_user,
                premium_user: premium_user
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username=" + username;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}



