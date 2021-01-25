package com.liao.exception;

/**
 * 修改异常
 *
 * @author soft01
 */
public class ModiExcoption extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 无参
     */
    public ModiExcoption() {
        super();
    }

    /**
     * 有参
     *
     * @param s 异常信息
     */
    public ModiExcoption(String s) {
        super(s);
    }
}
