package seater.storage.service.impl;

import seater.storage.dao.StorageMapper;
import seater.storage.entity.Storage;
import seater.storage.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Override
    public void decrease(Long productId, Integer count) {
        Storage storage = lambdaQuery().eq(Storage::getProductId, productId).one();

        lambdaUpdate().set(Storage::getUsed, storage.getUsed() + count)
                .set(Storage::getResidue, storage.getResidue() - count)
                .eq(Storage::getProductId, productId)
                .update();
    }
}
