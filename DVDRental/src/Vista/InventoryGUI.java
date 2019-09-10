/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorAddres;
import Controlador.ControladorCity;
import Controlador.ControladorCountry;
import Controlador.ControladorInventory;
import Controlador.ControladorStore;
import Modelo.Addres;
import Modelo.City;
import Modelo.Country;
import Modelo.Inventory;
import Modelo.Store;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class InventoryGUI extends javax.swing.JFrame {

    /**
     * Creates new form InventoryGUI
     */
    public InventoryGUI() {
        initComponents();
        setLocationRelativeTo(null);
        agregarPaisescbx();
       cargarInventory(obteneridStore());
    }
private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
public void agregarPaisescbx(){
        ControladorCountry p= new ControladorCountry();
        ArrayList<Country>paises;
        paises= p.listadoCountry(0);
   
    for(int i=0;i<paises.size();i++){
         cbxpais.addItem(paises.get(i).getName()+" ID:"+paises.get(i).getCountryid());}
        
    }
public void agregarCiudadescbx(int country_id){
           cbxciudad.setModel(new javax.swing.DefaultComboBoxModel<>());
           ControladorCity p= new ControladorCity();
        ArrayList<City>ciudades;
        ciudades= p.listadoCity(country_id); 
   
    for(int i=0;i<ciudades.size();i++){
         cbxciudad.addItem(ciudades.get(i).getCity()+" ID:"+ciudades.get(i).getCity_id());}
  
       }
public void agregarDireccionescbx(int city_id){
           cbxaddres.setModel(new javax.swing.DefaultComboBoxModel<>());
           ControladorAddres p= new ControladorAddres();
        ArrayList<Addres>direcciones;
        direcciones= p.listadoAddres(city_id);

    for(int i=0;i<direcciones.size();i++){
         cbxaddres.addItem(direcciones.get(i).getAddres()+" ID:"+direcciones.get(i).getAddresid());}

       }
public void agregarStorecbx(int addres_id){
    
           cbxstore.setModel(new javax.swing.DefaultComboBoxModel<>());
           ControladorStore p= new ControladorStore();
           
        ArrayList<Store>tiendas;
        tiendas= p.listadoStore(addres_id);

    for(int i=0;i<tiendas.size();i++){
         cbxstore.addItem("ID:"+tiendas.get(i).getStore_id());}
}
 public int obteneridPais(){
        int id,pos;
         String cbx;
        cbx=cbxpais.getSelectedItem().toString();
        pos=cbx.lastIndexOf(":")+1; 
        id= Integer.parseInt(cbx.substring(pos));
        return id;
    }
 public int obteneridCity(){
        int id,pos;
         String cbx;
        cbx=cbxciudad.getSelectedItem().toString();
        pos=cbx.lastIndexOf(":")+1; 
        id= Integer.parseInt(cbx.substring(pos));
        return id;
    }
  public int obteneridAddres(){
        int id,pos;
         String cbx;
        cbx= cbxaddres.getSelectedItem().toString();
        
        pos=cbx.lastIndexOf(":")+1; 
        id= Integer.parseInt(cbx.substring(pos));
        return id;
    }
    public int obteneridStore(){
        int id=-1,pos;
         String cbx;
        try{
        cbx= cbxstore.getSelectedItem().toString();
        pos=cbx.lastIndexOf(":")+1; 
        id= Integer.parseInt(cbx.substring(pos));
        }catch(Exception e){
            
        }finally{
        return id;}
        
    }
 public void cargarInventory(int store_id){
        DefaultTableModel modelo;
        
        modelo = (DefaultTableModel) jtListado.getModel();    
        ArrayList<Inventory> listado = new ArrayList();
        listado=ControladorInventory.listadoInventory(store_id);
        limpiarListadoTabla();
        for(int i= 0; i < listado.size(); i++){
              modelo.addRow(new Object[]{
              listado.get(i).getinventory_ID(),
              listado.get(i).getfilm_ID(),
              listado.get(i).getstore_ID(),
              listado.get(i).getLasUpdate(),
              });
        }
          
          
    }

 public int calcularId(){
    
     ControladorInventory s = new ControladorInventory();
     return s.listadoInventory(0).size()+1;
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cbxciudad = new javax.swing.JComboBox<>();
        cbxaddres = new javax.swing.JComboBox<>();
        cbxstore = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListado = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        cbxpais = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 130, 218));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        cbxciudad.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbxciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxciudadActionPerformed(evt);
            }
        });

        cbxaddres.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbxaddres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxaddresActionPerformed(evt);
            }
        });

        cbxstore.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbxstore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxstoreActionPerformed(evt);
            }
        });

        jtListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Inventario ID", "Pelicula ID", "Tienda ID", "Last Update"
            }
        ));
        jScrollPane1.setViewportView(jtListado);

        btnVolver.setBackground(new java.awt.Color(255, 102, 102));
        btnVolver.setForeground(new java.awt.Color(240, 240, 240));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cbxpais.setModel(new javax.swing.DefaultComboBoxModel<>());
        cbxpais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxpaisActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Inventario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Controles");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tienda ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Pelicula ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Inventario ID");

        btnBorrar.setBackground(new java.awt.Color(78, 191, 78));
        btnBorrar.setForeground(new java.awt.Color(240, 240, 240));
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnCancelar1.setBackground(new java.awt.Color(78, 191, 78));
        btnCancelar1.setForeground(new java.awt.Color(240, 240, 240));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.setEnabled(false);
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(78, 191, 78));
        btnNuevo.setForeground(new java.awt.Color(240, 240, 240));
        btnNuevo.setText("Nuevo");
        btnNuevo.setActionCommand("b");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(78, 191, 78));
        btnModificar.setForeground(new java.awt.Color(240, 240, 240));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(78, 191, 78));
        btnRegistrar.setForeground(new java.awt.Color(240, 240, 240));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setEnabled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Pais");

        jLabel7.setText("Ciudad");

        jLabel8.setText("Direccion");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(124, 124, 124))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxstore, 0, 187, Short.MAX_VALUE)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxciudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxaddres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxpais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxstore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(12, 12, 12)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar1)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbxciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxaddres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Admin ip =new Admin();
        setVisible(false);
        ip.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(jTextField1.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione un inventario","Error",
                JOptionPane.ERROR_MESSAGE);
        }
        else{
            int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Desea Eliminar el inventario de id: " +
                jTextField1.getText().trim()+
                " ?", "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
            if(respuesta == JOptionPane.YES_OPTION){
                int id = 0;
                id  = Integer.parseInt(jTextField1.getText().trim());

                if(ControladorAddres.borrarAddres(id) == 1){
                    JOptionPane.showMessageDialog(this,
                        "Registro Borrado con éxtio",
                        "Confirmación de acción",
                        JOptionPane.INFORMATION_MESSAGE);
                    cargarInventory(obteneridStore());
                }
                else{
                    JOptionPane.showMessageDialog(this,
                        "Error al borrar", "Confirmación de acción",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);

        cbxpais.setEnabled(true);
        cbxciudad.setEnabled(true);
        cbxaddres.setEnabled(false);
        //   jTextField5.setEnabled(false);

        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnRegistrar.setEnabled(false);
        btnModificar.setText("Modificar");
        btnCancelar.setEnabled(false);
        jtListado.setEnabled(true);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jTextField1.setText(calcularId()+"");
        jTextField2.setText("");

        if(btnNuevo.getText().equals("Nuevo")){
            btnRegistrar.setEnabled(true);
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(true);

            cbxpais.setEnabled(false);
            cbxciudad.setEnabled(false);
            cbxaddres.setEnabled(false);
            cbxstore.setEnabled(false);


            // jTextField5.setEnabled(true);

            btnRegistrar.setEnabled(true);
            btnBorrar.setEnabled(false);
            btnModificar.setEnabled(false);
            btnNuevo.setText("Cancelar");
            jtListado.setEnabled(false);
            jTextField1.requestFocusInWindow();
        }
        else{
            btnRegistrar.setEnabled(false);
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);

            cbxpais.setEnabled(true);
            cbxciudad.setEnabled(true);
            cbxaddres.setEnabled(true);
             cbxstore.setEnabled(true);
            // jTextField5.setEnabled(false);

            btnNuevo.setText("Nuevo");
            btnModificar.setEnabled(true);
            btnBorrar.setEnabled(true);
            jtListado.setEnabled(true);
            btnNuevo.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(btnModificar.getText().equalsIgnoreCase("Modificar")){
            if(jtListado.getSelectedRow() == -1){
                if(jtListado.getRowCount() == 0){
                    JOptionPane.showMessageDialog(this,"No hay registros");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Seleccione una fila");
                }

            } else{

                jTextField2.setEnabled(true);

                //   jTextField5.setEnabled(true);

                btnBorrar.setEnabled(false);
                btnNuevo.setEnabled(false);
                btnRegistrar.setEnabled(false);
                btnModificar.setText("Actualizar");
                btnCancelar.setEnabled(true);
                jtListado.setEnabled(false);
            }
        } else {

            jTextField2.setEnabled(false);

            btnBorrar.setEnabled(true);
            btnNuevo.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnModificar.setText("Modificar");
            btnCancelar.setEnabled(false);
            jtListado.setEnabled(true);

            Inventory a = new Inventory ();

            a.setinventory_ID (Integer.parseInt(jTextField1.getText()));
            a.setfilm_ID(Integer.parseInt(jTextField2.getText()));
            a.setstore_ID(obteneridStore());

            Date date = new Date();
            a.setLasUpdate(new Timestamp(date.getTime()));

            if(ControladorInventory.modificarInventory(a) == 1){
                JOptionPane.showMessageDialog(this,"Actualización exitosa");
                this.cargarInventory(obteneridStore());
            } else {
                JOptionPane.showMessageDialog(this,"Actualización Fallida");
            }

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(jTextField1.getText().trim().equals(""))
        JOptionPane.showMessageDialog(this,"Ingrese el Inventario ID");
        else{
            if (jTextField2.getText().trim().equals("")){
                JOptionPane.showMessageDialog(this,"Agregue  Film ID");

            }

            else{
                if (cbxciudad.getSelectedItem().toString().equals("")){
                    JOptionPane.showMessageDialog(this,"Debe crear primero una ciudad");

                }
                else{
                    if (cbxpais.getSelectedItem().toString().equals("")){
                        JOptionPane.showMessageDialog(this,"Debe crear primero un pais");

                    }
                    else{
                        if (cbxaddres.getSelectedItem().toString().equals("")){
                            JOptionPane.showMessageDialog(this,"Debe crear primero una direccion");

                        }else{
                        if (cbxstore.getSelectedItem().toString().equals("")){
                            JOptionPane.showMessageDialog(this,"Debe crear primero una tienda");

                        }
                        else {
                            Inventory a = new Inventory();
                            a.setinventory_ID(calcularId());
                            a.setfilm_ID(Integer.parseInt(jTextField2.getText()));
                            a.setstore_ID(obteneridAddres());

                            Date date = new Date();
                            a.setLasUpdate(new Timestamp(date.getTime()));

                            int tamaño;
                            tamaño = ControladorStore.listadoStore(a.getinventory_ID()).size();

                            if(tamaño == 0){
                                int resultado = 0;
                                resultado = ControladorInventory.grabarInventory(a);
                                if(resultado == 1){
                                    JOptionPane.showMessageDialog(this,
                                        "Inventario Grabado con éxito",
                                        "Confirmación",JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    JOptionPane.showMessageDialog(this,"Error al grabar",
                                        "Confirmación",JOptionPane.ERROR_MESSAGE);
                                }

                                cargarInventory(obteneridStore());

                                btnNuevo.setText("Nuevo");
                                jTextField1.setEnabled(false);
                                jTextField2.setEnabled(false);
                                cbxpais.setEnabled(true);
                                cbxciudad.setEnabled(true);
                                cbxaddres.setEnabled(true);
                                cbxstore.setEnabled(true);

                                //   jTextField5.setEnabled(false);

                                btnNuevo.setEnabled(true);
                                btnRegistrar.setEnabled(false);
                                btnBorrar.setEnabled(true);
                                btnModificar.setEnabled(true);
                                jtListado.setEnabled(true);
                                btnNuevo.requestFocusInWindow();

                            }
                            else{
                                JOptionPane.showMessageDialog(this,
                                    "ID ya registrado","Confirmación",
                                    JOptionPane.ERROR_MESSAGE);
                                jTextField1.requestFocusInWindow();
                            }

                        }
                    }    }}}}
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cbxpaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxpaisActionPerformed
        // TODO add your handling code here:
        agregarCiudadescbx(obteneridPais());
    }//GEN-LAST:event_cbxpaisActionPerformed

    private void cbxciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxciudadActionPerformed
        // TODO add your handling code here:
         agregarDireccionescbx(obteneridCity());
    }//GEN-LAST:event_cbxciudadActionPerformed

    private void cbxaddresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxaddresActionPerformed
        // TODO add your handling code here:
        agregarStorecbx(obteneridAddres());
    }//GEN-LAST:event_cbxaddresActionPerformed

    private void cbxstoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxstoreActionPerformed
        // TODO add your handling code here:
                 cargarInventory(obteneridStore());
       
    }//GEN-LAST:event_cbxstoreActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxaddres;
    private javax.swing.JComboBox<String> cbxciudad;
    private javax.swing.JComboBox<String> cbxpais;
    private javax.swing.JComboBox<String> cbxstore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable jtListado;
    // End of variables declaration//GEN-END:variables
}