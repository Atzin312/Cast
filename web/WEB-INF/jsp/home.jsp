<%-- 
    Document   : home
    Created on : 25/08/2021, 02:03:05 PM
    Author     : atzin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- FAICONS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer">

        <!-- BOOTSTRAP LIBRARY V5 -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">


        <link rel="stylesheet" href="../noticiasCastores/resources/css/main.css">
        <link rel="stylesheet" href="../noticiasCastores/resources/css/comentarios.css">


        <title>NOTICIAS</title>
    </head>

    <body>
        

        <div class="menu-container">
            <!-- NAVBAR -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img class="nav-brand-icon" src="./assets/images/discussion.png" alt="" srcset=""></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav ms-auto">
                            <li class="nav-item ms-auto">
                                <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                            </li>
                            <li class="nav-item ms-auto">
                                <a class="nav-link" href="#">Foro</a>
                            </li>
                            <li class="nav-item ms-auto">
                                <a class="nav-link" href="#">Registro</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <!-- NAVIGATION STATE -->
            <div class="navigation-state ps-5">
                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">INICIO</a></li>
                        <li class="breadcrumb-item active" aria-current="page">FORO</li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="container">
            <div class="row pt-5">
                <!-- NOTICES -->
                <div class="notices col">
                    <div class="notices-info row align-items-center">
                        <div class="col">
                            ¿Deseas publicar una nueva noticia? &nbsp; <a id="btnCrearNoticia" data-bs-toggle="modal" data-bs-target="#ModalNoticia"     class="btn btn-info btn-sm">Crear noticia</a>
                        </div>
                        <div class="col-4">
                            <img class="discussion-img" src="../noticiasCastores/resources/imagenes/dialog-image.jpg" alt="" srcset="">
                        </div>
                    </div>
                    <div class="row" id="div_noticias">

                    </div



                    <!-- NAVEGACIÓN -->
                    <div class="row pt-5">
                        <nav aria-label="Navegación">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">Anterior</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Siguiente</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- END NOTICES -->

                <!-- MODAL NOTICIAS -->
                <div id="ModalNoticia" aria-labelledby="mediumModalLabel" class="modal fade" role="dialog" tabindex="-1" aria-hidden="true" >

                    <div class="modal-dialog modal-md modal-dialog-centered">

                        <!-- Modal content-->
                        <div class="modal-content ">

                            <div class="modal-header">
                                <h4 class="modal-title">Nueva noticia</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <div class="d-flex align-items-center justify-content-center modal-body">

                                <div class="row">
                                    <form id="getNuevaNoticia">
                                        <div class="row container ps-5">


                                            <div class="row col-12">
                                                <label class="control-label">ID Personal</label>
                                                <input id="txtIdPersonal" name="txtIdPersonal" type="text" class="form-control form-control-sm" placeholder="" maxlength="100">

                                            </div>
                                            <div class="row col-12">
                                                <label id="txtNombre" class="control-label">Noticia </label>
                                                <textarea name="txtNoticia" id="txtNoticia" class="form-control form-control-sm"/></textarea>
                                            </div>
                                            <br>
                                            <div class="row col-12 ms-auto pt-2">
                                                <button class="mx-auto btn btn-success col-8" id="btnAddNoticia" type="submit" form="getNuevaNoticia">Guardar</button>
                                            </div>

                                        </div>
                                    </form>


                                </div>

                            </div>

                        </div>

                    </div>

                </div>


                <!-- MODAL COMENTARIOS -->
                <div id="ModalComentarios" aria-labelledby="mediumModalLabel" class="modal fade" role="dialog" tabindex="-1" aria-hidden="true" >

                    <div class="modal-dialog modal-md modal-dialog-centered">

                        <!-- Modal content-->
                        <div class="modal-content ">

                            <div class="modal-header">
                                <h4 class="modal-title">Nuevo Comentario</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <div class="d-flex align-items-center justify-content-center modal-body">

                                <div class="row">
                                    <form id="getNuevoComentario">
                                        <div class="row container ps-5">


                                            <div class="row col-12">
                                                <label class="control-label">ID Personal</label>
                                                <input id="txtIdPersonal" name="txtIdPersonalCom" type="text" class="form-control form-control-sm" placeholder="" maxlength="100">

                                            </div>

                                            <div class="row col-12">
                                                <label hidden="true" class="control-label">ID NOTICIA</label>
                                                <input id="txtIdNoticia" name="txtIdNoticia"  hidden="true" type="text" class="form-control form-control-sm" placeholder="" maxlength="100" value=""> 
                                            </div>

                                            <div class="row col-12">
                                                <label id="txtNombre" class="control-label">Comentario </label>
                                                <textarea name="txtNoticia" id="txtComentario" class="form-control form-control-sm"/></textarea>
                                            </div>
                                            <br>
                                            <div class="row col-12 ms-auto pt-2">
                                                <button class="mx-auto btn btn-success col-8 " id="btnAddComentario" type="submit" form="getNuevoComentario">Guardar</button>
                                            </div>
                                        </div>
                                    </form>


                                </div>

                            </div>

                        </div>

                    </div>

                </div>


            </div>
        </div>

        <div class="footer-container">
            <div class="container row mx-auto pt-4">
                <p class="text-center">EMPRESA TEST &copy;</p>
            </div>
        </div>

        <!-- BOOTSTRAP LIBRARY V5 -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
        <!-- VIEW SCRITPS -->
        <!--    <script src="./assets/js/index.js"></script>-->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
        <script src="../noticiasCastores/resources/js/script.js"></script>
    </body>

</html>