package com.cqgs.app.common.trade;

/**
 * Created by fuda on 15/8/11.
 */
public enum ResponseStatus {

    /**
     * 版本不一致，强制更新
     */
    INVALID_VERSION(-1),

    /**
     * uid、token不匹配
     */
    INVALID_TOKEN(-2),

    /**
     * 用户已停用
     */
    INVALID_USER(-3),

    /**
     * 用户角色发生变化
     */
    ROLE_CHANGED(-4),

    /**
     * 访问接口成功，业务校验失败或服务器内部错
     */
    FAILED(0),

    /**
     * 访问业务接口成功
     */
    SUCCESS(1);

    private Integer value;

    ResponseStatus(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
