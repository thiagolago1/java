package Projeto001.views;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Projeto001.model.CadastroClienteConexao;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCPF;
	private JTextField txtIdade;
	private JTextField txtCodigoCliente;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public CadastroCliente() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpnPrincipal = new JPanel();
		jpnPrincipal.setForeground(Color.BLACK);
		jpnPrincipal.setBackground(Color.DARK_GRAY);
		jpnPrincipal.setBounds(0, 0, 543, 527);
		contentPane.add(jpnPrincipal);
		jpnPrincipal.setLayout(null);
		
		JLabel lblCadastroDeNovo = new JLabel("Cadastro de Novo Cliente");
		lblCadastroDeNovo.setForeground(Color.BLACK);
		lblCadastroDeNovo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblCadastroDeNovo.setBounds(12, 13, 287, 38);
		jpnPrincipal.add(lblCadastroDeNovo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblNome.setBounds(12, 69, 67, 38);
		jpnPrincipal.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setForeground(Color.WHITE);
		lblSobrenome.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblSobrenome.setBounds(12, 122, 109, 38);
		jpnPrincipal.add(lblSobrenome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblCpf.setBounds(12, 173, 52, 38);
		jpnPrincipal.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblSexo.setBounds(12, 327, 52, 38);
		jpnPrincipal.add(lblSexo);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setForeground(Color.WHITE);
		lblDataDeNascimento.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblDataDeNascimento.setBounds(12, 224, 192, 38);
		jpnPrincipal.add(lblDataDeNascimento);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblIdade.setBounds(12, 275, 67, 38);
		jpnPrincipal.add(lblIdade);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtNome.setToolTipText("Digite seu nome");
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBounds(216, 74, 274, 28);
		jpnPrincipal.add(txtNome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtSobrenome.setToolTipText("Digite seu sobrenome");
		txtSobrenome.setColumns(10);
		txtSobrenome.setBorder(null);
		txtSobrenome.setBounds(216, 127, 274, 28);
		jpnPrincipal.add(txtSobrenome);
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtCPF.setToolTipText("Digite seu cpf");
		txtCPF.setColumns(10);
		txtCPF.setBorder(null);
		txtCPF.setBounds(216, 178, 274, 28);
		jpnPrincipal.add(txtCPF);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtIdade.setToolTipText("Digite sua idade");
		txtIdade.setColumns(10);
		txtIdade.setBorder(null);
		txtIdade.setBounds(216, 280, 274, 28);
		jpnPrincipal.add(txtIdade);
		
		JFormattedTextField txtDataNascimento = new JFormattedTextField();
		txtDataNascimento.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtDataNascimento.setBorder(null);
		txtDataNascimento.setToolTipText("Digite a data do seu nascimento");
		txtDataNascimento.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtDataNascimento.setBounds(216, 229, 274, 28);
		jpnPrincipal.add(txtDataNascimento);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtCPF.setText("");
				txtDataNascimento.setText("");
				txtIdade.setText("");
				txtCodigoCliente.setText("");	
			}
		});
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLimpar.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnLimpar.setBackground(Color.WHITE);
			}
			
			public void limparCampos() {
				txtNome.setText("");
				txtSobrenome.setText("");
				txtCPF.setText("");
				txtDataNascimento.setText("");
				txtIdade.setText("");
				txtCodigoCliente.setText("");	
			}
			
		});
		btnLimpar.setRequestFocusEnabled(false);
		btnLimpar.setBorder(null);
		btnLimpar.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnLimpar.setBounds(12, 458, 151, 38);
		jpnPrincipal.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Projeto001.model.CadastroCliente.nome_cliente = txtNome.getText();
				Projeto001.model.CadastroCliente.codigo_cliente = txtCodigoCliente.getText();
				Projeto001.model.CadastroCliente.sobrenome_cliente = txtSobrenome.getText();
				Projeto001.model.CadastroCliente.cpf_cliente = txtCPF.getText();
				
				//Projeto001.model.CadastroCliente.data_nascimento_cliente = txtDataNascimento.getText();
				//Trâmite para transformar a string data de nascimento em data normal
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try {
					java.util.Date date = sdf.parse(txtDataNascimento.getText());
					java.sql.Date dataSql = new java.sql.Date(date.getTime());
					Projeto001.model.CadastroCliente.data_nascimento_cliente = dataSql;
				} catch (ParseException ex){
					Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
				}
				Projeto001.model.CadastroCliente.idade_cliente = Integer.parseInt(txtIdade.getText());
				//JComboBox cmbSexo = new JComboBox;
				//Projeto001.model.CadastroCliente.sexo_cliente = cmbSexo.getSelectedItem().toString();
				
				CadastroClienteConexao cadcan = new CadastroClienteConexao();
				cadcan.InserirCliente();
				
				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				
			}
		});
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSalvar.setBackground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnSalvar.setBackground(Color.WHITE);
			}
		});
		btnSalvar.setRequestFocusEnabled(false);
		btnSalvar.setFont(new Font("Segoe Print", Font.BOLD, 18));
		btnSalvar.setBorder(null);
		btnSalvar.setBounds(179, 458, 151, 38);
		jpnPrincipal.add(btnSalvar);
		
		JLabel lblCdigoDoCliente = new JLabel("C\u00F3digo do Cliente");
		lblCdigoDoCliente.setForeground(Color.WHITE);
		lblCdigoDoCliente.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblCdigoDoCliente.setBounds(12, 378, 192, 38);
		jpnPrincipal.add(lblCdigoDoCliente);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setToolTipText("Digite Masculino ou Feminino");
		txtCodigoCliente.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setBorder(null);
		txtCodigoCliente.setBounds(216, 388, 274, 28);
		jpnPrincipal.add(txtCodigoCliente);
		
		JComboBox cmbSexo = new JComboBox();
		cmbSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino", "Outro"}));
		cmbSexo.setForeground(Color.BLACK);
		cmbSexo.setBorder(null);
		cmbSexo.setFont(new Font("Segoe Print", Font.BOLD, 18));
		cmbSexo.setBackground(Color.WHITE);
		cmbSexo.setBounds(216, 337, 274, 28);
		jpnPrincipal.add(cmbSexo);
	}
}
