/*
 * CategoryData.java
 *
 * Created on __DATE__, __TIME__
 */

package com.liao.ui.category;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.liao.entity.Category;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.ui.Management;
import com.liao.util.ResJson;

/**
 * @author __USER__
 */
@SuppressWarnings("all")
public class CategoryData extends javax.swing.JFrame {
    static CategoryService categoryService = (CategoryService) ObjectFactory.getBean("CategoryService");
    private User u;

    /**
     * Creates new form CategoryData
     */
    public CategoryData() {
        initComponents();
    }

    public CategoryData(User u) {
        this.u = u;
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        SelectButt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AllNum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pageSizeComBox = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        totalPageLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        currentPage = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        JumpButt = new javax.swing.JButton();
        JumpText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CategroyTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        AddDataButt = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        EscButt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel1.setText("\u7c7b\u522bID");

        IDText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        IDText.setText("0");
        IDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel2.setText("\u540d\u79f0");

        NameText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        NameText.setText("0");

        SelectButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SelectButt.setText("\u67e5\u8be2");
        SelectButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectButtMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel3.setText("\u603b\u6761\u6570");

        AllNum.setFont(new java.awt.Font("微软雅黑", 0, 15));
        AllNum.setText("0");

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel5.setText("\u6bcf\u9875\u5c55\u793a");

        pageSizeComBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"5", "10", "20"}));

        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton2.setText("\u4e0a\u4e00\u9875");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        totalPageLabel.setFont(new java.awt.Font("微软雅黑", 0, 15));
        totalPageLabel.setText("1");

        jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel7.setText("/");

        currentPage.setFont(new java.awt.Font("微软雅黑", 0, 15));
        currentPage.setText("0");

        jButton3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton3.setText("\u4e0b\u4e00\u9875");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        JumpButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        JumpButt.setText("\u8df3\u8f6c");
        JumpButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JumpButtMouseClicked(evt);
            }
        });
        JumpButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumpButtActionPerformed(evt);
            }
        });

        JumpText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        JumpText.setText("0 ");

        CategroyTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{"ID", "名称", "时间"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(CategroyTable);

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton1.setText("\u7f16\u8f91");
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

        jButton4.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton4.setText("\u4fee\u6539");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        AddDataButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        AddDataButt.setText("\u6dfb\u52a0");
        AddDataButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddDataButtMouseClicked(evt);
            }
        });

        Delete.setFont(new java.awt.Font("微软雅黑", 0, 15));
        Delete.setText("\u5220\u9664");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });

        EscButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        EscButt.setText("\u8fd4\u56de");
        EscButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EscButtMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jLabel4.setText("\u5546\u54c1\u7c7b\u522b");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGap(55, 55, 55).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(IDText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147,
                                        Short.MAX_VALUE).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(NameText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SelectButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AddDataButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(Delete).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(EscButt).addContainerGap()).addGroup(
                                layout.createSequentialGroup().addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(AllNum).addGap(36, 36, 36)
                                        .addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pageSizeComBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(81, 81, 81).addComponent(jButton2).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(totalPageLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(currentPage).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206,
                                        Short.MAX_VALUE).addComponent(JumpButt).addGap(42, 42, 42).addComponent(JumpText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE).addContainerGap()))).addGroup(
                layout.createSequentialGroup().addGap(417, 417, 417).addComponent(jLabel4).addContainerGap(418, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addGap(33, 33, 33).addComponent(jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(IDText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2).addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(SelectButt).addComponent(jButton1).addComponent(jButton4).addComponent(
                                AddDataButt).addComponent(Delete).addComponent(EscButt)).addGap(18, 18, 18).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305,
                        javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(AllNum).addComponent(pageSizeComBox,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel5)).addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(JumpText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jButton2).addComponent(totalPageLabel).addComponent(jLabel7)
                                        .addComponent(currentPage).addComponent(jButton3).addComponent(JumpButt))).addGap(38, 38, 38)));
        wick();
        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    /**
     * 返回按钮
     */
    private void EscButtMouseClicked(java.awt.event.MouseEvent evt) {
        new Management(u).setVisible(true);
        this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 初始化数据
     */
    public void wick() {
        //		刷新表格
        initGoodsTableModel(1, 5, null);
        //		刷新总条数
        initGoodsGrid(null);
    }

    private void JumpButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 确认修改
     *
     * @param evt
     */
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
        Category category = getGoodsInfo();
        ResJson json = new ResJson();
        System.out.println(category);
        json = categoryService.modiCategory(category);
        if (json.getSub()) {
            JOptionPane.showMessageDialog(null, json.getStr());
            //			清空输入框
            clearInput();
            //			刷新表格
            initGoodsTableModel(1, 10, null);
            //				加载起始页码
            this.totalPageLabel.setText("1");
            //			刷新总条数
            initGoodsGrid(null);
        } else {
            JOptionPane.showMessageDialog(null, json.getStr());
        }
    }

    /**
     * 编辑
     *
     * @param evt
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        // 获取表格 选中项数据

        // 获取选中行
        int row = this.CategroyTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选中一行");
            return;
        }
        // 获取选中行中的数据
        // 名称
        String NameText = (String) this.CategroyTable.getValueAt(row, 1);
        this.NameText.setText(NameText);
        //		年龄
        String ID = (String) this.CategroyTable.getValueAt(row, 0);
        this.IDText.setText(ID);
    }

    /**
     * 添加
     *
     * @param evt
     */
    private void AddDataButtMouseClicked(java.awt.event.MouseEvent evt) {
        ResJson json = new ResJson();
        Category category = getGoodsInfo();
        json = categoryService.repeatName(category);
        if (json.getSub()) {
            json = categoryService.addCategory(category);
            if (json.getSub()) {
                JOptionPane.showMessageDialog(null, json.getStr());
                //			清空输入框
                clearInput();

                //			刷新表格
                initGoodsTableModel(1, 5, null);
                //				加载起始页码
                this.totalPageLabel.setText("1");
                //			刷新总条数
                initGoodsGrid(null);
            } else {
                JOptionPane.showMessageDialog(null, json.getStr());
            }
        } else {
            JOptionPane.showMessageDialog(null, json.getStr());
        }

    }

    private void clearInput() {
        //		名称
        this.NameText.setText("");
        //		商品价格
        this.IDText.setText("");
    }

    /**
     * 删除
     *
     * @param evt
     */
    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {
        Category category = new Category();
        int row = this.CategroyTable.getSelectedRow();

        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选中一行");
            return;
        }
        //		获取选中行的ID;
        category.setId((String) this.CategroyTable.getValueAt(row, 0));
        ResJson json = categoryService.deleCategory(category);
        if (json.getSub()) {
            JOptionPane.showMessageDialog(null, "删除成功");
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            //			刷新表格
            initGoodsTableModel(1, pageSize, null);
            //			加载起始页码
            this.totalPageLabel.setText("1");
            //			刷新总条数
            initGoodsGrid(null);
        } else {
            JOptionPane.showMessageDialog(null, "该类别有数据残留，无法删除");
        }
    }

    /**
     * 跳转按钮
     *
     * @param evt
     */
    private void JumpButtMouseClicked(java.awt.event.MouseEvent evt) {
        String str = this.JumpText.getText();
        if (!str.matches("^[1-9][0-9]*$")) {
            JOptionPane.showMessageDialog(null, "跳转页数不合法");
            return;
        }
        int jump = Integer.parseInt(str);
        // 获取pageSize
        int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());

        // 获取输入框的信息
        Category category = getGoodsInfo();

        int curren = Integer.parseInt(currentPage.getText());
        if (jump > curren) {
            JOptionPane.showMessageDialog(null, "当前页数不存在");
        } else {
            this.totalPageLabel.setText(jump + "");
            // 刷新表格
            initGoodsTableModel(jump, pageSize, category);
        }
    }

    /**
     * 下一頁
     *
     * @param evt
     */
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        //		第一个
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		第二个
        int totalNum = Integer.parseInt(this.currentPage.getText());
        if (pageNum >= totalNum) {
            JOptionPane.showMessageDialog(null, "当前已经是最后一页 ");
        } else {
            pageNum = pageNum + 1;
            // 设置当前页数
            this.totalPageLabel.setText(pageNum + "");
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            Category category = getGoodsInfo();
            //			刷新条数
            initGoodsGrid(category);
            // 			刷新表格
            initGoodsTableModel(pageNum, pageSize, category);

        }
    }

    /**
     * 上一頁
     *
     * @param evt
     */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        //		第一个
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		第二个
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
            Category category = getGoodsInfo();
            //			刷新条数
            initGoodsGrid(category);
            // 			刷新表格
            initGoodsTableModel(pageNum, pageSize, category);
        }
    }

    private void IDTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public Category getGoodsInfo() {

        //		获取查询的数据
        Category category = new Category();
        //		類別名称
        String NameText = this.NameText.getText();
        category.setCategory(NameText);
        //		ID
        String IDText = this.IDText.getText();
        category.setId(IDText);
        return category;

    }

    /**
     * 查詢按鈕單擊
     *
     * @param evt
     */
    private void SelectButtMouseClicked(java.awt.event.MouseEvent evt) {
        Category category = getGoodsInfo();
        // 获取当前 pageSize
        int pageSize = Integer.parseInt(((String) this.pageSizeComBox.getSelectedItem()));
        initGoodsTableModel(1, pageSize, category);
        initGoodsGrid(category);
    }

    //	加载条数
    public void initGoodsGrid(Category category) {
        double count = categoryService.selectCategoryCouny(category);
        //		获取当前PageSize
        double pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
        //		计算页数
        int totalCount = (int) (Math.ceil(count / pageSize));
        //		总页数
        this.AllNum.setText((int) count + "");
        this.currentPage.setText(totalCount + "");

    }

    /**
     * 渲染 数据表格
     */
    private void initGoodsTableModel(int pageNum, int pageSize, Category category) {
        // 每次加载之前 清空 表格数据

        // 查询数据

        ResJson json = categoryService.selectCategoryByLimit(pageNum, pageSize, category);

        // 在操作成功的前提下 渲染表格数据
        if (json.getSub()) {

            // 将数据添加进 表格
            // 取数据
            List<Category> categoryList = json.getList();

            // 获取表格对象模型
            DefaultTableModel tableModel = (DefaultTableModel) this.CategroyTable.getModel();

            // 清空表格中的数据
            tableModel.setRowCount(0);

            // 将 集合中 的 数据 添加进表格
            for (Category g : categoryList) {

                // 创建Vector 将 组装数据 保存行数据
                Vector rowData = new Vector();
                // 添加列数据
                rowData.add(g.getId());
                rowData.add(g.getCategory());
                rowData.add(g.getCreateTime());

                // 将 每一个 数据 添加进 表格
                tableModel.addRow(rowData);

            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryData().setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JButton AddDataButt;
    private javax.swing.JLabel AllNum;
    private javax.swing.JTable CategroyTable;
    private javax.swing.JButton Delete;
    private javax.swing.JButton EscButt;
    private javax.swing.JTextField IDText;
    private javax.swing.JButton JumpButt;
    private javax.swing.JTextField JumpText;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton SelectButt;
    private javax.swing.JLabel currentPage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pageSizeComBox;
    private javax.swing.JLabel totalPageLabel;
    // End of variables declaration//GEN-END:variables

}