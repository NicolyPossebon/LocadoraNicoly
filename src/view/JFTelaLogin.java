package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class JFTelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFTelaLogin frame = new JFTelaLogin();
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
	public JFTelaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelApresentar = new JLabel("Ol\u00E1, Seja Bem Vindo ao Sistema!");
		labelApresentar.setBounds(94, 11, 263, 19);
		labelApresentar.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(116, 79, 221, 28);
		textFieldUsuario.setColumns(10);
		
		JLabel labelUsuario = new JLabel("Usu\u00E1rio");
		labelUsuario.setBounds(200, 59, 56, 17);
		labelUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelSenha.setBounds(207, 132, 49, 14);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setForeground(new Color(0, 0, 0));
		passwordFieldSenha.setBounds(116, 153, 221, 29);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnEntrar.setBackground(Color.GRAY);
		btnEntrar.setForeground(SystemColor.desktop);
		btnEntrar.setBounds(137, 204, 85, 23);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLimpar.setBackground(Color.GRAY);
		btnLimpar.setBounds(232, 204, 85, 23);
		contentPane.setLayout(null);
		contentPane.add(labelApresentar);
		contentPane.add(textFieldUsuario);
		contentPane.add(labelUsuario);
		contentPane.add(labelSenha);
		contentPane.add(passwordFieldSenha);
		contentPane.add(btnEntrar);
		contentPane.add(btnLimpar);
	}
}
