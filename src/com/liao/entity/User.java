package com.liao.entity;

public class User {
    //	用户id；
    private String id;
    //	用户名
    private String nikeName;
    //	用户密码
    private String loginName;
    //	用户昵称
    private String loginPwd;
    //	等级
    private String lev;
    //	性别
    private String sex;
    //	年龄
    private String age;
    //	头像
    private String img;
    //	创建时间;
    private String createTime;
    // 余额
    private String balance;

    /**
     * 无参
     */

    public User() {
        super();
    }

    /**
     * 有参
     */
    public User(String id, String nikeName, String loginName, String loginPwd, String lev, String sex, String age, String img, String createTime, String balance) {
		super();
		this.id = id;
		this.nikeName = nikeName;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.lev = lev;
		this.sex = sex;
		this.age = age;
		this.img = img;
		this.createTime = createTime;
		this.balance = balance;
	}

    /**
     * 提供get 和 set方法
     */
    public String getId() {
        return id;
    }


    

	public void setId(String id) {
        this.id = id;
    }


    public String getLoginName() {
        return loginName;
    }


    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }


    public String getLoginPwd() {
        return loginPwd;
    }


    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public String getNikeName() {
        return nikeName;
    }


    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }


    public String getLev() {
        return lev;
    }


    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAge() {
        return age;
    }


    public void setAge(String age) {
        this.age = age;
    }


    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }


    public String getCreateTime() {
        return createTime;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    


    public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", balance=" + balance + ", createTime=" + createTime + ", id=" + id + ", img=" + img + ", lev=" + lev + ", loginName=" + loginName + ", loginPwd=" + loginPwd
				+ ", nikeName=" + nikeName + ", sex=" + sex + "]";
	}

	

}
