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
import modal.bean.Filme;
import modal.dao.ClienteDAO;
import modal.dao.FilmeDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

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
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Listagem dos Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton btnCadastrarCliente = new JButton("Cadastrar ");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cc = new JFCadastrarCliente();
				cc.setVisible(true);
			}
		});
		btnCadastrarCliente.setBounds(25, 227, 94, 23);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnAlterarCliente = new JButton("Alterar ");
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
		btnAlterarCliente.setBounds(114, 227, 94, 23);
		contentPane.add(btnAlterarCliente);
		
		JButton btnExcluirCliente = new JButton("Excluir ");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(jtCliente.getSelectedRow() != -1) {
						int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?","Exclus�o",JOptionPane.YES_NO_OPTION);
						if (opcao == 0) {
							ClienteDAO dao = new ClienteDAO();
							Cliente c = new Cliente();
							c.setId((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
							dao.delete(c);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selecione um cliente!");
					}
				readJTable();
			}
		});
		btnExcluirCliente.setBounds(208, 227, 94, 23);
		contentPane.add(btnExcluirCliente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(295, 227, 94, 23);
		contentPane.add(btnCancelar);
		
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
