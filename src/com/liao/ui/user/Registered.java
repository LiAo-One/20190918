/*
 * RegisterFrom.java
 *
 * Created on __DATE__, __TIME__
 */

package com.liao.ui.user;

import java.util.Locale;

import javax.swing.JOptionPane;

import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.ui.LoginFrom;
import com.liao.util.ResJson;

/**
 * @author __USER__
 */

/**
 * 注册界面
 */
@SuppressWarnings("all")
public class Registered extends javax.swing.JFrame {
    static UserService userService = (UserService) ObjectFactory
            .getBean("UserService");

    /** Creates new form RegisterFrom */
    public Registered() {
        initComponents();
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NameTest = new javax.swing.JTextField();
        AccountText = new javax.swing.JTextField();
        PassText = new javax.swing.JTextField();
        AgeText = new javax.swing.JTextField();
        ImgText = new javax.swing.JTextField();
        SubmitBut = new javax.swing.JButton();
        CancelButt = new javax.swing.JButton();
        ConfirmPwd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SexText = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jLabel1.setText("\u6ce8\u518c");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel2.setText("\u59d3\u540d");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel3.setText("\u5e10\u53f7");

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel4.setText("\u5bc6\u7801");

        jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel6.setText("\u6027\u522b");

        jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel7.setText("\u5e74\u9f84");

        jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel8.setText("\u5934\u50cf");

        NameTest.setFont(new java.awt.Font("微软雅黑", 0, 15));
        NameTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTestActionPerformed(evt);
            }
        });

        AccountText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        PassText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        AgeText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        ImgText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        SubmitBut.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SubmitBut.setText("\u63d0\u4ea4");
        SubmitBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitButMouseClicked(evt);
            }
        });

        CancelButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        CancelButt.setText("\u53d6\u6d88");
        CancelButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtMouseClicked(evt);
            }
        });
        CancelButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        ConfirmPwd.setFont(new java.awt.Font("微软雅黑", 0, 15));
        ConfirmPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel5.setText("\u786e\u8ba4\u5bc6\u7801");

        SexText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SexText.setModel(new javax.swing.DefaultComboBoxModel(new String[]{
                "男", "女"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(14, 14,
                                                                        14)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        jLabel3)
                                                                                .addComponent(
                                                                                        jLabel2)))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(
                                                                        jLabel8))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(
                                                                        jLabel7))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(
                                                                        jLabel6))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(
                                                                        jLabel5))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(
                                                                        jLabel4)))
                                .addGap(79, 79, 79)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SexText, 0, 146,
                                                        Short.MAX_VALUE)
                                                .addComponent(
                                                        ConfirmPwd,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        146, Short.MAX_VALUE)
                                                .addComponent(
                                                        AgeText,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        146, Short.MAX_VALUE)
                                                .addComponent(
                                                        ImgText,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        146, Short.MAX_VALUE)
                                                .addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        SubmitBut)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        20,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        CancelButt))
                                                .addComponent(
                                                        PassText,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        146, Short.MAX_VALUE)
                                                .addComponent(
                                                        AccountText,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        146, Short.MAX_VALUE)
                                                .addComponent(
                                                        NameTest,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        146, Short.MAX_VALUE))
                                .addGap(278, 278, 278))
                .addGroup(
                        layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        122,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(157, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        43,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(
                                                        NameTest,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(
                                                        AccountText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        PassText,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(11, 11,
                                                                        11))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        jLabel4)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(
                                                        ConfirmPwd,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6)
                                                .addComponent(
                                                        SexText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(
                                                        AgeText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel8)
                                                .addComponent(
                                                        ImgText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        34, Short.MAX_VALUE)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(CancelButt)
                                                .addComponent(SubmitBut))
                                .addGap(31, 31, 31)));
        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    private void NameTestActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /**
     * 注册取消按钮
     * @param evt
     */
    private void CancelButtMouseClicked(java.awt.event.MouseEvent evt) {
        new LoginFrom().setVisible(true);
        this.dispose();
    }

    /**
     * 注册提交按钮
     */
    private void SubmitButMouseClicked(java.awt.event.MouseEvent evt) {
        User user = new User();
        //		查询id大小赋值
//		user.setId(userService.selectUserAll() + 1 + "");
        //		获取姓名
        user.setNikeName(NameTest.getText());
        //		帐号
        user.setLoginName(AccountText.getText());
        //		获取密码
        String pwd = this.PassText.getText();
        //		获取确认密码
        String pwds = this.ConfirmPwd.getText();
        //		判断两次密码是否一致
        if (pwd.equals(pwds)) {
            user.setLoginPwd(pwds);
        } else {
            JOptionPane.showMessageDialog(null, "密码不一致");
            return;
        }
        //		密码
        user.setLoginPwd(PassText.getText());
        //		性别
        user.setSex((String) this.SexText.getSelectedItem());
        //		年龄
        user.setAge(AgeText.getText());
        //		头像
        user.setImg(ImgText.getText());
        //		等级默认注册为1级
        user.setLev("1");
        //		判断用户名是是否重复
        ResJson json = userService.repeatName(user);
        //		判断结果
        if (json.getSub()) {
            //			没有重复
            //			执行注册
            ResJson rejs = userService.addUser(user);
            //			判断注册结果
            if (rejs.getSub()) {
                //				注册成功，界面跳转
                JOptionPane.showMessageDialog(null, "注册成功,即将跳转到登录页面");
                new LoginFrom(user).setVisible(true);
                //				销毁界面
                this.dispose();
            } else {
                //				注册失败，打印异常信息
                JOptionPane.showMessageDialog(null, rejs.getStr());
            }
        } else {
            //			用户名重复，打印信息
            JOptionPane.showMessageDialog(null, json.getStr());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registered().setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JTextField AccountText;
    private javax.swing.JTextField AgeText;
    private javax.swing.JButton CancelButt;
    private javax.swing.JTextField ConfirmPwd;
    private javax.swing.JTextField ImgText;
    private javax.swing.JTextField NameTest;
    private javax.swing.JTextField PassText;
    private javax.swing.JComboBox SexText;
    private javax.swing.JButton SubmitBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

}