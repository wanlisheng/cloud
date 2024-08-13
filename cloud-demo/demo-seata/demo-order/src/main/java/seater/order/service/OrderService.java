package seater.order.service;


import base.result.R;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import seater.order.entity.Order;


@Service
public interface OrderService extends IService<Order> {

    R createOrder();

}