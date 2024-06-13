package Screen;

import Connection_SQL.Connection_SQL;
import static Screen.Home.checkin;
import static Screen.Home.checkout;
import static Screen.Room.value_ID;
import java.sql.*;
import java.text.SimpleDateFormat;
import static java.lang.Integer.*;
import javax.swing.JOptionPane;

public class Sign_in extends javax.swing.JFrame {
    
    Connection        conexaoBD = Connection_SQL.conexao();
    PreparedStatement executarComando = null;
    ResultSet         respostaBD = null;
    
    public Sign_in() {
        initComponents();
        
        
    }
    
    public void Logar(){
        String comandoSQLSearch ="SELECT * FROM tbl_client WHERE email_client=? AND password_client=?";

        try{
            executarComando = conexaoBD.prepareStatement(comandoSQLSearch);
            
            executarComando.setString(1, input_email.getText());
            executarComando.setString(2, input_pwd.getText());
            
            respostaBD = executarComando.executeQuery();
            
            if(respostaBD.next()){
                String comandoSQL = "INSERT INTO tbl_ticket(fk_IDroom, fk_IDclient, checkin_ticket, checkout_ticket) VALUES (?, ?, ?, ?)";
                
                try{    
                    executarComando = conexaoBD.prepareStatement(comandoSQL);
                    
                    executarComando.setInt(1, value_ID);
                    executarComando.setInt(2, parseInt(respostaBD.getString(1)));
                    
                    //convertendo datas...
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedCheckin = dateFormat.parse(checkin);
                    java.util.Date parsedCheckout = dateFormat.parse(checkout);
                    
                    java.sql.Date sqlCheckin = new java.sql.Date(parsedCheckin.getTime());
                    java.sql.Date sqlCheckout = new java.sql.Date(parsedCheckout.getTime());
                    //acabou de converter...
                    
                    executarComando.setDate(3, sqlCheckin);
                    executarComando.setDate(4, sqlCheckout);

                    executarComando.executeUpdate();
                    
                       
                }catch(Exception e){
                    JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido!", "Erro de autenticação SQL", JOptionPane.WARNING_MESSAGE);
                    
                }
                
                JOptionPane.showMessageDialog(rootPane, "Seu quarto foi alugado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);                
                
            }else{
                JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido!", "Erro de autenticação SQL", JOptionPane.WARNING_MESSAGE);
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Erro!", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_edit2 = new javax.swing.JButton();
        btn_edit3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        input_pwd = new javax.swing.JTextField();
        input_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Inicial");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        setForeground(java.awt.Color.black);
        setMaximizedBounds(new java.awt.Rectangle(50, 50, 1200, 800));
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setName("Home"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 800));
        setSize(new java.awt.Dimension(1200, 800));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel1.setText("Irmãos Beans");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel2.setName(""); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel3.setText("Pousada");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/image_login.png"))); // NOI18N

        jLabel5.setText("Que bom que você veio, venha aproveitar as exclusividades dos irmãos Beans!");

        jLabel6.setText("Bem-vindo Sr. Cliente!");

        jLabel7.setText("Faça o login aqui!");

        btn_edit2.setText("Login");
        btn_edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit2ActionPerformed(evt);
            }
        });

        btn_edit3.setText("Voltar");
        btn_edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Caso ainda não seja nosso cliente,");

        jLabel9.setForeground(new java.awt.Color(102, 153, 255));
        jLabel9.setText("<html>\n<head>\n<style>\np {\n  text-decoration: underline;\n}\n\np:hover {\n  color: blue;\n}\n</style>\n</head>\n<body>\n\n<p>clique aqui.</p>\n\n</body>\n</html>");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setText("Senha:");

        jLabel11.setText("E-mail:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel11))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(input_pwd, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                                .addComponent(input_email)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_edit3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7)
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(input_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(308, 308, 308)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_edit2)
                            .addComponent(btn_edit3))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Tela de Login/Cadastro");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit2ActionPerformed
        Logar();
    }//GEN-LAST:event_btn_edit2ActionPerformed

    private void btn_edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit3ActionPerformed
        dispose();
        
        new Room().setVisible(true);
    }//GEN-LAST:event_btn_edit3ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        setVisible(false);
        
        Sign_up window_home = new Sign_up();
        window_home.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_edit3;
    private javax.swing.JTextField input_email;
    private javax.swing.JTextField input_pwd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
