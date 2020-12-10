package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modal.bean.Cliente;
import modal.dao.ClienteDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarCliente extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarCliente frame = new JFListarCliente();
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
	public JFListarCliente() {
		setTitle("Listagem dos Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarClientes = new JLabel("Lista dos Clientes");
		lblListarClientes.setBounds(10, 26, 104, 23);
		contentPane.add(lblListarClientes);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 60, 363, 156);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "E-mail", "CPF", "Endere\u00E7o", "Telefone"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.setBounds(25, 227, 126, 23);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnAlterarCliente = new JButton("Alterar Cliente");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtCliente.getSelectedRow()!= -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente(
							(int)jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
					ac.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();			
			}
		});
		btnAlterarCliente.setBounds(153, 227, 116, 23);
		contentPane.add(btnAlterarCliente);
		
		JButton btnExcluirCliente = new JButton("Excluir Cliente");
		btnExcluirCliente.setBounds(271, 227, 116, 23);
		contentPane.add(btnExcluirCliente);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getNome(),
					c.getEmail(),
					c.getCpf(),
					c.getEndereco(),
					c.getTelefone()
					
					
			});
		}
	}
}
