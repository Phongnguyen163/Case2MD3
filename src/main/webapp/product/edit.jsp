<%--
  Created by IntelliJ IDEA.
  User: bachk
  Date: 02/06/2022
  Time: 1:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


            <%--        (Cop Cái Này)--%>
            <img src="../image/abc.jpg" alt="">




        </div>
        <div class="col-9 mt-3">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/products">TRANG CHỦ</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse text-center" id="navbarScroll">


                    <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Giới Thiệu <span class="sr-only">(current)</span></a>
                        </li>
<%--                        <li class="nav-item">--%>
<%--                            <a class="nav-link" href="#">Đăng nhập</a>--%>
<%--                        </li>--%>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng Xuất</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giỏ Hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products?act=create">Thêm Sản Phẩm</a>
                        </li>
                        <%--                        <li class="nav-item">--%>
                        <%--                            <a class="nav-link" href="/products?act=create">Sửa Sản Phẩm</a>--%>
                        <%--                        </li>--%>
                        <%--                        <li class="nav-item">--%>
                        <%--                            <a class="nav-link" href="#">Xóa Sản Phẩm</a>--%>
                        <%--                        </li>--%>
                    </ul>


                    <form class="d-flex">
                        <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
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


    <div class="row">
        <div class="col-12 mt-3">
            <center>
                <p class="h2">SỬA SẢN PHẨM ĐANG BÁN</p>
            </center>
        </div>
    </div>


    <div class="row">
        <div class="col-1"></div>
        <div class="col-8">
            <div class="row">
                <div class="col-12 mt-3">

                    <%--<form method="post">--%>
                    <%--    <input type="text" name="name">--%>
                    <%--    <input type="text" name="img">--%>
                    <%--    <input type="text" name="numberOfProduct">--%>
                    <%--    <input type="text" name="price">--%>
                    <%--    <select name="categoryid">--%>
                    <%--        <c:forEach items='${categories}' var="ca">--%>
                    <%--            <option value="${ca.id}">${ca.name}</option>--%>
                    <%--        </c:forEach>--%>
                    <%--    </select>--%>
                    <%--    <button>--%>
                    <%--        Thêm--%>
                    <%--    </button>--%>
                    <%--</form>--%>

                    <form method="post">
                        <div class="row" style="width: 100%">
                            <div class="col-12" style="width: 100%">
                                <h5>Tên Sản Phẩm:</h5>
                                <input type="text" class="form-control" name="name" value="${product.name}">
                            </div>
                        </div>
                        <br>
                        <div class="row" style="width: 100%">
                            <div class="col-12" style="width: 100%">
                                <h5>Ảnh cũ Sản Phẩm:</h5>
                                <img src="${product.img}" class="card-img-top" alt="...">
                                <h5 class="mt-2">Ảnh Sản Phẩm thay thế tại đây:</h5>
                                <input type="text" class="form-control mt-2" name="img" value="${product.img}">

<%--                                <input type="text" class="form-control" placeholder="Ảnh" name="${product.img}">--%>
                            </div>
                        </div>
                        <br>
                        <div class="row" style="width: 100%">
                            <div class="col-12" style="width: 100%">
                                <h5>Số Lượng Sản Phẩm:</h5>
                                <input type="number" class="form-control" name="numberOfProduct" value="${product.numberOfProduct}">
                            </div>
                        </div>
                        <br>
                        <div class="row" style="width: 100%">
                            <div class="col-12" style="width: 100%">
                                <h5>Giá Sản Phẩm:</h5>
                                <input type="number" class="form-control" name="price" value="${product.price}">
                            </div>
                        </div>
                        <br>
                        <h5>Danh Mục: </h5>
                        <select name="categoryid">
                            <c:forEach items='${categories}' var="ca">--%>
                                <option value="${ca.id}">${ca.name}</option>
                            </c:forEach>
                        </select>
                        <button class="btn btn-primary">Cập nhật</button>
                    </form>
                </div>

            </div>
        </div>



        <div class="col-3">
            <div class="dropdown">
                <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-expanded="false">
                    DANH MỤC SẢN PHẨM
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">

                    <c:forEach items='${categories}' var="ca">
                        <h5><a class="dropdown-item" href="/home?categoryid=${ca.id}">${ca.name}</a></h5>
                    </c:forEach>

                </div>
            </div>
        </div>



    </div>


    <div class="row" style="background: lightgray">
        <div class="col-6">
            <nav class="nav flex-column">
                <a class="nav-link active" href="#">Công ty TNHH 4 Thành Viên</a>
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