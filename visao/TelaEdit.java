/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import modelo.Conexao;
import modelo.EmprestimoDAO;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe TelaEdit para edição de empréstimos.
 */
public class TelaEdit extends JFrame {

    // Declaração dos campos de texto como variáveis de instância
    private JTextField txtLivro, txtUsuario, txtDataEmprestimo, txtDataDevolucao;

    public TelaEdit(String idEmprestimo, String nomeLivro, String nomeUsuario, String dataEmprestimo, String dataDevolucao) {
        setTitle("Editar Empréstimo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Campos de edição
        panel.add(new JLabel("Livro:"));
        txtLivro = new JTextField(nomeLivro);
        panel.add(txtLivro);

        panel.add(new JLabel("Usuário:"));
        txtUsuario = new JTextField(nomeUsuario);
        panel.add(txtUsuario);

        panel.add(new JLabel("Data Empréstimo:"));
        txtDataEmprestimo = new JTextField(dataEmprestimo);
        panel.add(txtDataEmprestimo);

        panel.add(new JLabel("Data Devolução:"));
        txtDataDevolucao = new JTextField(dataDevolucao);
        panel.add(txtDataDevolucao);

        // Botão Salvar
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação do botão Salvar
                String livro = txtLivro.getText();
                String usuario = txtUsuario.getText();
                String dataEmprestimo = txtDataEmprestimo.getText();
                String dataDevolucao = txtDataDevolucao.getText();

                // Convertendo os dados para os IDs correspondentes
                try {
                    EmprestimoDAO dao = new EmprestimoDAO();
                    int idLivro = dao.obterIdLivroPorNome(livro);
                    int idUsuario = dao.obterIdUsuarioPorNome(usuario);

                    if (idLivro != -1 && idUsuario != -1) {
                        dao.atualizarEmprestimo(Integer.parseInt(idEmprestimo), idLivro, idUsuario, dataEmprestimo, dataDevolucao);
                        JOptionPane.showMessageDialog(null, "Empréstimo atualizado com sucesso!");
                        dispose(); // Fechar a tela após salvar
                    } else {
                        JOptionPane.showMessageDialog(null, "Livro ou Usuário não encontrados.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar empréstimo: " + ex.getMessage());
                }
            }
        });

        panel.add(new JLabel()); // Espaço vazio para alinhar o botão
        panel.add(btnSalvar);

        add(panel);
    }

    // Construtor sem argumentos
    public TelaEdit() {
        this("", "", "", "", ""); // Valores padrão
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTemprestimo = new javax.swing.JTextField();
        jTdevolucao = new javax.swing.JTextField();
        jBsalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCusuario = new javax.swing.JComboBox<>();
        jClivro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Data Empréstimo");

        jLabel5.setText("Data Devolução");

        jTemprestimo.setToolTipText("");

        jTdevolucao.setToolTipText("");

        jBsalvar.setBackground(new java.awt.Color(102, 204, 255));
        jBsalvar.setForeground(new java.awt.Color(255, 255, 255));
        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 255));
        jLabel1.setText("Editar Emprestimo");

        jCusuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jClivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Usuario");

        jLabel3.setText("Livro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jClivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(302, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(135, 135, 135)
                            .addComponent(jBsalvar)
                            .addContainerGap(170, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jTemprestimo)
                                .addComponent(jTdevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabel1)))
                            .addContainerGap(24, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(jClivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(142, 142, 142)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTemprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTdevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jBsalvar)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed

        
    }//GEN-LAST:event_jBsalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jClivro;
    private javax.swing.JComboBox<String> jCusuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTdevolucao;
    private javax.swing.JTextField jTemprestimo;
    // End of variables declaration//GEN-END:variables
}
