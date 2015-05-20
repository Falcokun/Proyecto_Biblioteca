/**
 * Created by Ricardo on 14/05/2015.
 * ¿Podrias funcionar por favor?
 */

$(document).ready(function () {
    $('select').material_select();
    $('.modal-trigger').leanModal();
});

function editarLibro(e) {

}

function eliminarLibro(libro) {
    sweetAlert({
        title: "¿Estas seguro de eliminarlo?",
        text: "El Libro sera eliminado de la base de datos",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Eliminarlo",
        closeOnConfirm: false,
        html: false
    }, function(){
        $.ajax({
            url: "./borrarLibro?id="+libro,
            type: "POST",
            success: function(data){
                location.reload();
            }
        });
    });
}
