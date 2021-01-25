/*
 * ShoppingCart.java
 *
 * Created on __DATE__, __TIME__
 */

package com.liao.ui.shoppingcart;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.liao.entity.Address;
import com.liao.entity.ShoppingCart;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.ShoppingCartService;
import com.liao.ui.user.Personalcenter;
import com.liao.util.JDBCUtil;
import com.liao.util.ResJson;

/**
 * @author __USER__
 */
@SuppressWarnings("all")
public class ShoppingCartData extends javax.swing.JFrame {
    ShoppingCartService shoppingCartService = (ShoppingCartService) ObjectFactory.getBean("ShoppingCartService");
    private User u;

    /**
     * Creates new form ShoppingCart
     */
    public ShoppingCartData() {
        initComponents();
    }

    public ShoppingCartData(User user) {
        this.u = user;
        initComponents();
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShoppingCartTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AllNum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pageSizeComBox = new javax.swing.JComboBox();
        onButt = new javax.swing.JButton();
        underButt = new javax.swing.JButton();
        totalPageLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        currentPage = new javax.swing.JLabel();
        JumpButt = new javax.swing.JButton();
        jumpText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        goodsText = new javax.swing.JTextField();
        ImgText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        PriceText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        EscButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 15));

        ShoppingCartTable.setFont(new java.awt.Font("微软雅黑", 0, 15));
        ShoppingCartTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{"名称", "图片", "数量", "价格", "总价", "时间"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jScrollPane1.setViewportView(ShoppingCartTable);

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jLabel2.setText("\u8d2d\u7269\u8f66");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel3.setText("\u603b\u6761\u6570");

        AllNum.setFont(new java.awt.Font("微软雅黑", 0, 15));
        AllNum.setText("0");

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel5.setText("\u6bcf\u9875\u5c55\u793a");

        pageSizeComBox.setFont(new java.awt.Font("微软雅黑", 0, 15));
        pageSizeComBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"5", "10", "15", "25"}));

        onButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        onButt.setText("\u4e0a\u4e00\u9875");
        onButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onButtMouseClicked(evt);
            }
        });

        underButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        underButt.setText("\u4e0b\u4e00\u9875");
        underButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                underButtMouseClicked(evt);
            }
        });

        totalPageLabel.setFont(new java.awt.Font("微软雅黑", 0, 15));
        totalPageLabel.setText("1");

        jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel7.setText("/");

        currentPage.setFont(new java.awt.Font("微软雅黑", 0, 15));
        currentPage.setText("0");

        JumpButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        JumpButt.setText("\u8df3\u8f6c");
        JumpButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JumpButtMouseClicked(evt);
            }
        });

        jumpText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jumpText.setText("0");

        jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel9.setText("\u540d\u79f0");

        jLabel10.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel10.setText("\u56fe\u7247");

        jLabel11.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel11.setText("\u4ef7\u683c");

        jLabel12.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel12.setText("\u6570\u91cf");

        goodsText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        ImgText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        quantityText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        PriceText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton1.setText("\u67e5\u8be2");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
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
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(712, Short.MAX_VALUE).addComponent(jButton1)).addGroup(
                layout.createSequentialGroup().addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                layout.createSequentialGroup().addGap(49, 49, 49).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(
                                                layout.createSequentialGroup().addComponent(jLabel10).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(ImgText))
                                                .addGroup(
                                                        layout.createSequentialGroup().addComponent(jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                                                                goodsText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel12).addComponent(jLabel11)).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(PriceText).addComponent(quantityText,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))
                                .addGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        layout.createSequentialGroup().addGap(76, 76, 76).addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618,
                                                Short.MAX_VALUE)).addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                layout.createSequentialGroup().addGap(280, 280, 280).addComponent(onButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                                        totalPageLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel7).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(currentPage).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(underButt).addGap(63, 63, 63).addComponent(JumpButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                                        jumpText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                layout.createSequentialGroup().addContainerGap().addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(AllNum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel5).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pageSizeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                layout.createSequentialGroup().addGap(362, 362, 362).addComponent(jLabel2)).addGroup(
                                javax.swing.GroupLayout.Alignment.LEADING,
                                layout.createSequentialGroup().addGap(32, 32, 32).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(EscButt)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addContainerGap().addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1).addComponent(jLabel2)).addGap(19, 19, 19).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel9).addComponent(goodsText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel10).addComponent(ImgText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(19, 19, 19)).addGroup(
                                layout.createSequentialGroup().addComponent(jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                layout.createSequentialGroup().addGap(5, 5, 5).addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel11)).addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel12)).addGap(3, 3, 3)).addGroup(
                                                layout.createSequentialGroup().addComponent(EscButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))).addGap(329, 329, 329)
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(AllNum).addComponent(jLabel5).addComponent(pageSizeComBox,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jumpText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(JumpButt).addComponent(
                                        totalPageLabel).addComponent(jLabel7).addComponent(currentPage).addComponent(onButt).addComponent(underButt)).addGap(34, 34, 34)).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap(123, Short.MAX_VALUE).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)));
        wick();
        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    public void wick() {
        //		初始化表格
        initializationForm(1, 5, null);
        //		加载条数
        initShoppinGrid(null);
    }

    /**
     * 返回按钮
     */
    private void EscButtMouseClicked(java.awt.event.MouseEvent evt) {
        new Personalcenter(u).setVisible(true);
        this.dispose();
    }

    private void EscButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 查询
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        //		获取查询的数据
        ShoppingCart shoppingCart = getShoppingInfo();
        // 		获取当前每页展示多少条
        int pageSize = Integer.parseInt(((String) this.pageSizeComBox.getSelectedItem()));
        //		初始化表格
        initializationForm(1, 5, shoppingCart);
        //		加载条数
        initShoppinGrid(shoppingCart);
    }

    //GEN-END:

    /**
     * 跳转按钮
     */
    private void JumpButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取跳转的页码
        String str = this.jumpText.getText();
        //		判断页码是否合法
        if (!str.matches("^[1-9][0-9]*$")) {
            //			不合法弹出错误信息
            JOptionPane.showMessageDialog(null, "跳转页数不合法");
            return;
        }
        //		将合法的值强转为int
        int jump = Integer.parseInt(str);
        // 		获取当前每页展示条数
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
        // 		获取输入框的信息
        ShoppingCart shoppingCart = getShoppingInfo();
        //		获取总页数
        int curren = Integer.parseInt(currentPage.getText());
        //		判断跳转的页数是否大于总页数
        if (jump > curren) {
            //			大于，弹出错误信息
            JOptionPane.showMessageDialog(null, "当前页数不存在");
        } else {
            //			否则跳转
            this.totalPageLabel.setText(jump + "");
            // 			刷新表格
            initializationForm(jump, pageSize, shoppingCart);
        }
    }

    /**
     * 下一页
     */
    private void underButtMouseClicked(java.awt.event.MouseEvent evt) {
//		获取当前页数数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取总页数数值
        int totalNum = Integer.parseInt(this.currentPage.getText());
        //		判断当前页数是否大于等于总页数
        if (pageNum >= totalNum) {
            //			弹出错误信息
            JOptionPane.showMessageDialog(null, "当前已经是最后一页 ");
        } else {
            //			否则当前页数加一
            pageNum = pageNum + 1;
            // 			赋值给当前页数
            this.totalPageLabel.setText(pageNum + "");
            // 			获取获取当前页展示条数
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            ShoppingCart shoppingCart = getShoppingInfo();
            //			刷新表格
            initializationForm(pageNum, pageSize, shoppingCart);
            //			刷新条数
            initShoppinGrid(shoppingCart);
        }
    }

    /**
     * 上一页
     */
    private void onButtMouseClicked(java.awt.event.MouseEvent evt) {
//		获取当前页数数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取总页数数值
        int totalNum = Integer.parseInt(this.currentPage.getText());
        //		判断当前页数是否小于等于1
        if (pageNum <= 1) {
            //			弹出错误信息
            JOptionPane.showMessageDialog(null, "当前已经是第一页 ");
            //			否则当前页数节减一
        } else {
            pageNum = pageNum - 1;
            // 			赋值给当前页数
            this.totalPageLabel.setText(pageNum + "");
            // 			获取获取当前页展示条数
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            ShoppingCart shoppingCart = getShoppingInfo();
            //			刷新表格
            initializationForm(pageNum, pageSize, shoppingCart);
            //			刷新条数
            initShoppinGrid(shoppingCart);
        }
    }

    /**
     * 清空输入框
     */
    private void clearInput() {
        //		名称
        this.goodsText.setText("");
        //		电话
        this.PriceText.setText("");
        //		备注
        this.ImgText.setText("");
        //		地址
        this.quantityText.setText("");
    }

    /**
     * 加载条数
     */
    public void initShoppinGrid(ShoppingCart shoppingCart) {
        //		调用方法，查询符合条件的数据数量
        double count = shoppingCartService.selectShoppingCartCouny(shoppingCart, u);
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
    public void initializationForm(int pageNum, int pageSize, ShoppingCart shoppingCart) {
        //		存储结果
        ResJson jesc = new ResJson();
        //		调用查询方法
        jesc = shoppingCartService.selectShoppingCartByLimit(pageNum, pageSize, shoppingCart, u);
        //		判断结果
        if (jesc.getSub()) {
            //			有结果，获取集合
            //			获取数据
            List<ShoppingCart> shoppingCartList = jesc.getList();
            //			获取表格对象
            DefaultTableModel tableModel = (DefaultTableModel) this.ShoppingCartTable.getModel();
            tableModel.setRowCount(0);
            //			遍历数据存入表格
            for (ShoppingCart shopping : shoppingCartList) {
                Vector rowData = new Vector();
                //				商品名称
                rowData.add(shopping.getGoodsName());
                //				商品图片
                rowData.add(shopping.getImg());
                //				数量
                rowData.add(shopping.getQuantity());
                //				价格
                rowData.add(shopping.getPrice());
                //				计算总价
                double sum = Double.parseDouble(shopping.getQuantity()) * Double.parseDouble(shopping.getPrice());
                rowData.add(sum + "");
                //				时间
                rowData.add(shopping.getTimes());
                //				存入表格
                tableModel.addRow(rowData);
            }
        }

    }

    /**
     * 获取输入框文本
     *
     * @return 返回文本框的数据
     */
    public ShoppingCart getShoppingInfo() {
        ShoppingCart shoppingCart = new ShoppingCart();
        //		获取ID
        shoppingCart.setUserId(u.getId());
        //		名称
        String goodsText = this.goodsText.getText();
        shoppingCart.setGoodsName(goodsText);
        //		图片
        String ImgText = this.ImgText.getText();
        shoppingCart.setImg(ImgText);
        //		价格
        String PriceText = this.PriceText.getText();
        shoppingCart.setPrice(PriceText);
        //		数量
        String quantityText = this.quantityText.getText();
        shoppingCart.setQuantity(quantityText);
        //		返回获取到的值
        return shoppingCart;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCartData().setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JLabel AllNum;
    private javax.swing.JButton EscButt;
    private javax.swing.JTextField ImgText;
    private javax.swing.JButton JumpButt;
    private javax.swing.JTextField PriceText;
    private javax.swing.JTable ShoppingCartTable;
    private javax.swing.JLabel currentPage;
    private javax.swing.JTextField goodsText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumpText;
    private javax.swing.JButton onButt;
    private javax.swing.JComboBox pageSizeComBox;
    private javax.swing.JTextField quantityText;
    private javax.swing.JLabel totalPageLabel;
    private javax.swing.JButton underButt;
    // End of variables declaration//GEN-END:variables

}