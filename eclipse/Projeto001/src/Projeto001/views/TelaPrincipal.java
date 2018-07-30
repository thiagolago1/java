package Projeto001.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaPrincipal() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpnPrincipal = new JPanel();
		jpnPrincipal.setBackground(Color.DARK_GRAY);
		jpnPrincipal.setBounds(0, 0, 408, 479);
		contentPane.add(jpnPrincipal);
		jpnPrincipal.setLayout(null);
		
		JButton btnCadastro = new JButton("Cadastrar Novo Cliente");
		btnCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnCadastro.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnCadastro.setBackground(Color.WHITE);
			}
		});
		btnCadastro.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				CadastroCliente cadastroCli = new CadastroCliente();
				cadastroCli.setVisible(true);
			}
		});
		btnCadastro.setFocusPainted(false);
		btnCadastro.setForeground(Color.BLACK);
		btnCadastro.setBorder(null);
		btnCadastro.setBackground(Color.WHITE);
		btnCadastro.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnCadastro.setBounds(12, 53, 258, 25);
		jpnPrincipal.add(btnCadastro);
		
		JButton btnAtualizarDados = new JButton("Atualizar Dados");
		btnAtualizarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAtualizarDados.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnAtualizarDados.setBackground(Color.WHITE);
			}
		});
		btnAtualizarDados.setForeground(Color.BLACK);
		btnAtualizarDados.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnAtualizarDados.setFocusPainted(false);
		btnAtualizarDados.setBorder(null);
		btnAtualizarDados.setBackground(Color.WHITE);
		btnAtualizarDados.setBounds(12, 127, 258, 25);
		jpnPrincipal.add(btnAtualizarDados);
		
		JButton btnBuscarClientes = new JButton("Buscar Clientes");
		btnBuscarClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBuscarClientes.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnBuscarClientes.setBackground(Color.WHITE);
			}
		});
		btnBuscarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarCadastroCliente mcc = new MostrarCadastroCliente();
				mcc.setVisible(true);
				
			}
		});
		btnBuscarClientes.setForeground(Color.BLACK);
		btnBuscarClientes.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnBuscarClientes.setFocusPainted(false);
		btnBuscarClientes.setBorder(null);
		btnBuscarClientes.setBackground(Color.WHITE);
		btnBuscarClientes.setBounds(12, 207, 258, 25);
		jpnPrincipal.add(btnBuscarClientes);
		
		JButton btnDeletarCadastro = new JButton("Deletar Cadastro");
		btnDeletarCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnDeletarCadastro.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnDeletarCadastro.setBackground(Color.WHITE);
			}
		});
		btnDeletarCadastro.setForeground(Color.BLACK);
		btnDeletarCadastro.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnDeletarCadastro.setFocusPainted(false);
		btnDeletarCadastro.setBorder(null);
		btnDeletarCadastro.setBackground(Color.WHITE);
		btnDeletarCadastro.setBounds(12, 282, 258, 25);
		jpnPrincipal.add(btnDeletarCadastro);
	}
}
