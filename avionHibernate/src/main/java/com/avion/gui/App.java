package com.avion.gui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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


import javax.swing.JButton;

public class App {

	private JFrame frame;
	private JTextField textFieldId;
	private JTextField textFieldHora;
	private JTextField textFieldVuelo;
	private JTextField textFieldDestino;
	private JTextField textFieldMostrador;
	private JTextField textFieldPuerta;

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
				textFieldMostrador.setText(model.getValueAt(index, 4).toString());
				textFieldPuerta.setText(model.getValueAt(index, 5).toString());
				
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		//Incluir a la tabla un panel con barra de scroll:
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(31, 42, 263, 130);
		
		//Mostrar el JScrollPane:
		frame.getContentPane().add(scrollPane);
		
		//Cargar los datos de la tabla estudiantes:
		for(Avion avion: aviones) {
			Object []row= {avion.getId(), avion.getHora(), avion.getVuelo(), avion.getDestino(), avion.getMostrador(), avion.getPuerta()};
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
		textFieldId.setBounds(158, 177, 200, 19);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(158, 204, 200, 19);
		frame.getContentPane().add(textFieldHora);
		textFieldHora.setColumns(10);
		
		textFieldVuelo = new JTextField();
		textFieldVuelo.setBounds(158, 231, 200, 19);
		frame.getContentPane().add(textFieldVuelo);
		textFieldVuelo.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(158, 258, 200, 19);
		frame.getContentPane().add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		textFieldMostrador = new JTextField();
		textFieldMostrador.setBounds(158, 286, 200, 19);
		frame.getContentPane().add(textFieldMostrador);
		textFieldMostrador.setColumns(10);
		
		textFieldPuerta = new JTextField();
		textFieldPuerta.setBounds(158, 313, 200, 19);
		frame.getContentPane().add(textFieldPuerta);
		textFieldPuerta.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(430, 201, 117, 25);
		frame.getContentPane().add(btnInsertar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(430, 250, 117, 25);
		frame.getContentPane().add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(430, 299, 117, 25);
		frame.getContentPane().add(btnBorrar);
		frame.setBounds(100, 100, 643, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
