import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enzob
 */
public class vendasVIEW extends javax.swing.JFrame {

    // Construtor da tela
    public vendasVIEW() {
        initComponents();
        listarVendas(); // Atualiza a tabela assim que a tela abre
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); // Correção do erro: agora a tela abre de verdade!
    }

    // Método para listar apenas os produtos vendidos
    private void listarVendas() {
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            
            DefaultTableModel model = (DefaultTableModel) listaVendas.getModel();
            model.setNumRows(0);
            
            // ATENÇÃO: Você precisará criar o método listarProdutosVendidos() no seu ProdutosDAO
            ArrayList<ProdutosDTO> listagem = produtosdao.listarProdutosVendidos();
            
            for (int i = 0; i < listagem.size(); i++) {
                model.addRow(new Object[]{
                    listagem.get(i).getId(),
                    listagem.get(i).getNome(),
                    listagem.get(i).getValor(),
                    listagem.get(i).getStatus()
                });
            }
        } catch (Exception e) {
            // Se der erro porque a tabela visual ainda não existe, ele não vai travar o sistema
        }
    }

    // Código gerado pelo NetBeans para os componentes (GUI)
    // Se você desenhou a tela pelo modo Design, o NetBeans cuidará dessa parte
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        listaVendas = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Nome", "Valor", "Status"
            }
        ));
        jScrollPane1.setViewportView(listaVendas);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose(); // Fecha apenas a tela de vendas ao clicar em voltar
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); 
        jLabel1.setText("Consultar Vendas (Produtos Vendidos)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    // Variáveis da interface gráfica
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaVendas;
}