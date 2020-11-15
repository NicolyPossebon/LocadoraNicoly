package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modal.bean.Cliente;
import modal.bean.Filme;
import modal.dao.ClienteDAO;
import modal.dao.FilmeDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
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
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(56, 47, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(56, 62, 175, 35);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(241, 62, 128, 35);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(172, 122, 197, 35);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(56, 122, 106, 35);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(56, 181, 313, 35);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(81, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(txtNome.getText());
				c.setCpf(txtCpf.getText());
				c.setEmail(txtEmail.getText());
				c.setTelefone(txtTelefone.getText());
				c.setEndereco(txtEndereco.getText());
				
				dao.create(c);
			}
		});
		btnCadastrar.setBounds(180, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(279, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(241, 47, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(171, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(56, 108, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(56, 168, 46, 14);
		contentPane.add(lblEndereco);
	}
}
