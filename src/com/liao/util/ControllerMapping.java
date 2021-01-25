package com.liao.util;

/**
 * 自定义 Controller 请求-方法 的映射实体类
 *
 * @author Administrator
 */
@SuppressWarnings("all")
public class ControllerMapping {

    // 定义属性
    private String path;
    private String className;
    private String method;


    public ControllerMapping() {
        super();
    }

    public ControllerMapping(String path, String className, String method) {
        super();
        this.path = path;
        this.className = className;
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "ControllerMapping [path=" + path + ", className=" + className
                + ", method=" + method + "]";
    }


}
