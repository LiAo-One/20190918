package com.liao.exception;

/**
 * 添加异常
 *
 * @author soft01
 */
public class AddBookExcoption extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 无参
     */
    public AddBookExcoption() {
        super();
    }

    /**
     * 有参
     *
     * @param s 异常信息
     */
    public AddBookExcoption(String s) {
        super(s);
    }
}
