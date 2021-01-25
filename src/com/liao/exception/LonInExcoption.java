package com.liao.exception;

/**
 * 登陆异常
 *
 * @author soft01
 */
public class LonInExcoption extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 无参
     */
    public LonInExcoption() {

    }

    /**
     * 有参
     *
     * @param s 异常语句
     */
    public LonInExcoption(String s) {
        super(s);
    }
}
