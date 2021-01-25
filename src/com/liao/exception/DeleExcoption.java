package com.liao.exception;

/**
 * 删除异常
 *
 * @author soft01
 */
public class DeleExcoption extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 无参
     */
    public DeleExcoption() {
        super();
    }

    /**
     * 有参
     *
     * @param s 异常信息
     */
    public DeleExcoption(String s) {
        super(s);
    }
}
