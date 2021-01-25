/*
 * AddressData.java
 *
 * Created on __DATE__, __TIME__
 */

package com.liao.ui.address;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.liao.entity.Address;
import com.liao.entity.Category;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.AddressService;
import com.liao.service.ShoppingCartService;
import com.liao.ui.user.Personalcenter;
import com.liao.util.ResJson;

/**
 * 用户地址
 *
 * @author __USER__
 */
@SuppressWarnings("all")
public class AddressData extends javax.swing.JFrame {
    AddressService addressService = (AddressService) ObjectFactory.getBean("AddressService");
    /**
     * Creates new form AddressData
     */
    private User u;

    public AddressData() {
        initComponents();
    }

    public AddressData(User u) {
        this.u = u;
        initComponents();
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        AddressText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PhoneText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        RemarksText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AddressTable = new javax.swing.JTable();
        SelectButt = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        AllNum = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pageSizeComBox = new javax.swing.JComboBox();
        onButt = new javax.swing.JButton();
        totalPageLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        currentPage = new javax.swing.JLabel();
        under = new javax.swing.JButton();
        jumpText = new javax.swing.JTextField();
        jumpButt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel1.setText("\u59d3\u540d");

        NameText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        NameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel2.setText("\u5730\u5740");

        AddressText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel3.setText("\u7535\u8bdd");

        PhoneText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        PhoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//				PhoneTextActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel4.setText("\u5907\u6ce8");

        RemarksText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        AddressTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{"编号", "姓名", "地址", "电话", "备注"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(AddressTable);

        SelectButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SelectButt.setText("\u67e5\u8be2");
        SelectButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectButtMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel5.setText("\u603b\u6761\u6570");

        AllNum.setText("1");

        jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel7.setText("\u6bcf\u9875\u5c55\u793a");

        pageSizeComBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"5", "10", "20"}));

        onButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        onButt.setText("\u4e0a\u4e00\u9875");
        onButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onButtMouseClicked(evt);
            }
        });

        totalPageLabel.setText("1");

        jLabel9.setText("/");

        currentPage.setText("0");

        under.setFont(new java.awt.Font("微软雅黑", 0, 15));
        under.setText("\u4e0b\u4e00\u9875");
        under.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                underMouseClicked(evt);
            }
        });
        under.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underActionPerformed(evt);
            }
        });

        jumpText.setText("0");
        jumpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpTextActionPerformed(evt);
            }
        });

        jumpButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jumpButt.setText("\u8df3\u8f6c");
        jumpButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jumpButtMouseClicked(evt);
            }
        });
        jumpButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpButtActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton1.setText("\u8fd4\u56de");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
        jLabel6.setText("\u7528\u6236\u5730\u5740");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGap(91, 91, 91).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(AllNum).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                                        pageSizeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(62, 62, 62)
                                        .addComponent(onButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(totalPageLabel).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(currentPage).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(under).addGap(58, 58, 58).addComponent(jumpButt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jumpText, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                                .addGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1).addComponent(jLabel3))
                                                .addGap(4, 4, 4).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(NameText, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(PhoneText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142,
                                                Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel4).addComponent(jLabel2))
                                                .addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                                layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(RemarksText,
                                                                                javax.swing.GroupLayout.Alignment.LEADING).addComponent(AddressText, javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(
                                                                layout.createSequentialGroup().addGap(80, 80, 80).addComponent(SelectButt).addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1)))).addComponent(jScrollPane1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(177, 177, 177)).addGroup(
                layout.createSequentialGroup().addGap(361, 361, 361).addComponent(jLabel6).addContainerGap(443, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addContainerGap().addComponent(jLabel6).addGap(41, 41, 41).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel1).addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(PhoneText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)).addComponent(jLabel4).addGroup(
                                layout.createSequentialGroup().addComponent(RemarksText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(SelectButt))).addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel5).addComponent(AllNum).addComponent(jLabel7).addComponent(pageSizeComBox,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(onButt).addComponent(
                                totalPageLabel).addComponent(jLabel9).addComponent(currentPage).addComponent(under).addComponent(jumpButt).addComponent(jumpText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(111, Short.MAX_VALUE)));
        wick();
        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    private void wick() {
        //		初始化表格
        AddressTable(1, 5, null);
        //				加载条数
        initUsersGrid(null);
    }

    /**
     * 返回
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        new Personalcenter(u).setVisible(true);
        this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jumpButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 查询按钮
     *
     * @param evt
     */
    private void SelectButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取查询的数据
        Address address = getAddressInfo();
        // 		获取当前每页展示多少条
        int pageSize = Integer.parseInt(((String) this.pageSizeComBox.getSelectedItem()));
        //		初始化表格
        AddressTable(1, pageSize, address);
        //		为当前页数赋值
        this.totalPageLabel.setText("1");
        //		加载条数
        initUsersGrid(address);
    }

    /**
     * 跳转按钮
     */
    private void jumpButtMouseClicked(java.awt.event.MouseEvent evt) {
        String str = this.jumpText.getText();
        if (!str.matches("^[1-9][0-9]*$")) {
            JOptionPane.showMessageDialog(null, " 跳转页数不合法");
            return;
        }
        int jump = Integer.parseInt(str);
        // 		获取pageSize
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());

        // 		获取输入框的信息
        Address address = getAddressInfo();

        int curren = Integer.parseInt(currentPage.getText());
        if (jump > curren) {
            JOptionPane.showMessageDialog(null, "当前页数不存在");
        } else {
            this.totalPageLabel.setText(jump + "");
            // 			刷新表格
            AddressTable(jump, pageSize, address);

            //			刷新条数
            initUsersGrid(address);
        }

    }

    private void jumpTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void underActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 下一页
     */
    private void underMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取第一个数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取第二个数值
        int totalNum = Integer.parseInt(this.currentPage.getText());

        if (pageNum >= totalNum) {

            JOptionPane.showMessageDialog(null, "当前已经是最后一页 ");

        } else {
            pageNum = pageNum + 1;
            //	 		设置当前页数
            this.totalPageLabel.setText(pageNum + "");
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            Address address = getAddressInfo();
            //			刷新表格
            AddressTable(pageNum, pageSize, address);
            //			刷新条数
            initUsersGrid(address);

        }
    }

    /**
     * 上一页
     */
    private void onButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取第一个数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取第二个数值
        int totalNum = Integer.parseInt(this.currentPage.getText());
        if (pageNum <= 1) {
            JOptionPane.showMessageDialog(null, "当前已经是第一页 ");
        } else {
            pageNum = pageNum - 1;
            // 			设置当前页数
            this.totalPageLabel.setText(pageNum + "");
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            Address address = getAddressInfo();
            //			刷新表格
            AddressTable(pageNum, pageSize, address);
            //			刷新条数
            initUsersGrid(address);
        }
    }

    private void NameTextActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    void AddButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    void PhoneActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 清空输入框
     */
    private void clearInput() {
        //		名称
        this.NameText.setText("");
        //		电话
        this.PhoneText.setText("");
        //		备注
        this.RemarksText.setText("");
        //		地址
        this.AddressText.setText("");
    }

    /**
     * 加载条数
     */
    public void initUsersGrid(Address address) {
        //		调用方法，查询符合条件的数据数量
        //		如果goods等于空，则查询全部
        double count = addressService.selectAddressouny(address, u);
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
     * 初始化表格
     */
    public void AddressTable(int pageNum, int pageSize, Address address) {
        ResJson jesc = new ResJson();
        //		调用查询方法
        jesc = addressService.selectAddressByLimit(pageNum, pageSize, address, u);
        //		判断是否有数据
        if (jesc.getSub()) {
            //			获取数据
            List<Address> addressestList = jesc.getList();
            //			获取表格对象
            DefaultTableModel tableModel = (DefaultTableModel) this.AddressTable.getModel();
            tableModel.setRowCount(0);
            //			遍历数据存入表格
            for (Address addre : addressestList) {
                Vector rowData = new Vector();
                //				所属用户ID
                rowData.add(addre.getId());
                //				用户名称
                rowData.add(addre.getName());
                //				地址
                rowData.add(addre.getUseraddress());
                //				电话
                rowData.add(addre.getPhone());
                //				备注
                rowData.add(addre.getRemarks());
                tableModel.addRow(rowData);
            }
        }

    }

    /**
     * 获取输入框文本
     *
     * @return
     */
    public Address getAddressInfo() {
        Address address = new Address();
        //		获取ID
        address.setUserid(u.getId());
        //		姓名
        String NameText = this.NameText.getText();
        address.setName(NameText);
        //		地址
        String AddressText = this.AddressText.getText();
        address.setUseraddress(AddressText);
        //		电话
        String PhoneText = this.PhoneText.getText();
        address.setPhone(PhoneText);
        //		备注
        String RemarksText = this.RemarksText.getText();
        address.setRemarks(RemarksText);

        return address;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddressData().setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JTable AddressTable;
    private javax.swing.JTextField AddressText;
    private javax.swing.JLabel AllNum;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField PhoneText;
    private javax.swing.JTextField RemarksText;
    private javax.swing.JButton SelectButt;
    private javax.swing.JLabel currentPage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jumpButt;
    private javax.swing.JTextField jumpText;
    private javax.swing.JButton onButt;
    private javax.swing.JComboBox pageSizeComBox;
    private javax.swing.JLabel totalPageLabel;
    private javax.swing.JButton under;
    // End of variables declaration//GEN-END:variables

}