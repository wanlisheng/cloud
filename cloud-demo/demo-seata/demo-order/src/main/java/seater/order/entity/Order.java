package seater.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@TableName(value = "demo_order")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
    * id
    */
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 产品id
    */
    private Long productId;

    /**
    * 数量
    */
    private Integer count;

    /**
    * 金额
    */
    private Integer money;

    /**
    * 订单状态：0：创建中；1：已完结
    */
    private Integer status;

}