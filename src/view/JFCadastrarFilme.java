package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modal.bean.Filme;
import modal.dao.FilmeDAO;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textSinopse;
	private JTextField txtValor;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicione um novo filme a locadora!");
		lblNewLabel.setBounds(112, 13, 197, 28);
		contentPane.add(lblNewLabel);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(33, 70, 154, 28);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setBounds(33, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dura\u00E7\u00E3o");
		lblNewLabel_2.setBounds(198, 52, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Imagem");
		lblNewLabel_3.setBounds(305, 52, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(305, 73, 46, 23);
		contentPane.add(rdbtn3d);
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(353, 73, 46, 23);
		contentPane.add(rdbtn2d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);
		
		JList list = new JList();
		list.setBounds(62, 224, -17, -11);
		contentPane.add(list);
		
		JLabel lblNewLabel_4 = new JLabel("Dublado");
		lblNewLabel_4.setBounds(330, 109, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sinopse");
		lblNewLabel_5.setBounds(33, 163, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textSinopse = new JTextField();
		textSinopse.setText("");
		textSinopse.setBounds(33, 177, 370, 36);
		contentPane.add(textSinopse);
		textSinopse.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Valor");
		lblNewLabel_6.setBounds(33, 109, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		txtValor = new JTextField();
		txtValor.setBounds(33, 124, 120, 28);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Categoria");
		lblNewLabel_7.setBounds(163, 109, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(163, 124, 161, 28);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JSpinner spinnerDuracao = new JSpinner();
		spinnerDuracao.setBounds(197, 70, 102, 28);
		contentPane.add(spinnerDuracao);
		
		JRadioButton rdbtnDublado = new JRadioButton("Sim");
		rdbtnDublado.setBounds(330, 127, 60, 23);
		contentPane.add(rdbtnDublado);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Filme f = new Filme();
					FilmeDAO dao = new FilmeDAO();
					f.setTitulo(txtTitulo.getText());
					f.setSinopse(textSinopse.getText());
					f.setCategoria(txtCategoria.getText());
					f.setTempo(Integer.parseInt(spinnerDuracao.getValue().toString()));
					if(rdbtn2d.isSelected()) {
						f.setImagem3d(false);
					}else if (rdbtn3d.isSelected()) {
						f.setImagem3d(true);
					}
					if(rdbtnDublado.isSelected()) {
						f.setDublado(true);
					}
					dao.create(f);
				}

		});
		btnCadastrar.setBounds(163, 227, 110, 23);
		contentPane.add(btnCadastrar);
		
			
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(287, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(62, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
