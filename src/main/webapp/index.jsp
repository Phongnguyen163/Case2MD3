<%--
  Created by IntelliJ IDEA.
  User: bachk
  Date: 02/06/2022
  Time: 1:39 CH
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
  <div class="container-fluid" style="background: bisque">
    <div class="row">
      <div class="col-3 mt-3">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeQ-WosSNblZCtZT1pW2ML5pg35hi1E2J0og30cScDfaEWahpzc3_roKh75AdXqrGy-5o&usqp=CAU" alt="">
      </div>
      <div class="col-9 mt-3">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="#">TRANG CHỦ</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav mr-auto my-2 my-lg-0 navbar-nav-scroll" style="max-height: 100px;">
              <li class="nav-item active">
                <a class="nav-link" href="#">Giới Thiệu <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">login</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">logout</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Giỏ Hàng</a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled">Link</a>
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
          <p class="h2">SẢN PHẨM NỔI BẬT</p>
        </center>
      </div>
    </div>


    <div class="row">
      <div class="col-1"></div>
        <div class="col-10 mt-3">
          <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="width: 100%; height: 400px; overflow: hidden"
          >
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="http://anhnendep.net/wp-content/uploads/2015/07/hinh-nen-trai-cay-dep-9.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="https://anhnendep.net/wp-content/uploads/2015/07/hinh-nen-trai-cay-dep-3.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS43VIh9npU5bPQSgFQcilG6CPkJMqJWVfUtYsr943hFBKpOj5-t9rmdSRx2A9LSSYQ3VM&usqp=CAU" class="d-block w-100" alt="...">
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
        <p class="h2">DANH SÁCH SẢN PHẨM</p>
      </center>
      </div>
    </div>


    <div class="row">
      <div class="col-1"></div>
      <div class="col-8">
        <div class="row">
          <div class="col-4 mt-3">
            <div class="card" style="width: 14rem;">
              <img src="https://bloganh.net/wp-content/uploads/2021/03/chup-anh-dep-anh-sang-min.jpg" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
          <div class="col-4 mt-3">
            <div class="card" style="width: 14rem;">
              <img src="https://organicfood.weba.vn/shop/images/organicfood/product/rau/toi_large.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">chi tiết sản  phẩm</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
          <div class="col-4 mt-3">
            <div class="card" style="width: 14rem;">
              <img src="https://organicfood.weba.vn/shop/images/organicfood/product/rau/toi_large.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">chi tiết sản  phẩm</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
          <div class="col-4 mt-3">
            <div class="card" style="width: 14rem;">
              <img src="https://organicfood.weba.vn/shop/images/organicfood/product/rau/toi_large.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">chi tiết sản  phẩm</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
          <div class="col-4 mt-3">
            <div class="card" style="width: 14rem;">
              <img src="https://organicfood.weba.vn/shop/images/organicfood/product/rau/xa-lach-mo-dl_large.jpg
" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">chi tiết sản  phẩm</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-3">
        <div class="dropdown">
          <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-expanded="false">
            DANH SÁCH SẢN PHẨM
          </a>

          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </div>
      </div>
    </div>


    <div class="row">
      <div class="col-3">

      </div>
      <div class="col-6">
        <h1>Công Ty TMHH PHNT</h1>
        <h2>h2. Bootstrap heading</h2>
        <h3>h3. Bootstrap heading</h3>
        <h4>h4. Bootstrap heading</h4>
        <h5>h5. Bootstrap heading</h5>
        <h6>h6. Bootstrap heading</h6>
      </div>
      <div class="col-3"></div>
    </div>


  </div>
    </div>
</div>
  </body>
</html>
