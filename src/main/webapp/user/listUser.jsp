<%--
  Created by IntelliJ IDEA.
  User: bachk
  Date: 02/06/2022
  Time: 1:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid" style="background: bisque">
    <div class="row">
        <div class="col-3 mt-3">
            <img src="../image/abc.jpg" alt="">
        </div>
        <div class="col-9 mt-3">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/home">TRANG CHỦ</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse text-center" id="navbarScroll">
                    <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Giới Thiệu <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logins">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/registers">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giỏ Hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products?act=create">Thêm Sản Phẩm</a>
                        </li>
                    </ul>
                    <form class="d-flex" action="/home">
                        <input class="form-control mr-2" type="search" placeholder="Tìm tên sản phẩm" aria-label="Search" name="key">
                        <button class="btn btn-outline-success" type="submit">Tìm</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mt-3">
            <center>
                <p class="h2">SẢN PHẨM NỔI BẬT</p>
            </center>
        </div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10 mt-3">
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 100%; height: 350px; overflow: hidden"
            >
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="http://anhnendep.net/wp-content/uploads/2015/07/hinh-nen-trai-cay-dep-9.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="https://anhnendep.net/wp-content/uploads/2015/07/hinh-nen-trai-cay-dep-3.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="../image/Cam1.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="../image/Nho1.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </button>
            </div>
        </div>

        <div class="col-1"></div>
    </div>

    <table class="table table-dark">
        <thead>
        <tr>


            <th scope="col">Id</th>
            <th scope="col">userName</th>
            <th scope="col">password</th>
            <th scope="col">name</th>
            <th scope="col">phoneNumber</th>
            <th scope="col">roleID</th>
            <th scope="col">ACTION</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.name}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.roleID}</td>
                <td><a href="/users?action=edit&id=${user.id}" class="btn btn-secondary">Sửa</a></td>
                <td>
                    <form action="/users"  id="delete${user.id}" style="display: inline">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${user.id}">
                        <a class="btn btn-danger" onclick="acceptDelete(${user.id})" style="color: blue">Xoá</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
<%--        <c:forEach items="${danhSach}" var="customer" >--%>
<%--            <tr>--%>
<%--                <td><a class="nav-link" href="/Customers?action=edit&id=${customer.id}">EDIT</a>--%>
<%--                    <a class="nav-link" href="/Customers?action=delete&id=${customer.id}">DELETE</a></td>--%>
<%--                <td>${customer.id}</td>--%>
<%--                <td>${customer.name}</td>--%>
<%--                <td>${customer.age}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
        </tbody>
    </table>




    <div class="row mt-3" style="background: lightgray">
        <div class="col-6">
            <nav class="nav flex-column">
                <a class="nav-link active" href="#">Công ty TNHH 4 Thành Viên
                </a>
            </nav>
        </div>
        <div class="col-6">
            <div class="row">
                <div class="col-6">
                    <nav class="nav flex-column">
                        <a class="nav-link active" href="#">VỀ CHÚNG TÔI</a>
                        <a class="nav-link" href="#">Tin Tức</a>
                        <a class="nav-link" href="#">Giỏ Hàng</a>
                        <a class="nav-link" href="#">Dịch Vụ</a>
                        <a class="nav-link" href="#">Liên Hệ</a>
                    </nav>
                </div>
                <div class="col-6">
                    <nav class="nav flex-column">
                        <a class="nav-link active" href="#">SẢN PHẨM</a>
                        <a class="nav-link" href="#">Rau</a>
                        <a class="nav-link" href="#">Hoa Quả</a>
                        <a class="nav-link" href="#">Thực Phẩm Khác</a>
                    </nav>
                </div>
            </div>
        </div>
    </div>


</div>
</div>
</div>
</body>
</html>
