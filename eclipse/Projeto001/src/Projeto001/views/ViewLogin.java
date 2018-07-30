package Projeto001.views;

import java.awt.BorderLayout;

import Projeto001.model.Login;
import Projeto001.model.LoginConexao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ViewLogin() {
		setUndecorated(true);
		setType(Type.UTILITY);
		setMinimumSize(new Dimension(420, 620));
		setMaximumSize(new Dimension(420, 620));
		setPreferredSize(new Dimension(420, 620));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpnPrincipal = new JPanel();
		jpnPrincipal.setBackground(Color.DARK_GRAY);
		jpnPrincipal.setBounds(0, 0, 420, 620);
		contentPane.add(jpnPrincipal);
		jpnPrincipal.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel.setBounds(58, 198, 100, 38);
		jpnPrincipal.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblSenha.setBounds(58, 293, 100, 38);
		jpnPrincipal.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setToolTipText("Digite seu usu\u00E1rio");
		txtUsuario.setBounds(58, 235, 274, 28);
		jpnPrincipal.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBorder(null);
		txtSenha.setToolTipText("Digite sua senha");
		txtSenha.setBounds(58, 328, 274, 28);
		jpnPrincipal.add(txtSenha);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogar.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnLogar.setBackground(Color.WHITE);
			}
		});
		btnLogar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//Quando Clicar no Botão de Logar
				Login.usuario = txtUsuario.getText();
				Login.senha = new String(txtSenha.getPassword());
				LoginConexao lg = new LoginConexao();
				lg.verificarUsuario();
				lg.InserirUsuario();
				
			}
		});
		btnLogar.setBorder(null);
		btnLogar.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnLogar.setBounds(58, 387, 274, 28);
		jpnPrincipal.add(btnLogar);
		
		JLabel lblLogotipo = new JLabel("Logotipo");
		lblLogotipo.setIcon(new ImageIcon("E:\\Programming\\Java\\Workspace\\Projeto001\\src\\Imagens\\P1.jpg"));
		lblLogotipo.setBounds(101, 6, 217, 130);
		jpnPrincipal.add(lblLogotipo);
		
		JLabel lblFechar = new JLabel("X");
		lblFechar.addMouseListener(new MouseAdapter() {
			@Override
			//Fechar quando clicar no X
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblFechar.setForeground(Color.WHITE);
		lblFechar.setBounds(397, 6, 39, 28);
		jpnPrincipal.add(lblFechar);
	}
}
