package service;

import model.OrderDetail;

import java.util.List;

public interface OrderDetailService extends GeneralService<OrderDetail>{
    List<OrderDetail> findByOrderId(String id);
}
