var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-saldo_user").html("$" + user.saldo_user.toFixed());

       // getAlquiladas(user.username);
    });

    $("#reservar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-password_user").val(parsedResult.password_user);
                $("#input-nombres_user").val(parsedResult.nombres_user);
                $("#input-apellidos_user").val(parsedResult.apellidos_user);
                $("#input-email_user").val(parsedResult.email_user);
                $("#input-saldo_user").val(parsedResult.saldo_user.toFixed(2));
                $("#input-premium_user").prop("checked", parsedResult.premium_user);
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}
// hasta aqui 
//**
//function getAlquiladas(username) {

/**
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletAlquilerListar",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(habitaciones) {
    let contenido = "";
    if (habitaciones.length >= 1) {
        $.each(habitaciones, function (index, habitacion) {
            habitacion = JSON.parse(habitacion);

            contenido += '<tr><th scope="row">' + habitacion.id_hab + '</th>' +
                    '<td>' + habitacion.nombre_hab + '</td>' +
                    '<td>' + habitacion.precio_hab + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + habitacion.id_hab 
                    + '" disabled ';
            if (habitacion.novedad) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + habitacion.fechaAlquiler + '</td>' +
                    '<td><button id="devolver-btn" onclick= "CheckOut(' + habitacion.id_hab
                    + ');" class="btn btn-danger">Checkout</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverHabitacion(id_hab) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletHabitacionDevolver",
        data: $.param({
            username: username,
            id: id,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo la habitacion");
            }
        }
    });

}
**/

function modificarUsuario() {

    let username = $("#input-username").val();
    let password_user = $("#input-password_user").val();
    let nombres_user = $("#input-nombres_user").val();
    let apellidos_user = $("#input-apellidos_user").val();
    let email_user = $("#input-email_user").val();
    let saldo_user = $("#input-saldo_user").val();
    let premium_user = $("#input-premium_user").prop('checked');
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            password_user: password_user,
            nombres_user: nombres_user,
            apellidos_user: apellidos_user,
            email_user: email_user,
            saldo_user: saldo_user,
            premium_user: premium_user,
        }),
        success: function (result) {
            $("#modificar-error").addClass("d-none");
            $("#modificar-exito").removeClass("d-none");
            setTimeout(function () {
                location.reload();
            }, 500);
        },
        error: function (result) {
            $("#modificar-error").removeClass("d-none");
            $("#modificar-exito").addClass("d-none");
        },
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}