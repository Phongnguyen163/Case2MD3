<%--
  Created by IntelliJ IDEA.
  User: HELLO
  Date: 02/06/2022
  Time: 9:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row" style="width: 100%; height: 200px; overflow: hidden"></div>

        <div class="row" style="width: 100%; height: 400px; overflow: hidden">
            <div class="col-4" >lef</div>


            <div class="col-4" style="border:1px solid ; background: royalblue"  >
                <div class="row ">
                    <div class="col-12 pt-5">
                        <form action="#">
                            <center>
                                <p class=" h1 btn btn-dark"> WELCOME</p>
                            </center>
                            <br>
                            <div class="input-group flex-nowrap">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
                            </div>
                            <br>
                            <div class="input-group flex-nowrap">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"></span>
                                </div>
                                <input type="text" class="form-control" placeholder="Passwold" aria-label="Passwold" aria-describedby="addon-wrapping">
                            </div>
                            <br>
                            <button type="button" class="btn btn-primary">singin</button>
                        </form>
                    </div>
                </div>
            </div>


            <div class="col-4" >right</div>
        </div>

        <div class="row" style="width: 100%; height: 200px; overflow: hidden"></div>
    </div>
</body>
</html>
