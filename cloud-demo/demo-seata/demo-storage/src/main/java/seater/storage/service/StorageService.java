package seater.storage.service;

import seater.storage.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


@Service
public interface StorageService extends IService<Storage> {

    void decrease(Long productId, Integer count);
}