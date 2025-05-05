package com.avion.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.avion.dao.AvionDAO;
import com.avion.model.Avion;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.JButton;

public class App {

	private JFrame frame;
	private JTextField textFieldId;
	private JTextField textFieldHora;
	private JTextField textFieldVuelo;
	private JTextField textFieldDestino;
	private JTextField textFieldMostrador;
	private JTextField textFieldPuerta;
	private JTextField textFieldMostrador1;
	private JTextField textFieldMostrador2;
	private DatePicker datePicker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(152, 251, 152));
		frame.getContentPane().setLayout(null);
		
		AvionDAO avionDAO = new AvionDAO();
		List<Avion> aviones = avionDAO.selectAllAvion();
		
		//TABLA AVION:
		
		//Modelo de las cabeceras:
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Hora");
		model.addColumn("Vuelo");
		model.addColumn("Destino");
		model.addColumn("Mostrador");
		model.addColumn("Puerta");
		model.addColumn("Fecha");

		//Para que se vea bonito:
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				
				//Para poder seleccionar en la tabla y se rellene:
				textFieldId.setText(model.getValueAt(index, 0).toString());
				textFieldHora.setText(model.getValueAt(index, 1).toString());
				textFieldVuelo.setText(model.getValueAt(index, 2).toString());
				textFieldDestino.setText(model.getValueAt(index, 3).toString());
				String mostradores = model.getValueAt(index, 4).toString(); // columna única con "5-6"
				String[] partes = mostradores.split("-");
				textFieldMostrador1.setText(partes[0]);
				textFieldMostrador2.setText(partes.length > 1 ? partes[1] : "");
				textFieldPuerta.setText(model.getValueAt(index, 5).toString());
				Object fecha = model.getValueAt(index, 6);
				datePicker.setDate(LocalDate.parse(fecha.toString()));
				
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		//Incluir a la tabla un panel con barra de scroll:
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(32, 30, 561, 130);
		
		//Mostrar el JScrollPane:
		frame.getContentPane().add(scrollPane);
		
		//Cargar los datos de la tabla estudiantes:
		for(Avion avion: aviones) {
			String mostradoresUnidos = avion.getMostrador1() + "-" + avion.getMostrador2();
			Object []row= {avion.getId(), avion.getHora(), avion.getVuelo(), avion.getDestino(), mostradoresUnidos, avion.getPuerta(), avion.getFecha()};
			model.addRow(row);
		}
		table.setModel(model);
		
		JLabel lbl1 = new JLabel("Id:");
		lbl1.setBounds(53, 179, 70, 15);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Hora:");
		lbl2.setBounds(53, 206, 70, 15);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Vuelo:");
		lbl3.setBounds(53, 233, 70, 15);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("Destino:");
		lbl4.setBounds(53, 260, 70, 15);
		frame.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("Mostrador:");
		lbl5.setBounds(53, 288, 93, 15);
		frame.getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("Puerta:");
		lbl6.setBounds(53, 315, 70, 15);
		frame.getContentPane().add(lbl6);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		textFieldId.setBounds(133, 176, 86, 20);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(133, 203, 86, 20);
		frame.getContentPane().add(textFieldHora);
		textFieldHora.setColumns(10);
		
		textFieldVuelo = new JTextField();
		textFieldVuelo.setBounds(133, 230, 86, 20);
		frame.getContentPane().add(textFieldVuelo);
		textFieldVuelo.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(133, 257, 86, 20);
		frame.getContentPane().add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		textFieldMostrador1 = new JTextField();
		textFieldMostrador1.setBounds(133, 285, 86, 20);
		frame.getContentPane().add(textFieldMostrador1);
		textFieldMostrador1.setColumns(10);
		
		textFieldMostrador2 = new JTextField();
		textFieldMostrador2.setBounds(242, 285, 86, 20);
		frame.getContentPane().add(textFieldMostrador2);
		textFieldMostrador2.setColumns(10);
		
		textFieldPuerta = new JTextField();
		textFieldPuerta.setBounds(133, 314, 86, 20);
		frame.getContentPane().add(textFieldPuerta);
		textFieldPuerta.setColumns(10);
		
		JLabel lbl7 = new JLabel("-");
		lbl7.setBounds(228, 288, 14, 14);
		frame.getContentPane().add(lbl7);
		
		JLabel lbl8 = new JLabel("Fecha:");
		lbl8.setBounds(53, 344, 46, 14);
		frame.getContentPane().add(lbl8);
		
		frame.setBounds(100, 100, 643, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DatePickerSettings settings = new DatePickerSettings();
        settings.setLocale(Locale.getDefault());
        datePicker = new DatePicker(settings);
        datePicker.getComponentDateTextField().setEditable(false);
        datePicker.setBounds(133, 342, 185, 19);
        settings.setFormatForDatesCommonEra("dd/MM/yyyy");
        frame.getContentPane().add(datePicker);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String hora;
        		String vuelo;
        		String destino;
        		int mostrador1;
        		int mostrador2;
        		int puerta;
        		LocalDate fecha;
        		
        		//recoger datos:
        		hora=textFieldHora.getText();
        		vuelo=textFieldVuelo.getText();
        		destino=textFieldDestino.getText();
				mostrador1=Integer.parseInt(textFieldMostrador1.getText());
				mostrador2=Integer.parseInt(textFieldMostrador2.getText());
				puerta=Integer.parseInt(textFieldPuerta.getText());
				fecha=datePicker.getDate();
				
				//Crear avion:
				Avion avion = new Avion(hora, vuelo, destino, mostrador1, mostrador2, puerta, fecha);
				avionDAO.insertAvion(avion);
				
				//Borrar todo lo seleccionado:
				textFieldId.setText("");
				textFieldHora.setText("");
				textFieldVuelo.setText("");
				textFieldDestino.setText("");
				textFieldMostrador1.setText("");
				textFieldMostrador2.setText("");
				textFieldPuerta.setText("");
				datePicker.setDate(null);
				
				//Recargar la tabla:
				model.setRowCount(0);
				List<Avion> aviones = avionDAO.selectAllAvion();
				
				for(Avion avioncito: aviones) {
					String mostradoresUnidos = avioncito.getMostrador1() + "-" + avioncito.getMostrador2();
					Object []row= {
					    avioncito.getId(),
					    avioncito.getHora(),
					    avioncito.getVuelo(),
					    avioncito.getDestino(),
					    mostradoresUnidos,
					    avioncito.getPuerta(),
					    avioncito.getFecha()
					};
					model.addRow(row);
				}
				table.setModel(model);
        	}
        });
        btnGuardar.setBounds(425, 225, 127, 23);
        frame.getContentPane().add(btnGuardar);
        
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int id;
        		String hora;
        		String vuelo;
        		String destino;
        		int mostrador1;
        		int mostrador2;
        		int puerta;
        		LocalDate fecha;
        		
        		//Actualizar el avion por su id y seleccionarlo:
				id=Integer.parseInt(textFieldId.getText());
				Avion avion = avionDAO.selectAvionById(id);
				

				//Recoge los datos nuevos puestos:
				id=Integer.parseInt(textFieldId.getText());
				hora=textFieldHora.getText();
        		vuelo=textFieldVuelo.getText();
        		destino=textFieldDestino.getText();
				mostrador1=Integer.parseInt(textFieldMostrador1.getText());
				mostrador2=Integer.parseInt(textFieldMostrador2.getText());
				puerta=Integer.parseInt(textFieldPuerta.getText());
				fecha=datePicker.getDate();
				
				//Pone los datos nuevos puestos solo de los datos que se actualizan:
				avion.setHora(hora);
				avion.setVuelo(vuelo);
				avion.setDestino(destino);
				avion.setMostrador1(mostrador1);
				avion.setMostrador2(mostrador2);
				avion.setPuerta(puerta);
				avion.setFecha(fecha);
				
				//Hace la funcion de actualizar:
				avionDAO.updateAvion(avion);
				
				//Borrar todo lo seleccionado:
				textFieldId.setText("");
				textFieldHora.setText("");
				textFieldVuelo.setText("");
				textFieldDestino.setText("");
				textFieldMostrador1.setText("");
				textFieldMostrador2.setText("");
				textFieldPuerta.setText("");
				datePicker.setDate(null);
				
				//Recargar la tabla:
				model.setRowCount(0);
				List<Avion> aviones = avionDAO.selectAllAvion();
				
				for(Avion avioncito: aviones) {
					String mostradoresUnidos = avioncito.getMostrador1() + "-" + avioncito.getMostrador2();
					Object []row= {
					    avioncito.getId(),
					    avioncito.getHora(),
					    avioncito.getVuelo(),
					    avioncito.getDestino(),
					    mostradoresUnidos,
					    avioncito.getPuerta(),
					    avioncito.getFecha()
					};
					model.addRow(row);
				}
				table.setModel(model);
        	}
        });
        btnActualizar.setBounds(425, 256, 127, 23);
        frame.getContentPane().add(btnActualizar);
        
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int id;
        		
        		//Borra el avion por su id, lo selecciona y hace la funcion de borrarlo:
				id=Integer.parseInt(textFieldId.getText());	
				avionDAO.deleteAvion(id);
				
				//Borrar todo lo seleccionado:
				textFieldId.setText("");
				textFieldHora.setText("");
				textFieldVuelo.setText("");
				textFieldDestino.setText("");
				textFieldMostrador1.setText("");
				textFieldMostrador2.setText("");
				textFieldPuerta.setText("");
				datePicker.setDate(null);
				
				//Recargar la tabla:
				model.setRowCount(0);
				List<Avion> aviones = avionDAO.selectAllAvion();
				
				for(Avion avioncito: aviones) {
					String mostradoresUnidos = avioncito.getMostrador1() + "-" + avioncito.getMostrador2();
					Object []row= {
					    avioncito.getId(),
					    avioncito.getHora(),
					    avioncito.getVuelo(),
					    avioncito.getDestino(),
					    mostradoresUnidos,
					    avioncito.getPuerta(),
					    avioncito.getFecha()
					};
					model.addRow(row);
				}
				table.setModel(model);
        	}
        });
        btnBorrar.setBounds(425, 284, 127, 23);
        frame.getContentPane().add(btnBorrar);
        
        
		
	}
}
