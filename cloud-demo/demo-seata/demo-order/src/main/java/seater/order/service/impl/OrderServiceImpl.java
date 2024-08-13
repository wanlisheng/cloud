package seater.order.service.impl;


import base.result.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seater.order.dao.OrderMapper;
import seater.order.entity.Order;
import seater.order.service.AccountFeignService;
import seater.order.service.OrderService;
import seater.order.service.StorageFeignService;

import java.util.concurrent.TimeUnit;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private AccountFeignService accountFeignService;

    @Autowired
    private StorageFeignService storageFeignService;

    @Autowired
    private RedissonClient redissonClient;


    @Override
    @GlobalTransactional(name = "cloud-create-order", rollbackFor = Exception.class)
    public R createOrder() {

        RLock lock = redissonClient.getLock("createOrder");
        Order order = null;
//        lock.lock();
        boolean lockFlag = false;
        try {
            lockFlag = lock.tryLock(1000, 10000, TimeUnit.MILLISECONDS);
            if (lockFlag) {
                order = Order.builder()
                        .count(10)
                        .money(100)
                        .productId(1L)
                        .status(0)
                        .userId(1L)
                        .build();
                // 创建订单
                save(order);
                // 扣除库存
                storageFeignService.decrease(order.getProductId(), order.getCount());
                // 扣余额
                accountFeignService.decrease(order.getUserId(), order.getMoney());
                // 更新订单状态
                order.setStatus(1);
                updateById(order);
                // 优惠卷

//                        int num = 1 / 0;
//                        TimeUnit.SECONDS.sleep(60);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lockFlag && lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }

        return R.ok();
    }
}
