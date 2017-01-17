import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	//Generamos un nuevo jugador
	Jugador player1=new Jugador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		//Inicializamos jugador
		player1.setNombre("");
		player1.setApellido1("");
		player1.setApellido2("");
		player1.setEdad(999);
		player1.setId(0);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 48, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDO1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 84, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("APELLIDO2");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 117, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 156, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblDatosJugador = new JLabel("DATOS JUGADOR");
		lblDatosJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosJugador.setBounds(137, 11, 134, 14);
		contentPane.add(lblDatosJugador);
		
		textField = new JTextField();
		textField.setBounds(114, 47, 310, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 83, 310, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 116, 310, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				player1.setApellido2 (textField_2.getText());
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 155, 310, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		//Boton A JUGAR
		JButton btnNewButton = new JButton("A JUGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Al pulsar el boton escribimos el mensaje por textField_3
				if (player1.getEdad()==999)
					textField_3.setText("Edad incorrecta. Pulse intro");
				else if (player1.sonEspacios(player1.getNombre()))
					textField_3.setText("Nombre incorrecto. Pulse intro");
				else if (player1.sonEspacios(player1.getApellido1()))
					textField_3.setText("Apellido1 incorrecto. Pulse intro");
				else if (player1.sonEspacios(player1.getApellido2()))
					textField_3.setText("Apellido2 incorrecto. Pulse intro");
				else 
					textField_3.setText("Nuevo jugador: "+player1.getNombre()+" "+player1.getApellido1()+" "+player1.getApellido2()+" de "+player1.getEdad()+" años.");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(10, 209, 414, 23);
		contentPane.add(btnNewButton);
		
		//Campo de texto para comentarios
		textField_4 = new JTextField();
		textField_4.setBounds(10, 242, 414, 62);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		//Recogemos datos de cada campo para asignarlos al jugador
		player1.setNombre(textField.getText());
		player1.setApellido1(textField_1.getText());
		
	}
}
