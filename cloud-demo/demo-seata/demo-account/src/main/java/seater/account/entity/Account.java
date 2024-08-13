package seater.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("demo_account")
public class Account implements Serializable {

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
    * 总额度
    */
    private Integer total;

    /**
    * 已用余额
    */
    private Integer used;

    /**
    * 剩余可用额度
    */
    private Integer residue;

    public Account() {}
}