package com.liao.exception;
@SuppressWarnings("all")
/**
 * 查询异常
 *
 * @author soft01
 */
public class ShowIDExcoption extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 无参
     */
    public ShowIDExcoption() {
        super();
    }

    /**
     * 有参
     *
     * @param s 异常信息
     */
    public ShowIDExcoption(String s) {
        super(s);
    }
}
