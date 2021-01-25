/*
 * UserMangement.java
 *
 * Created on __DATE__, __TIME__
 */

package com.liao.ui.user;

import java.awt.JobAttributes;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.liao.entity.Goods;
import com.liao.entity.Order;
import com.liao.entity.User;
import com.liao.exception.AddBookExcoption;
import com.liao.factory.ObjectFactory;
import com.liao.service.UserService;
import com.liao.ui.LoginFrom;
import com.liao.ui.Management;
import com.liao.util.ResJson;

/**
 * @author __USER__
 */

/**
 * 管理用户类
 */
@SuppressWarnings("all")
public class UserMangement extends javax.swing.JFrame {
    //	使用多态指向子类
    static UserService userService = (UserService) ObjectFactory.getBean("UserService");
    private User u;
    //	用来存储执行结果
    private ResJson json;

    /** Creates new form UserMangement */
    public UserMangement() {
        initComponents();
    }

    //	获取传入的值
    public UserMangement(User u) {
        this.u = u;
        initComponents();
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        EditButt = new javax.swing.JButton();
        UpData = new javax.swing.JButton();
        DeleteBut = new javax.swing.JButton();
        AddButt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        AccountText = new javax.swing.JTextField();
        LevText = new javax.swing.JTextField();
        PwdText = new javax.swing.JTextField();
        AgeText = new javax.swing.JTextField();
        ImgText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        SexText = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        AllNum = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pageSizeComBox = new javax.swing.JComboBox();
        onButt = new javax.swing.JButton();
        totalPageLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        currentPage = new javax.swing.JLabel();
        underButt = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jumpText = new javax.swing.JTextField();
        SelectButt = new javax.swing.JButton();
        EscButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
        jLabel1.setText("\u7528\u6237\u7ba1\u7406");

        EditButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        EditButt.setText("\u7f16\u8f91");
        EditButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditButtMouseClicked(evt);
            }
        });

        UpData.setFont(new java.awt.Font("微软雅黑", 0, 15));
        UpData.setText("\u4fee\u6539");
        UpData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpDataMouseClicked(evt);
            }
        });

        DeleteBut.setFont(new java.awt.Font("微软雅黑", 0, 15));
        DeleteBut.setText("\u5220\u9664");
        DeleteBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButMouseClicked(evt);
            }
        });

        AddButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        AddButt.setText("\u6dfb\u52a0");
        AddButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel2.setText("\u59d3\u540d");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel3.setText("\u8d26\u53f7");

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel4.setText("\u7b49\u7ea7");

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel5.setText("\u6027\u522b");

        jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel6.setText("\u5bc6\u7801");

        jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel7.setText("\u5e74\u9f84");

        jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel8.setText("\u5934\u50cf");

        NameText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        AccountText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        LevText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        PwdText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        AgeText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        ImgText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        UserTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{"ID", "姓名", "账号", "密码", "头像", "等级", "性别", "年龄", "时间"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(UserTable);

        SexText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SexText.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"请选择", "男", "女"}));
        SexText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexTextActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel9.setText("\u603b\u6761\u6570");

        AllNum.setText("0");

        jLabel11.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel11.setText("\u6bcf\u9875\u5c55\u793a");

        pageSizeComBox.setFont(new java.awt.Font("微软雅黑", 0, 15));
        pageSizeComBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"5", "10", "15", "25"}));

        onButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        onButt.setText("\u4e0a\u4e00\u9875");
        onButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onButtMouseClicked(evt);
            }
        });

        totalPageLabel.setText("1");

        jLabel13.setText("/");

        currentPage.setText("0");

        underButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        underButt.setText("\u4e0b\u4e00\u9875");
        underButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                underButtMouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton4.setText("\u8df3\u8f6c");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jumpText.setText("0");

        SelectButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SelectButt.setText("\u67e5\u8be2");
        SelectButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectButtMouseClicked(evt);
            }
        });
        SelectButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtActionPerformed(evt);
            }
        });

        EscButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        EscButt.setText("\u8fd4\u56de");
        EscButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EscButtMouseClicked(evt);
            }
        });
        EscButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EscButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addContainerGap().addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                                                .addGroup(
                                                        layout.createSequentialGroup().addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(AllNum,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(55, 55, 55).addComponent(jLabel11)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pageSizeComBox,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(97, 97, 97).addComponent(onButt)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(totalPageLabel).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel13).addGap(1, 1, 1).addComponent(currentPage)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(underButt).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE).addComponent(jButton4).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jumpText, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))).addGap(568, 568, 568)).addGroup(
                                layout.createSequentialGroup().addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(NameText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(26, 26, 26).addComponent(jLabel3)).addGroup(
                                                layout.createSequentialGroup().addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(LevText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(jLabel5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(SexText, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE).addComponent(AccountText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(28, 28,
                                        28).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(
                                                jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addGroup(
                                                layout.createSequentialGroup().addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(AgeText, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(PwdText, javax.swing.GroupLayout.PREFERRED_SIZE, 95,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(27, 27, 27).addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(DeleteBut,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(AddButt,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
                                                                layout.createSequentialGroup().addComponent(jLabel8).addGap(21, 21, 21).addComponent(ImgText,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))).addGap(33, 33, 33).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(SelectButt,
                                                        javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(EscButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                                .addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(UpData,
                                                                javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE).addComponent(EditButt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                120, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(21, Short.MAX_VALUE)))));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)).addGroup(
                                layout.createSequentialGroup().addGap(26, 26, 26).addComponent(EscButt))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel6).addComponent(jLabel8).addComponent(
                                AccountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(PwdText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(ImgText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(NameText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(SelectButt)).addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addComponent(AddButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jLabel5).addComponent(LevText,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel7)
                                                .addComponent(AgeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(SexText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(DeleteBut))).addGroup(
                                layout.createSequentialGroup().addComponent(EditButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(UpData))).addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18,
                        18, 18).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9).addComponent(AllNum).addComponent(jButton4).addComponent(jumpText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(onButt).addComponent(totalPageLabel)
                                .addComponent(jLabel13).addComponent(currentPage).addComponent(underButt).addComponent(jLabel11).addComponent(pageSizeComBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(42, Short.MAX_VALUE)));
        wick();
        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    private void EscButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 退出按钮
     */
    private void EscButtMouseClicked(java.awt.event.MouseEvent evt) {
        new Management(u).setVisible(true);
        this.dispose();
    }

    /**
     * 初始化数据
     */
    public void wick() {
        //		刷新表格
        UserTable(1, 5, null);
        //		刷新总条数
        initUsersGrid(null);
    }

    /**
     * 跳转按钮
     */
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {

        String str = this.jumpText.getText();
        if (!str.matches("^[1-9][0-9]*$")) {
            JOptionPane.showMessageDialog(null, "跳转页数不合法");
            return;
        }
        int jump = Integer.parseInt(str);
        // 获取pageSize
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());

        // 获取输入框的信息
        User user = getUserInfo();

        int curren = Integer.parseInt(currentPage.getText());
        if (jump > curren) {
            JOptionPane.showMessageDialog(null, "当前页数不存在");
        } else {
            this.totalPageLabel.setText(jump + "");
            // 刷新表格
            UserTable(jump, pageSize, user);
        }
    }

    /**
     * 确认修改
     */
    private void UpDataMouseClicked(java.awt.event.MouseEvent evt) {
        User user = getUserInfo();
        //		获取当前每页展示多少条数据
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
        //		重新获取id
        int row = this.UserTable.getSelectedRow();
        user.setId((String) this.UserTable.getValueAt(row, 0));
        if (user.getLev() == null || user.getLev().trim().length() == 0) {
            user.setLev("1");
        }
        if (user.getImg() == null || user.getImg().trim().length() == 0) {
            user.setImg("1.jpg");
        }
        if (Integer.parseInt(user.getLev()) > 5) {
            JOptionPane.showMessageDialog(null, "该用户等级大于5，您无此权限执行");
        } else {
            //				执行修改方法
            json = userService.modiUser(user);
            //				判断修改结果
            if (json.getSub()) {
                JOptionPane.showMessageDialog(null, "修改成功");
                //					清空数据框
                clearInput();
                //					刷新表格
                UserTable(1, pageSize, null);
                //					加载起始页码
                this.totalPageLabel.setText("1");
                //					刷新总条数
                initUsersGrid(null);
                //					修改失败弹出错误信息
            } else {
                JOptionPane.showMessageDialog(null, "帐号重复，修改失败");
            }
        }

    }

    /**
     * 编辑按钮
     */
    private void EditButtMouseClicked(java.awt.event.MouseEvent evt) {
        // 获取选中行
        int row = this.UserTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选中一行");
            return;
        }
        // 获取选中行中的数据
        //		姓名
        String NameText = (String) this.UserTable.getValueAt(row, 1);
        this.NameText.setText(NameText);
        //		帐号
        String AccountText = (String) this.UserTable.getValueAt(row, 2);
        this.AccountText.setText(AccountText);
        //		密码
        String PwdText = (String) this.UserTable.getValueAt(row, 3);
        this.PwdText.setText(PwdText);
        //		头像
        String ImgText = (String) this.UserTable.getValueAt(row, 4);
        this.ImgText.setText(ImgText);
        //		等级
        String LevText = (String) this.UserTable.getValueAt(row, 5);
        this.LevText.setText(LevText);
        //		年龄
        String AgeText = (String) this.UserTable.getValueAt(row, 7);
        this.AgeText.setText(AgeText);
    }

    private void SelectButtActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /**
     * 查询按钮
     * @param evt
     */
    private void SelectButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取查询的数据
        User user = getUserInfo();
        // 获取当前每页展示多少条
        int pageSize = Integer.parseInt(((String) this.pageSizeComBox.getSelectedItem()));
        //		加载表格
        UserTable(1, pageSize, user);
        //		加载起始页码
        this.totalPageLabel.setText("1");
        //		加载条数
        initUsersGrid(user);
    }

    /**
     * 删除事件
     * @param evt
     */
    private void DeleteButMouseClicked(java.awt.event.MouseEvent evt) {
        User user = new User();
        ResJson json = new ResJson();
        //		获取当前每页展示多少条数据
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
        //		判断是否选中表格数据
        int row = this.UserTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选择一条数据");
            return;
        }
        //		获取要删除列的ID和等级
        user.setId((String) this.UserTable.getValueAt(row, 0));
        user.setLev((String) this.UserTable.getValueAt(row, 5));
        json = userService.deleUser(user);
        if (json.getSub()) {
            //				删除成功
            JOptionPane.showMessageDialog(null, json.getStr());
            //				加载表格
            UserTable(1, pageSize, null);
            //				加载起始页码
            this.totalPageLabel.setText("1");
            //				加载条数
            initUsersGrid(null);
        } else {
            //				删除失败
            JOptionPane.showMessageDialog(null, json.getStr());
        }
    }

    /**
     * 下一页
     * @param evt
     */
    private void underButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取第当前页数数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取第总页数数值
        int totalNum = Integer.parseInt(this.currentPage.getText());
        if (pageNum >= totalNum) {
            JOptionPane.showMessageDialog(null, "当前已经是最后一页 ");
        } else {
            pageNum = pageNum + 1;
            // 			为当前页数赋值
            this.totalPageLabel.setText(pageNum + "");
            // 			获取获取当前页展示条数
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 获取输入框的信息
            User user = getUserInfo();
            //			刷新条数
            initUsersGrid(user);
            // 刷新表格
            UserTable(pageNum, pageSize, user);

        }
    }

    /**
     * 上一页
     * @param evt
     */
    private void onButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取当前页数数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取总页数数值
        int totalNum = Integer.parseInt(this.currentPage.getText());
        if (pageNum <= 1) {
            JOptionPane.showMessageDialog(null, "当前已经是第一页 ");
        } else {
            pageNum = pageNum - 1;
            // 			为当前页数赋值
            this.totalPageLabel.setText(pageNum + "");
            // 			获取获取当前页展示条数
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            User user = getUserInfo();
            //			刷新条数
            initUsersGrid(user);
            //			刷新表格
            UserTable(pageNum, pageSize, user);
        }
    }

    private void SexTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 用户管理添加事件
     * @param evt
     */
    void AddButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		创建ResJson对象
        ResJson json = new ResJson();
        //		获取添加的值
        User user = getUserInfo();

        //		如果等级为空，则赋值默认值 1
        if (user.getLev() == null || user.getLev().trim().length() == 0) {
            user.setLev("1");
        }
        //		获取当前每页展示多少条数据
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());

        //		用户名是否被占用
        json = userService.repeatName(user);
        if (json.getSub()) {
            //			执行添加，获取添加结果
            json = userService.addUser(user);
            //			如果为true则添加成功
            if (json.getSub()) {
                JOptionPane.showMessageDialog(null, "添加成功");
                //				清空文本输入框
                clearInput();
                //				初始化表格
                UserTable(1, pageSize, null);
                //				加载起始页码
                this.totalPageLabel.setText("1");
                //				加载条数
                initUsersGrid(null);
                //			弹出用户名重复的信息
            } else {
                JOptionPane.showMessageDialog(null, json.getStr());
            }
            //			弹出添加错误的信息
        } else {
            JOptionPane.showMessageDialog(null, json.getStr());
        }
    }

    /**
     * 清空文本输入框
     */
    private void clearInput() {
        //		名称
        this.NameText.setText("");
        //		商品价格
        this.AccountText.setText("");
        //		商品库存
        this.PwdText.setText("");
        //		商品销量
        this.ImgText.setText("");
        //		商品销量
        this.LevText.setText("");
        //		年龄
        this.AgeText.setText("");
        //		性别下拉
        this.SexText.setSelectedIndex(0);
    }

    private void AddButMouseClicked(java.awt.event.MouseEvent evt) {

    }

    /**
     * 加载条数
     */
    public void initUsersGrid(User user) {
        //		调用方法，查询符合条件的数据数量
        //		如果goods等于空，则查询全部
        double count = userService.selectUserCouny(user);
        //		获取当前每页展示多少条数据
        double pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
        //		用总条数计算页数
        int totalCount = (int) (Math.ceil(count / pageSize));
        //		总条数赋值
        this.AllNum.setText((int) count + "");
        //		总页数赋值
        this.currentPage.setText(totalCount + "");
    }

    /**
     * 加载表格
     */
    public void UserTable(int pageNum, int pageSize, User user) {
        //		调用查询方法
        ResJson json = userService.selectUserByLimit(pageNum, pageSize, user);
        //		判断查询结果
        if (json.getSub()) {
            //			获取数据，存入集合
            List<User> userList = json.getList();
            //			获取表格对象
            DefaultTableModel tanleModel = (DefaultTableModel) this.UserTable.getModel();
            //			清空表格数据
            tanleModel.setRowCount(0);
            //			遍历数据
            for (User u : userList) {
                Vector rowData = new Vector();
                //				将数据放入表格
                rowData.add(u.getId());
                rowData.add(u.getNikeName());
                rowData.add(u.getLoginName());
                rowData.add(u.getLoginPwd());
                rowData.add(u.getImg());
                rowData.add(u.getLev());
                rowData.add(u.getSex());
                rowData.add(u.getAge());
                rowData.add(u.getCreateTime());
                //				将数据放入表格
                tanleModel.addRow(rowData);
            }
        }
    }

    /**
     * 获取输入框文本
     * @return 返回获取到的值
     */
    public User getUserInfo() {
        User user = new User();
        //		姓名
        String nameText = this.NameText.getText();
        user.setNikeName(nameText);
        //		账号
        String account = this.AccountText.getText();
        user.setLoginName(account);
        //		密码
        String pwd = this.PwdText.getText();
        user.setLoginPwd(pwd);
        //		头像
        String img = this.ImgText.getText();
        user.setImg(img);
        //		等级
        String lev = this.LevText.getText();
        user.setLev(lev);
        //		性别
        String sex = (String) this.SexText.getSelectedItem();
        //		判断性别的值是否合法
        if (!sex.equals("请选择")) {
            user.setSex(sex);
        }
        //		年龄
        String age = this.AgeText.getText();
        user.setAge(age);
        //		返回封装好的数据
        return user;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMangement().setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JTextField AccountText;
    private javax.swing.JButton AddButt;
    private javax.swing.JTextField AgeText;
    private javax.swing.JLabel AllNum;
    private javax.swing.JButton DeleteBut;
    private javax.swing.JButton EditButt;
    private javax.swing.JButton EscButt;
    private javax.swing.JTextField ImgText;
    private javax.swing.JTextField LevText;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField PwdText;
    private javax.swing.JButton SelectButt;
    private javax.swing.JComboBox SexText;
    private javax.swing.JButton UpData;
    private javax.swing.JTable UserTable;
    private javax.swing.JLabel currentPage;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumpText;
    private javax.swing.JButton onButt;
    private javax.swing.JComboBox pageSizeComBox;
    private javax.swing.JLabel totalPageLabel;
    private javax.swing.JButton underButt;
    // End of variables declaration//GEN-END:variables

}