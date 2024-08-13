package seater.order.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@TableName("t_user")
@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String username;

    private String mobile;

    private Integer gender;

    private String password;

    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
}
