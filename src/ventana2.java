

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juancho270
 */
public class ventana2 extends javax.swing.JFrame {
    int numero = 0;
    int limite = 0;
    private List<JTextField> lista = new ArrayList<>();
    /**
     * Creates new form ventana2
     */
    public ventana2(){
        initComponents();
    }
    public ventana2(int numero, int limite) {
        this.numero = numero;
        this.limite = limite;
        initComponents();
        jLabelnumero.setText("El numero de topics es: " + numero);
        jLabellimite.setText("El limite de paginas es: " + limite);
        
        //Generar text field para introducir datos 
        List<JLabel> titulos = new ArrayList<>();
        titulos.add(new JLabel("Topic"));
        titulos.add(new JLabel("Minimo pag"));
        titulos.add(new JLabel("Maximo pag"));
        titulos.add(new JLabel("lectores por pag"));
        GridLayout lay = new GridLayout(numero+1,4 );
        jPanelDatos.setLayout(lay);
     
        for (int j = 0; j < titulos.size(); j++) {
            jPanelDatos.add(titulos.get(j));
        }
        for(int h = 0; h < titulos.size(); h++){
            for (int i = 0; i < numero; i++) {
                JTextField campo = new JTextField();
                jPanelDatos.add(campo);
                lista.add(campo);
                jPanelDatos.updateUI();
            }
        }
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelnumero = new javax.swing.JLabel();
        jLabellimite = new javax.swing.JLabel();
        jScrollPaneDatos = new javax.swing.JScrollPane();
        jPanelDatos = new javax.swing.JPanel();
        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        jScrollPaneDatos.setViewportView(jPanelDatos);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelnumero)
                .addGap(125, 125, 125)
                .addComponent(jLabellimite)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneDatos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Aceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelnumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addComponent(jLabellimite, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPaneDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Cancelar))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Regresa a la ventana principal
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
            new interfaz().setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed
// Verifica que los datos se hayan introducido y llama a los metodos de la clase archivo para crear la insancia y validar la salid
    //ademas de mostrarla en una tabla
    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
       //Validacion que los campos de los datos esten llenos 
        boolean decision = lista.get(0).getText().isEmpty();
        for (int i = 1; i < lista.size(); i++) {
            decision = decision || lista.get(i).getText().isEmpty();
        }
        if (decision == true){
            JOptionPane.showMessageDialog(this, "Por Favor llene todos los espacios");
        } else{
            //Creacion del archivo de la instancia que se quiiere ejecutar
            List<String> datos = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                datos.add(lista.get(i).getText());
            }
            archivo object = new archivo();
                try {
                    object.escribir(numero,limite,datos);
                 } 
                catch (IOException ex) {
                    Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
              ProcessBuilder processBuilder = new ProcessBuilder();
        //llamado de minizinc con el modelo y la instancia
        //Para ubuntu se ejecuta el comando desde consola 
        processBuilder.command("minizinc --solver Gecode /src/archivo/PeriodicoGenerico.mzn /src/archivo/instanciaPeriodico.dzn);

        // can also run the java file like this
        // processBuilder.command("java", "Hello");

        try {
               //Manipulacion de la salida para mostrar la tabla con la respuesta
            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));
            /* archivo escribir = new archivo();*/
            Object[][] info = object.modelarTabla(reader);
            String[] columnNames = {"Topic","Paginas","Lectores por pagina","Lectores totales",};
            JTable tabla = new JTable(info, columnNames);
            JFrame ventana = new JFrame("Respuesta");
            ventana.add(new JScrollPane(tabla));
            
            ventana.pack();
            ventana.setVisible(true);
            
         
        } catch (IOException e) {
            e.printStackTrace();
        }
                
        }
    }//GEN-LAST:event_AceptarActionPerformed

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
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel jLabellimite;
    private javax.swing.JLabel jLabelnumero;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JScrollPane jScrollPaneDatos;
    // End of variables declaration//GEN-END:variables
}
