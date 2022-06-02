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
          <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="data:image/jpeg;base64,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" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="https://nld.mediacdn.vn/2020/5/29/doi-hoa-tim-5-1590731334546464136746.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="https://recmiennam.com/wp-content/uploads/2020/09/anh-dep-lam-hinh-nen-2.jpg" class="d-block w-100" alt="...">
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
    <div class="row"></div>
  </div>




  </body>
</html>
