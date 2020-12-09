package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modal.bean.Filme;
import modal.dao.FilmeDAO;

public class JFAtualizarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JTextField textSinopse;
		
	private static int id;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFilme frame = new JFAtualizarFilme(id);
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
	public JFAtualizarFilme(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel lblNewLabel = new JLabel("Edite os dados do Filme");
		lblNewLabel.setBounds(33, 11, 197, 28);
		contentPane.add(lblNewLabel);
		
		FilmeDAO fdao = new FilmeDAO();
		Filme f = fdao.read(id);
		
		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setBounds(275, 18, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(300, 18, 46, 14);
		contentPane.add(lblId);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(33, 70, 232, 28);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setBounds(33, 52, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dura\u00E7\u00E3o");
		lblNewLabel_2.setBounds(275, 52, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Imagem");
		lblNewLabel_3.setBounds(33, 112, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(33, 130, 46, 23);
		contentPane.add(rdbtn3d);
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(81, 130, 46, 23);
		contentPane.add(rdbtn2d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);
		
		JList list = new JList();
		list.setBounds(62, 224, -17, -11);
		contentPane.add(list);
		
		JLabel lblNewLabel_4 = new JLabel("Dublado");
		lblNewLabel_4.setBounds(340, 112, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sinopse");
		lblNewLabel_5.setBounds(33, 163, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textSinopse = new JTextField();
		textSinopse.setText("");
		textSinopse.setBounds(33, 177, 370, 36);
		contentPane.add(textSinopse);
		textSinopse.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Categoria");
		lblNewLabel_7.setBounds(127, 112, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(133, 130, 201, 28);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JSpinner spinnerDuracao = new JSpinner();
		spinnerDuracao.setBounds(275, 70, 128, 28);
		contentPane.add(spinnerDuracao);
		
		JRadioButton rdbtnDublado = new JRadioButton("Sim");
		rdbtnDublado.setBounds(340, 130, 60, 23);
		contentPane.add(rdbtnDublado);
		
		lblId.setText(String.valueOf(f.getId()));
		txtTitulo.setText(f.getTitulo());
		txtCategoria.setText(f.getCategoria());
		//txtSinopse.setText(f.getSinopse());
		//spTempo.setValue(f.getTempo());
		if(f.isImagem3d() == true) {
			rdbtn3d.setSelected(true);
		}else if (f.isImagem3d() == false) {
			rdbtn2d.setSelected(true);
		}
		if(f.isDublado() == true) {
			rdbtnDublado.setSelected(true);
		}

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Filme f = new Filme();
					FilmeDAO dao = new FilmeDAO();
					
					f.setId(Integer.parseInt(lblId.getText()));
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
					dao.update(f);
				}

		});
		btnAlterar.setBounds(163, 227, 110, 23);
		contentPane.add(btnAlterar);
		
			
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(287, 227, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(62, 227, 89, 23);
		contentPane.add(btnCancelar);
		

	}
}
