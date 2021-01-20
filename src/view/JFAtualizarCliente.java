package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modal.bean.Cliente;
import modal.bean.Filme;
import modal.dao.ClienteDAO;
import modal.dao.FilmeDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textEndereco;
	private static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(241, 47, 62, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(171, 108, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(56, 108, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(56, 168, 100, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblNewLabel_3 = new JLabel("EDITE UM CLIENTE");
		lblNewLabel_3.setBounds(56, 22, 169, 14);
		contentPane.add(lblNewLabel_3);
		
		textNome = new JTextField();
		textNome.setBounds(56, 64, 161, 33);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setText("");
		textCpf.setBounds(240, 64, 128, 33);
		contentPane.add(textCpf);
		textCpf.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setBounds(56, 126, 100, 36);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(171, 126, 197, 36);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setBounds(56, 183, 312, 33);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setBounds(241, 22, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(297, 22, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(56, 47, 62, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText(null);
				textCpf.setText(null);
				textEndereco.setText(null);
				textEmail.setText(null);
				textTelefone.setText(null);
			}
		});
		btnLimpar.setBounds(81, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		lblId.setText(String.valueOf(c.getId()));
		textNome.setText(c.getNome());
		textEmail.setText(c.getEmail());
		textCpf.setText(c.getCpf());
		textEndereco.setText(c.getEndereco());
		textTelefone.setText(c.getTelefone());
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setId(Integer.parseInt(lblId.getText()));
				c.setNome(textNome.getText());
				c.setCpf(textCpf.getText());
				c.setEmail(textEmail.getText());
				c.setTelefone(textTelefone.getText());
				c.setEndereco(textEndereco.getText());
				
				dao.update(c);
			}
		});
		btnAlterar.setBounds(180, 227, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(279, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
