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

    <div class="container">
        <div class="row justify-content-around">
            <form method="post" class="col-md-6 bg-light p-3 my-3" id="edit${users.id}">
                <h1 class="text-center text-uppercase h3">Sửa thông tin nhân viên</h1>
                <input type="hidden" name="action" value="edit">
                <input type="hidden" name="id">
                <div class="form-group">
                    <label for="username">Tên tài khoản</label>
                    <span name="username" id="username" class="form-control" >${users.username}</span>
                </div>
                <div class="form-group">
                    <label for="password" >Mật khẩu</label>
                    <input type="text" name="password" id="password" class="form-control" value="${users.password}" required pattern="^\w+$">
                </div>
                <div class="form-group">
                    <label for="name">Tên hiển thị</label>
                    <input type="text" name="name" id="name" class="form-control" value="${users.name}">
                </div>
                <div class="form-group">
                    <label for="phone">Số điện thoại</label>
                    <input type="text" name="phone" id="phone" class="form-control" value="${users.phoneNumber}" pattern="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" title="Nhập không đúng định dạng">
                </div>
                <input type="hidden" name="status" value="true">
                <input type="submit" value="Sửa" class="btn-primary btn-block btn">
            </form>
        </div>
    </div>
    <!-- Footer -->
    <footer id="footer">
        <div class="inner">
            <section>
                <ul class="icons">
                    <li><a href="#" class="icon style2 fa-facebook"><span class="label">Facebook</span></a></li>
                    <li><a href="#" class="icon style2 fa-instagram"><span class="label">Instagram</span></a></li>
                </ul>

                &nbsp;
            </section>

            <ul class="copyright">
                <li>Copyright © 2020 Company Name</li>
                <li>Template by: <a href="https://www.phpjabbers.com/">PHPJabbers.com</a></li>
            </ul>
        </div>
    </footer>
</div>
</body>
<script>
    // function acceptEdit(id) {
    //     if (confirm("Bạn có xác nhận sửa hay không")){
    //         alert("Sửa thành công");
    //         document.getElementById("edit" +id).submit();
    //     }
    //     else alert("Sửa thất bại")
    // }
</script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/main.js"></script>
</html>
