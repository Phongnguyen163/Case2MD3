
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
                            <a class="nav-link" href="#">Đăng nhập</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Đăng ký</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Giỏ Hàng</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products?act=create">Thêm Sản Phẩm</a>
                        </li>
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
                <p class="h2">CHI TIẾT SẢN PHẨM</p>
            </center>
        </div>
    </div>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-8">
            <div class="row">
                <div class="col-12 mt-3">
                    <div class="card" style="width: 100%;">
                        <img src="${product.img}" class="card-img-top" alt="...">
                        <div class="card-body">

                            <style>
                                .mycolor {
                                    color: red;
                                }
                            </style>
                            <h5 class="card-title">Tên Sản Phẩm: ${product.name}</h5>
                            <p class="card-text">Mô Tả: Sản phẩm đảm bảo chất lượng, nguyên chất 100%, nói không với hóa chất.
                            <p class="mycolor">Được nhập trực tiếp tại nhà Anh Nam đảm bảo nguyên rin. Anh chị có nhu cầu mua sử dụng alo đệ Anh Nam sẽ ship tận giường.</p>
                            Hàng kiểm tra chất lượng trước khi lấy, nếu không phải nguyên chất thì đệ Anh Nam hoàn lại tiền.
                            <p>SĐT Liện hệ: Hỏi Anh Nam :)</p>
                            <p class="card-text" >Giá: ${product.price} VNĐ </p>
                            <p class="card-text" >Danh mục: ${product.categoryzz.name}</p>
                        </div>
                    </div>
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
    <div class="row mt-3" style="background: lightgray">
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