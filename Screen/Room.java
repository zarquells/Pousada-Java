package Screen;

import Connection_SQL.Connection_SQL;
import static Screen.Home.roomsOcupate;
import Screen.Sign_in;
import Screen.Sign_up;

import java.sql.*;
import javax.swing.JOptionPane;

public class Room extends javax.swing.JFrame {
    
    Connection ConexaoBD = Connection_SQL.conexao();
    PreparedStatement ExecutarComando = null;
    ResultSet RespostaBD = null;
    //variáveis de conexão que ainda receberão seus respectivos valores
    
    public Room() {
        initComponents();

        int value_ID = 1;

        String query = "SELECT pk_IDroom, description_room, price_room FROM tbl_room WHERE pk_IDroom=?";

        try{
            String id_room          = null;
            String description_room = null;
            String price_room       = null;

            ConexaoBD = Connection_SQL.conexao();

            ExecutarComando = ConexaoBD.prepareStatement(query);
            ExecutarComando.setInt(1,value_ID);
            RespostaBD = ExecutarComando.executeQuery();

            if(RespostaBD.next()){
                id_room          = RespostaBD.getString("pk_IDroom");
                description_room = RespostaBD.getString("description_room");
                price_room       = RespostaBD.getString("price_room");

                number_out.setText(id_room);
                description_out.setText(description_room);
                price_out.setText(price_room);                    

            }else{
                JOptionPane.showMessageDialog(null, "Não foi possível achar quartos disponíveis. Banco de dados vazio.");
                dispose();
            }
            
            for(int i = 0; i <= 30; i++){
                if(roomsOcupate[i] != null && roomsOcupate[i].equals(id_room)){
                    btn_check.setVisible(false);
                    break;

                }else if(i == 30){
                    if(roomsOcupate[i] != null && roomsOcupate[i].equals(id_room)){
                        btn_check.setVisible(false);

                    }else{
                        return;

                    }

                    btn_next.setVisible(false);
                    break;

                }else{

                    return;
                }
            }


        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão com o banco: " + e);   
        }
    }
    
    public void next_room(){
        for(int x = 1; x <= 30; x++){
            int value_ID = x;
            
            String query = "SELECT pk_IDroom, description_room, price_room FROM tbl_room WHERE pk_IDroom=?";

            try{
                String id_room          = null;
                String description_room = null;
                String price_room       = null;

                ConexaoBD = Connection_SQL.conexao();

                ExecutarComando = ConexaoBD.prepareStatement(query);
                ExecutarComando.setInt(1,value_ID);
                RespostaBD = ExecutarComando.executeQuery();

                if(RespostaBD.next()){
                    id_room          = RespostaBD.getString("pk_IDroom");
                    description_room = RespostaBD.getString("description_room");
                    price_room       = RespostaBD.getString("price_room");
                    
                    number_out.setText(id_room);
                    description_out.setText(description_room);
                    price_out.setText(price_room);                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possível achar quartos disponíveis. Banco de dados vazio.");
                    dispose();

                }

                for(int i = 0; i <= 30; i++){
                    if(roomsOcupate[i] != null && roomsOcupate[i].equals(id_room)){
                        btn_check.setVisible(false);
                        break;

                    }else if(i == 30){
                        if(roomsOcupate[i] != null && roomsOcupate[i].equals(id_room)){
                            btn_check.setVisible(false);

                        }else{
                            return;

                        }
                        number_out.setText(id_room);
                        description_out.setText(description_room);
                        price_out.setText(price_room);

                        btn_next.setVisible(false);
                        break;

                    }else{
                        number_out.setText(id_room);
                        description_out.setText(description_room);
                        price_out.setText(price_room);

                        return;

                    }
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível efetuar o comando: " + e);
            }

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        number_out = new javax.swing.JLabel();
        price_out = new javax.swing.JLabel();
        description_out = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btn_check = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnVoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel1.setText("Irmãos Beans");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(30, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(30, 30));
        jLabel2.setName(""); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(30, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 40));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        jLabel3.setText("Pousada");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 1200, 8));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 3, 36)); // NOI18N
        jLabel5.setText("Quartos disponíveis");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 360, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel12.setText("Verifique a disponibilidade");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Veja a variada opções dos 30 quarto da nossa pousada ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Quarto:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 264, 75, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Preço:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(782, 334, 75, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Descrição:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 75, -1));

        number_out.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        number_out.setToolTipText("");
        getContentPane().add(number_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 264, 76, 20));

        price_out.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(price_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 334, 75, 20));

        description_out.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(description_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 270, 20));

        btn_next.setText("Próximo quarto");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        getContentPane().add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 130, -1));

        btnHome.setText("Cancelar");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        getContentPane().add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 460, 130, -1));

        btn_check.setText("Realizar reserva");
        btn_check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_checkActionPerformed(evt);
            }
        });
        getContentPane().add(btn_check, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 460, 130, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/image_room.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        btnVoltar1.setText("Quarto anterior");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 130, -1));

        setSize(new java.awt.Dimension(1214, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        next_room();
        
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
            dispose();
        
            Home window_home = new Home();
            window_home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btn_checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_checkActionPerformed
 
    }//GEN-LAST:event_btn_checkActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Room.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Room().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JButton btn_check;
    private javax.swing.JButton btn_next;
    public static javax.swing.JLabel description_out;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel number_out;
    public static javax.swing.JLabel price_out;
    // End of variables declaration//GEN-END:variables

}
