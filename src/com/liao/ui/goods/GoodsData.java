/*
 * GoodsData.java
 *
 * Created on __DATE__, __TIME__
 */

package com.liao.ui.goods;

import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.OBJ_ADAPTER;

import com.liao.entity.Category;
import com.liao.entity.Goods;
import com.liao.entity.User;
import com.liao.factory.ObjectFactory;
import com.liao.service.CategoryService;
import com.liao.service.GoodsService;
import com.liao.ui.Management;
import com.liao.util.ResJson;

/**
 * 商品管理类
 *
 * @author __USER__
 */
@SuppressWarnings("all")
public class GoodsData extends javax.swing.JFrame {
    static GoodsService goodsService = (GoodsService) ObjectFactory.getBean("GoodsService");
    static CategoryService categoryService = (CategoryService) ObjectFactory.getBean("CategoryService");
    private User u;

    /**
     * Creates new form GoodsData
     */
    public GoodsData() {
        initComponents();
    }

    public GoodsData(User u) {
        this.u = u;
        initComponents();
    }

    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        GoodsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AllNum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pageSizeComBox = new javax.swing.JComboBox();
        totalPageLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentPage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProductNameText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PriceText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        InStockText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SalesVolumeText = new javax.swing.JTextField();
        CategoryText = new javax.swing.JComboBox();
        SelectGoodsButt = new javax.swing.JButton();
        JumpButt = new javax.swing.JButton();
        JumpText = new javax.swing.JTextField();
        UpData = new javax.swing.JButton();
        DeleteButt = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        StoreText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        FactoryText = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ShelflifeText = new javax.swing.JTextField();
        SituationText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        DiscountText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ImgText = new javax.swing.JTextField();
        PostText = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        ImportButt = new javax.swing.JButton();
        ExportButt = new javax.swing.JButton();
        EscButt = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GoodsTable.setFont(new java.awt.Font("微软雅黑", 0, 15));
        GoodsTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{"ID", "名称", "类别", "价格", "销量", "库存", "店家", "厂家", "保质期", "图片", "折扣", "状态", "邮递"}) {
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(GoodsTable);

        jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel1.setText("\u603b\u6761\u6570");

        AllNum.setFont(new java.awt.Font("微软雅黑", 0, 15));
        AllNum.setText("1");

        jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel3.setText("\u6bcf\u9875\u5c55\u793a");

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton1.setText("\u4e0a\u4e00\u9875");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton2.setText("\u4e0b\u4e00\u9875");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        pageSizeComBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"10", "20", "30"}));
        pageSizeComBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageSizeComBoxActionPerformed(evt);
            }
        });

        totalPageLabel.setFont(new java.awt.Font("微软雅黑", 0, 15));
        totalPageLabel.setText("1");

        jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel5.setText("/");

        currentPage.setFont(new java.awt.Font("微软雅黑", 0, 15));
        currentPage.setText("1");

        jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel2.setText("\u540d\u79f0");

        ProductNameText.setFont(new java.awt.Font("微软雅黑", 0, 15));

        jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel6.setText("\u4ef7\u683c");

        PriceText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        PriceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceTextActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel7.setText("\u5e93\u5b58");

        InStockText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        InStockText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InStockTextActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel8.setText("\u7c7b\u522b");

        jLabel9.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel9.setText("\u9500\u91cf");

        SalesVolumeText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SalesVolumeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesVolumeTextActionPerformed(evt);
            }
        });

        CategoryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryTextActionPerformed(evt);
            }
        });

        SelectGoodsButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SelectGoodsButt.setText("\u67e5\u8be2");
        SelectGoodsButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectGoodsButtMouseClicked(evt);
            }
        });
        SelectGoodsButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//				actionPerformed(evt);
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
        JumpText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumpTextActionPerformed(evt);
            }
        });

        UpData.setFont(new java.awt.Font("微软雅黑", 0, 15));
        UpData.setText("\u7f16\u8f91");
        UpData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpDataMouseClicked(evt);
            }
        });
        UpData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpDataActionPerformed(evt);
            }
        });

        DeleteButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        DeleteButt.setText("\u5220\u9664");
        DeleteButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtMouseClicked(evt);
            }
        });
        DeleteButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtActionPerformed(evt);
            }
        });

        AddButton.setFont(new java.awt.Font("微软雅黑", 0, 15));
        AddButton.setText("\u6dfb\u52a0");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
        });
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel4.setText("\u5e97\u5bb6");

        StoreText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        StoreText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoreTextActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel10.setText("\u5382\u5bb6");

        FactoryText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        FactoryText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FactoryTextActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel12.setText("\u4fdd\u8d28\u671f");

        jLabel13.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel13.setText("\u72b6\u6001");

        ShelflifeText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        ShelflifeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShelflifeTextActionPerformed(evt);
            }
        });

        SituationText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        SituationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel15.setText("\u6298\u6263");

        DiscountText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        DiscountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiscountTextActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel16.setText("\u56fe\u7247");

        jLabel17.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jLabel17.setText("\u90ae\u9012");

        ImgText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        ImgText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImgTextActionPerformed(evt);
            }
        });

        PostText.setFont(new java.awt.Font("微软雅黑", 0, 15));
        PostText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostTextActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("微软雅黑", 0, 15));
        jButton3.setText("\u786e\u8ba4\u4fee\u6539");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        ImportButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        ImportButt.setText("\u4e0a\u4f20");
        ImportButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportButtMouseClicked(evt);
            }
        });
        ImportButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButtActionPerformed(evt);
            }
        });

        ExportButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        ExportButt.setText("\u4e0b\u8f7d");
        ExportButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExportButtMouseClicked(evt);
            }
        });
        ExportButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtActionPerformed(evt);
            }
        });

        EscButt.setFont(new java.awt.Font("微软雅黑", 0, 15));
        EscButt.setText("\u8fd4\u56de");
        EscButt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EscButtMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("微软雅黑", 0, 18));
        jLabel11.setText("\u5546\u54c1\u7ba1\u7406");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addContainerGap().addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(
                                        layout.createSequentialGroup().addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(
                                                        layout.createSequentialGroup().addComponent(jLabel7).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                                                                InStockText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel9).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(SalesVolumeText)).addGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                                                                ProductNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel6).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel8).addComponent(jLabel10)).addGap(7, 7, 7).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(FactoryText).addComponent(CategoryText, 0, 81,
                                                        Short.MAX_VALUE)).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(
                                                        layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel12).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(ShelflifeText, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                                                        layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(StoreText)))
                                                .addGroup(
                                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                                layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel17)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(PostText,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                                                                layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jLabel15).addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(DiscountText))).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                        layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel16)).addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(4, 4, 4).addComponent(jLabel13))).addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(ImgText, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(SituationText, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))).addGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addComponent(jLabel1).addGap(42, 42, 42).addComponent(AllNum)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3).addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pageSizeComBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
                                                javax.swing.GroupLayout.PREFERRED_SIZE).addGap(53, 53, 53).addComponent(jButton1).addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(totalPageLabel).addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(currentPage).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton2).addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(JumpButt,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JumpText, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE).addGap(59, 59, 59))).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837,
                                Short.MAX_VALUE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(EscButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).addComponent(ExportButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(ImportButt,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(UpData, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(SelectGoodsButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).addComponent(DeleteButt, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE).addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton3)).addGap(27, 27, 27)).addGroup(
                layout.createSequentialGroup().addGap(370, 370, 370).addComponent(jLabel11).addContainerGap(534, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jLabel11).addGap(46, 46, 46).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel6).addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel12).addComponent(ShelflifeText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel17).addComponent(PostText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel16).addComponent(ImgText,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2).addComponent(jLabel8)
                                .addComponent(CategoryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
                                ProductNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(12, 12, 12)
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(SalesVolumeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel10).addComponent(jLabel4).addComponent(jLabel15).addComponent(jLabel13).addComponent(InStockText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(SituationText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(DiscountText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(FactoryText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(StoreText,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                layout.createSequentialGroup().addComponent(DeleteButt).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(SelectGoodsButt)
                                        .addGap(18, 18, 18).addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(UpData).addGap(16, 16, 16).addComponent(jButton3).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(ImportButt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(ExportButt).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(EscButt).addContainerGap()).addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE).addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(pageSizeComBox,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(AllNum)).addGroup(
                                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(totalPageLabel).addComponent(jLabel5).addComponent(currentPage).addComponent(
                                                        jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(JumpButt,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(JumpText,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addComponent(
                                                jLabel1)).addGap(28, 28, 28)))));
        wick();
        pack();
    }// </editor-fold>
    //GEN-END:initComponents

    private void DiscountTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 返回按钮
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
        GoodsTable(1, 10, null);
        //		刷新总条数
        initGoodsGrid(null);
        //		加载类别下拉列表
        initGoodsTypeComBox();
    }

    /**
     * 下载按钮
     */
    private void ExportButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取输入框的数据
        Goods goods = getGoodsInfo();
        //		存储查询结果
        ResJson json = new ResJson();
        //		判断用户的选择
        int i = JOptionPane.showConfirmDialog(null, "是否下载数据", "", JOptionPane.YES_NO_CANCEL_OPTION);
        //		如果等于0则执行
        if (i == 0) {
            json = goodsService.download(goods);
            //			判断执行结果，并弹出语句
            if (json.getSub()) {
                JOptionPane.showMessageDialog(null, json.getStr());
            } else {
                JOptionPane.showMessageDialog(null, json.getStr());
            }
        }
    }

    private void ExportButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * &
     * 上传数据
     */
    private void ImportButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		存储查询结果
        ResJson json = new ResJson();
        // 		获取当前每页展示多少条
        int pageSize = Integer.parseInt(((String) this.pageSizeComBox.getSelectedItem()));
        //		判断用户的选择
        int i = JOptionPane.showConfirmDialog(null, "是否从本地上传数据", "", JOptionPane.YES_NO_CANCEL_OPTION);
        //		如果等于0则执行
        if (i == 0) {
            //			调用方法执行上传
            json = goodsService.importGoods();
            //			判断上传结果
            if (json.getSub()) {
                //				成功
                JOptionPane.showMessageDialog(null, json.getStr());
                //				刷新表格
                GoodsTable(1, pageSize, null);
                //				刷新总条数
                //加载起始页码
                this.totalPageLabel.setText("1");
                initGoodsGrid(null);
                //			加载类别下拉列表
                initGoodsTypeComBox();
            } else {
                //				失败，弹出错误结果
                JOptionPane.showMessageDialog(null, json.getStr());
            }
        }
    }

    private void ImportButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling
    }

    /**
     * 确认修改
     *
     * @param evt
     */
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
        //		获取文本框的数据
        Goods goods = getGoodsInfo();
        //		获取表格数据
        int row = this.GoodsTable.getSelectedRow();
        //		获取修改的id
        String id = (String) this.GoodsTable.getValueAt(row, 0);
        //		赋值
        goods.setId(id);
        //		调用修改方法
        ResJson json = goodsService.modiGoods(goods);
        //		判断修改结果
        if (json.getSub()) {
            //			清空输入框
            clearInput();
            JOptionPane.showMessageDialog(null, "修改成功");
            // 			获取获取当前页展示条数
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            //			刷新表格
            GoodsTable(1, pageSize, null);
            //			刷新总条数
            initGoodsGrid(null);
            //赋值给当前页数
            //加载起始页码
            this.totalPageLabel.setText("1");
            initGoodsTypeComBox();
        } else {
            //			失败，弹出结果
            JOptionPane.showMessageDialog(null, json.getStr());
        }
    }

    private void StoreTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ImgTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SalesVolumeTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void PostTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void InStockTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DeleteButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void UpDataActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 编辑
     */
    private void UpDataMouseClicked(java.awt.event.MouseEvent evt) {
        // 获取表格 选中项数据
        // 获取选中行
        int row = this.GoodsTable.getSelectedRow();
        //		判断用户是否选中
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选中一行");
            return;
        }
        //		获取对应的数据，赋值给文本框
        // 		名称
        String productName = (String) this.GoodsTable.getValueAt(row, 1);
        this.ProductNameText.setText(productName);
        //		价格
        String price = (String) this.GoodsTable.getValueAt(row, 3);
        this.PriceText.setText(price);
        //		销量
        String salesVolume = (String) this.GoodsTable.getValueAt(row, 4);
        this.SalesVolumeText.setText(salesVolume);
        //		库存
        String inStock = (String) this.GoodsTable.getValueAt(row, 5);
        this.InStockText.setText(inStock);
        //		店家
        String store = (String) this.GoodsTable.getValueAt(row, 6);
        this.StoreText.setText(store);
        //		厂家
        String factory = (String) this.GoodsTable.getValueAt(row, 7);
        this.FactoryText.setText(factory);
        //		保质期
        String shelflife = (String) this.GoodsTable.getValueAt(row, 8);
        this.ShelflifeText.setText(shelflife);
        //		图片
        String img = (String) this.GoodsTable.getValueAt(row, 9);
        this.ImgText.setText(img);
        //		折扣
        String Discount = (String) this.GoodsTable.getValueAt(row, 10);
        this.DiscountText.setText(Discount);
        //		状态
        String situation = (String) this.GoodsTable.getValueAt(row, 11);
        this.SituationText.setText(situation);
        //		邮递
        String post = (String) this.GoodsTable.getValueAt(row, 12);
        this.PostText.setText(post);
    }

    private void ShelflifeTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling cod
    }

    void privateionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void FactoryTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void PriceTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 删除
     */
    private void DeleteButtMouseClicked(java.awt.event.MouseEvent evt) {
        Goods goods = new Goods();
        ResJson json = new ResJson();
        int row = this.GoodsTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "请选中一行");
            return;
        }
        //		获取选中行的ID;
        goods.setId((String) this.GoodsTable.getValueAt(row, 0));
        json = goodsService.deleGoods(goods);
        if (json.getSub()) {
            JOptionPane.showMessageDialog(null, json.getStr());
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            //			刷新表格
            GoodsTable(1, pageSize, null);
            //			加载起始页码
            this.totalPageLabel.setText("1");
            //			刷新总条数
            initGoodsGrid(null);
        } else {
            JOptionPane.showMessageDialog(null, json.getStr());
        }
    }

    /**
     * 添加单击事件
     */
    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取添加的数据
        Goods goods = getGoodsInfo();
        ResJson json = goodsService.addGoods(goods);
        if (json.getSub()) {
            JOptionPane.showMessageDialog(null, json.getStr());
            //			清空输入框
            clearInput();
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            //			刷新表格
            GoodsTable(1, pageSize, null);
            //			加载起始页码
            this.totalPageLabel.setText("1");
            //			刷新总条数
            initGoodsGrid(null);
        } else {
            JOptionPane.showMessageDialog(null, json.getStr());
        }
    }

    /**
     * 清空输入框
     */
    private void clearInput() {
        //		名称
        this.ProductNameText.setText("");
        //		商品价格
        this.PriceText.setText("");
        //		商品库存
        this.InStockText.setText("");
        //		商品销量
        this.SalesVolumeText.setText("");
        //		商品销量
        this.StoreText.setText("");
        //		商品类别
        this.CategoryText.setSelectedIndex(0);

        this.FactoryText.setText("");
        //		保质期
        this.ShelflifeText.setText("");
        //		状态
        this.SituationText.setText("");
        //		折扣
        this.DiscountText.setText("");
        //		邮政
        this.PostText.setText("");
        //		图片
        this.ImgText.setText("");
    }

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code he
    }

    private void CategoryTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 下一页
     */
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        //		获取第一个数值
        int pageNum = Integer.parseInt(this.totalPageLabel.getText());
        //		获取第二个数值
        int totalNum = Integer.parseInt(this.currentPage.getText());
        if (pageNum >= totalNum) {
            JOptionPane.showMessageDialog(null, "当前已经是最后一页 ");
        } else {
            pageNum = pageNum + 1;
            // 			设置当前页数
            this.totalPageLabel.setText(pageNum + "");
            // 			获取pageSize
            int pageSize = Integer.parseInt((String) this.pageSizeComBox.getSelectedItem());
            // 			获取输入框的信息
            Goods goods = getGoodsInfo();
            //			刷新条数
            initGoodsGrid(goods);
            // 			刷新表格
            GoodsTable(pageNum, pageSize, goods);

        }
    }

    /**
     * 上一页
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
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
            Goods goods = getGoodsInfo();
            //			刷新条数
            initGoodsGrid(goods);
            //			刷新表格
            GoodsTable(pageNum, pageSize, goods);
        }
    }

    /**
     * 跳转事件
     */
    private void JumpButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取跳转的页码
        String str = this.JumpText.getText();
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
        Goods goods = getGoodsInfo();
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
            GoodsTable(jump, pageSize, goods);
        }

    }

    void JumpTextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void JumpButtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * 获得输入框中的数据
     *
     * @return 返回封装的数据
     */
    public Goods getGoodsInfo() {
        //		获取输入框的数据
        Goods goods = new Goods();
        //		商品名称
        String ProductNameText = this.ProductNameText.getText();
        goods.setProductName(ProductNameText);
        //		商品价格
        String PriceText = this.PriceText.getText();
        goods.setPrice(PriceText);
        //		商品库存
        String InStockText = this.InStockText.getText();
        goods.setInStock(InStockText);
        //		商品销量
        String SalesVolumeText = this.SalesVolumeText.getText();
        goods.setSalesVolume(SalesVolumeText);
        //		商品店家
        String StoreText = this.StoreText.getText();
        goods.setStore(StoreText);
        //		商品类别
        String typeID = "";
        String TypeName = (String) this.CategoryText.getSelectedItem();
        //		数据等于---请选择---则不赋值
        if (!TypeName.equals("---请选择---")) {
            //			赋值
            goods.setTypeName(TypeName);
            Category category = new Category();
            //			根据类别名称查询类别id
            category.setCategory(TypeName);
            //			获取结果
            ResJson json = categoryService.showCategory(category);
            //			获取数据
            Category cate = (Category) json.getList().get(0);
            //			赋值
            typeID = cate.getId();
        }
        goods.setIdcode(typeID);
        //		厂家
        goods.setFactory(FactoryText.getText());
        //		保质期
        goods.setShelflife(ShelflifeText.getText());
        //		状态
        goods.setSituation(SituationText.getText());
        //		折扣
        goods.setDiscount(DiscountText.getText());
        //		邮政
        goods.setPost(PostText.getText());
        //		图片
        goods.setImg(ImgText.getText());
        //		返回封装的数据
        return goods;

    }

    /**
     * 查询单击事件
     */
    private void SelectGoodsButtMouseClicked(java.awt.event.MouseEvent evt) {
        //		获取查询的数据
        Goods goods = getGoodsInfo();
        // 获取当前每页展示多少条
        int pageSize = Integer.parseInt(((String) this.pageSizeComBox.getSelectedItem()));
        //		加载表格
        GoodsTable(1, pageSize, goods);
        //		加载条数
        initGoodsGrid(goods);
    }

    private void pageSizeComBoxActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /**
     * 加载条数
     */
    public void initGoodsGrid(Goods goods) {
        //		调用方法，查询符合条件的数据数量
        double count = goodsService.selectGoodsCouny(goods);
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
     *
     * @param pageNum
     * @param pageSize
     */
    public void GoodsTable(int pageNum, int pageSize, Goods goods) {
        //		调用查询方法
        ResJson json = goodsService.selectGoodsByLimit(pageNum, pageSize, goods);
        //		判断查询结果
        if (json.getSub()) {
            //			获取数据
            List<Goods> goodsList = json.getList();
            //			获取表格对象
            DefaultTableModel tanleModel = (DefaultTableModel) this.GoodsTable.getModel();
            //			清空表格数据
            tanleModel.setRowCount(0);
            //			遍历数据
            for (Goods good : goodsList) {
                //				创建Vector集合组装数据
                Vector rowData = new Vector();
                //				将数据放入表格
                //				ID
                rowData.add(good.getId());
                //				名称
                rowData.add(good.getProductName());
                //				类别
                rowData.add(good.getTypeName());
                //				价格
                rowData.add(good.getPrice());
                //				销量
                rowData.add(good.getSalesVolume());
                //				库存
                rowData.add(good.getInStock());
                //				店家
                rowData.add(good.getStore());
                //				厂家
                rowData.add(good.getFactory());
                //				保质期
                rowData.add(good.getShelflife());
                //				图片
                rowData.add(good.getImg());
                //				折扣
                rowData.add(good.getDiscount());
                //				状态
                rowData.add(good.getSituation());
                //				邮递
                rowData.add(good.getPost());
                //				将数据放入表格
                tanleModel.addRow(rowData);
            }
        }
    }

    /**
     * 初始化类别下拉列表
     */
    public void initGoodsTypeComBox() {
        //		获取查询结果
        ResJson rejs = categoryService.selectCategoryAll();
        //		判断结果
        if (rejs.getSub()) {
            //			获取集合
            List<Category> categoriesList = rejs.getList();
            //			赋值
            this.CategoryText.addItem("---请选择---");
            //			遍历集合，存入列表
            for (Category category : categoriesList) {
                this.CategoryText.addItem(category.getCategory());
            }
            //			没有数据，输出异常
        } else {
            JOptionPane.showMessageDialog(null, rejs.getStr());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoodsData().setVisible(true);
            }
        });
    }

    //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel AllNum;
    private javax.swing.JComboBox CategoryText;
    private javax.swing.JButton DeleteButt;
    private javax.swing.JTextField DiscountText;
    private javax.swing.JButton EscButt;
    private javax.swing.JButton ExportButt;
    private javax.swing.JTextField FactoryText;
    private javax.swing.JTable GoodsTable;
    private javax.swing.JTextField ImgText;
    private javax.swing.JButton ImportButt;
    private javax.swing.JTextField InStockText;
    private javax.swing.JButton JumpButt;
    private javax.swing.JTextField JumpText;
    private javax.swing.JTextField PostText;
    private javax.swing.JTextField PriceText;
    private javax.swing.JTextField ProductNameText;
    private javax.swing.JTextField SalesVolumeText;
    private javax.swing.JButton SelectGoodsButt;
    private javax.swing.JTextField ShelflifeText;
    private javax.swing.JTextField SituationText;
    private javax.swing.JTextField StoreText;
    private javax.swing.JButton UpData;
    private javax.swing.JLabel currentPage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox pageSizeComBox;
    private javax.swing.JLabel totalPageLabel;
    // End of variables declaration//GEN-END:variables

}