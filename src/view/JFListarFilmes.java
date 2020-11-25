package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modal.bean.Filme;
import modal.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable jtFilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		setTitle("Listagem dos Filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarFilme = new JLabel("Listar Filmes");
		lblListarFilme.setBounds(10, 11, 98, 21);
		contentPane.add(lblListarFilme);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 43, 390, 175);
		contentPane.add(scrollPane);
		
		jtFilme = new JTable();
		jtFilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "T\u00EDtulo", "Categoria", "Sinopse", "Tempo"
			}
		));
		scrollPane.setViewportView(jtFilme);
		
		JButton btnExcluirFilme = new JButton(" Excluir Filme");
		btnExcluirFilme.setBounds(282, 229, 120, 23);
		contentPane.add(btnExcluirFilme);
		
		JButton btnEditarFilme = new JButton("Alterar Filme");
		btnEditarFilme.setBounds(154, 229, 120, 23);
		contentPane.add(btnEditarFilme);
		
		JButton btnCadastrarFilme = new JButton("Cadastrar Filme");
		btnCadastrarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrarFilme.setBounds(30, 229, 120, 23);
		contentPane.add(btnCadastrarFilme);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtFilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getId(),
					f.getTitulo(),
					f.getCategoria(),
					f.getSinopse(),
					f.getTempo()
			});
		}
		
		
	}
	
	
}
