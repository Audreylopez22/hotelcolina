var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?username=" + username);
        
        $("#user-saldo_user").html(user.saldo_user.toFixed(2) + "$");

        getHabitacion(false, "ASC");

        $("#ordenar-id_hab").click(ordenarHabitacion);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getHabitacion(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletHabitacionListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarHabitacion(parsedResult);
            } else {
                console.log("Error recuperando los datos de las Habitaciones");
            }
        }
    });
}
function mostrarHabitacion(habitaciones) {

    let contenido = "";

    $.each(habitaciones, function (index, habitacion) {

        habitacion = JSON.parse(habitacion);
        let precio;

        if (habitacion.id_hab > 0) {

            if (user.premium) {

                if (habitacion.novedad) {
                    precio = (2 - (2 * 0.1));
                } else {
                    precio = (1 - (1 * 0.1));
                }
            } else {
                if (habitacion.novedad) {
                    precio = 2;
                } else {
                    precio = 1;
                }
            }

            contenido += '<tr><th scope="row">' + habitacion.id_hab + '</th>' +
                    '<td>' + habitacion.nombre_hab + '</td>' +
                    '<td>' + habitacion.capacidad_hab + '</td>' +
                    '<td>' + habitacion.camas_hab + '</td>' +
                    '<td>' + habitacion.terraza_hab + '</td>' +
                    '<td>' + habitacion.banos_hab + '</td>' +
                    '<td>' + habitacion.novedad + '</td>' +
                    '<td>' + habitacion.precio + '</td>' +
                    '<td>' + habitacion.estado + '</td>' +
                    '<td><input type="checkbox" name="novedad" id="novedad' + habitacion.novedad + '" disabled ';
            if (habitacion.novedad) {
                contenido += 'checked';
            }
            contenido += '></td>' +
                    '<td>' + precio + '</td>' +
                    '<td><button onclick="alquilarHabitacion(' + habitacion.id_hab +');" class="btn btn-success" ';
            if (user.saldo_user < precio) {
                contenido += ' disabled ';
            }

            contenido += '>Reservar</button></td></tr>'
            
        }
    });
    $("#habitaciones-tbody").html(contenido);
}
// hasta aqui esta revisadoS

function ordenarhabitacion() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getHabitacion(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getHabitacion(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getHabitacion(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}
function alquilarHabitacion(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletHabitacionAlquilar",
        data: $.param({
            id_hab: id,
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                restarDinero(precio).then(function () {
                    location.reload();
                })
            } else {
                console.log("Error en la reserva de la habitacion");
            }
        }
    });
}


async function restarDinero(precio) {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRestarDinero",
        data: $.param({
            username: username,
            saldo: parseFloat(user.saldo_user - precio)

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                console.log("Saldo actualizado");
            } else {
                console.log("Error en el proceso de pago");
            }
        }
    });
}
// desde aqui 
