
//Crear nueva noticia
$("#getNuevaNoticia").submit(function (event) {
    console.log("Agregando Nueva Noticia");
    event.preventDefault();

    var frm = $(this).serialize();
    console.log("LLegue a js");
    $.ajax({
        method: "POST",
        url: "nuevaNoticia.htm",
        data: frm,
        async: false,
        success: function (result) {
            $("#getNuevaNoticia")[0].reset();
            $('#ModalNoticia').modal('toggle');
            getNoticias();
            getComentarios();
//                                                                $('#ModalExitoso').modal('toggle');
//                                                                
        },
        error: function (result) {
            console.log(result.responseText);
        }
    });
});


//Crear nuevo comentario
$("#getNuevComentario").submit(function (event) {
    console.log("Agregando Nuevo Comentario");
    event.preventDefault();

    var frm = $(this).serialize();
    $.ajax({
        method: "POST",
        url: "nuevoComentario.htm",
        data: frm,
        async: false,
        success: function (result) {
            $("#getNuevoComentario")[0].reset();
            $('#ModalComentarios').modal('toggle');
//                                                                $('#ModalExitoso').modal('toggle');
            getNoticias();
            getComentarios();
        },
        error: function (result) {
            console.log(result.responseText);
        }
    });
});


//Funcion para enlistar noticias
function getNoticias() {

    $.ajax({
        method: "POST",
        url: "noticias.htm",
    }).done(function (noticia) {
        console.log("Datos encontrados.");
        var obj = JSON.parse(noticia);
        console.log(obj);
        $.each(obj, function (key, data) {

            $("#div_noticias").append(`
                <div class="card">
                        <div class="card-header"><i class="fa fa-fire"></i>&nbsp; ${data.nombreCompleto}</div>
                        <div class="card-body">${data.noticia}</div>
            
                         <div class="row comments-section" id="noticia_id_${data.idNoticia}"></div>
                </div>
            `)

        })

    })
}

//Funcion para enlistar Comentarios
function getComentarios() {
    $.ajax({
        method: "POST",
        url: "comentarios.htm",
    }).done(function (comentarios) {
        console.log("Comentarios encontrados.");
        var obj = JSON.parse(comentarios);
        console.log(obj);
        $.each(obj, function (key, data) {

            $("#noticia_id_" + data.idNoticia).append(`<div class="row comments-section">
                            
                            <div class="row justify-content-center mb-4">
                                <div class="col-10">
                                    <div class="comments">
                                        <div class="comment d-flex mb-4">
                                            <div class="flex-grow-1 ms-2 ms-sm-3">
                                                <div class="comment-meta d-flex align-items-baseline">
                                                    <h6 class="me-2">${data.nombreCompleto}</h6>
                                                    <span class="text-muted">2d</span>
                                                </div>
                                                <div class="comment-body">
                                                   ${data.comentario}
                                                </div>
                                                <div class="comment-respond pt-1">
                                                    <a class="btn btn-sm btn-secondary" onclick="abrirModalComentario(${data.idNoticia}); return false;">Responder &nbsp;<i class="fa fa-comment"></i></a>
                                                </div>

                                                </div>
                                            </div>
                                        </div>
                                       
                                    </div>
                                </div>
                            </div>
                        </div>`)


        });

        $("[id^='noticia_id_']").append(`<div class="row justify-content-center">
                                <div class="col-11">
                                    <div class="comment-form d-flex align-items-center">
                                        <div class="flex-shrink-0">
                                            <div class="avatar avatar-sm rounded-circle">
                                                <img class="avatar-img"
                                                    src="https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&crop=faces&fit=crop&h=200&w=200"
                                                    alt="">
                                            </div>
                                        </div>
                                        <div class="flex-grow-1 ms-2 ms-sm-3">
                                            <form>
                                                <textarea class="form-control py-0 px-1 border-0" rows="1" placeholder="Escribe un comentario" style="resize: none;"></textarea>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>`)
    });
}


//Funcion para abrir Modal de Comentario
function abrirModalComentario(idNoticia) {
    const modal_nt = new bootstrap.Modal(document.getElementById('ModalComentarios'));
    const txt_id_nt = document.getElementById('txtIdNoticia');


    txt_id_nt.value = idNoticia;
    modal_nt.show();
}

$(document).ready(function () {
    console.log("Trayendo noticias");
//    event.preventDefault();

    //Enlistar desde un inicio las noticias y comentarios
    getNoticias();
    getComentarios();

});
