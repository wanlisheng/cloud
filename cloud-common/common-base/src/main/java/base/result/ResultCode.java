package base.result;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode implements IResultCode, Serializable {

    ACCESS_UNAUTHORIZED("A00213", "未授权"),
    CLIENT_AUTHENTICATION_FAILED("A00212", "客户端认证失败"),
    DEGRADATION("B0220", "系统功能降级"),
    FLOW_LIMITING("B0210", "系统限流"),
    PARAM_IS_NOT_EMPTY("C00001", "参数不能为空"),
    SERVICE_NO_AUTHORITY("B0221", "服务未授权"),
    SUCCESS("000000", "成功"),
    SYSTEM_EXECUTION_ERROR("999999", "系统执行出错"),
    TOKEN_ACCESS_FORBIDDEN("A00215", "token禁止访问"),
    TOKEN_INVALID_OR_EXPIRED("A00214", "token非法或失效"),
    USERNAME_OR_PASSWORD_ERROR("A00100", "用户名或密码错误"),
    USER_NOT_EXIST("A00101", "用户不存在"),
    ;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private String code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
    }

}
