package Projeto001.views;

import java.awt.BorderLayout;
import Projeto001.conexao.ConexaoMydb;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JDesktopPane;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DropMode;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MostrarCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTable jTableCliente;
	

		void initComponents() {
		JTableHeader jth = jTableCliente.getTableHeader();
		jth.setBackground(Color.WHITE);
		jTableCliente.setRowHeight(15);
	}
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarCadastroCliente frame = new MostrarCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private Connection conn = null;
	private JTextField textField;
	private JTextField textField_1;
	
	public void povoarJTable(String sql) {
		conn = ConexaoMydb.getConexao();
		try
        {
            PreparedStatement stmt = conn.prepareCall(sql);
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) jTableCliente.getModel();
            model.setNumRows(0);
            
            
            DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            
            while(rs.next())//Enquando o result estiver indo para o próximo
            {
                model.addRow(new Object[] 
                {
                    rs.getString("codigo_cliente"),
                    rs.getString("nome"), 
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    data.format(rs.getDate("data_nascimento")),
                    rs.getInt("idade"),
                    rs.getString("sexo"),
                    rs.getInt("id_tb_cadastro")
                    
                });
            }
            
            ConexaoMydb.fecharConexao(conn, stmt, rs);
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível obter os dados do banco. Erro:" + ex);
        }
	}

	
	public MostrarCadastroCliente() {
		JTable table = new JTable();
		table.setFont(new Font("Segoe Print", Font.BOLD, 18));
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.BLACK);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				String sql = "SELECT * FROM tb_cadastro ORDER BY id_tb_cadastro DESC";
		        
		        
		        povoarJTable(sql);
			}
		});
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane panel = new JScrollPane();
		panel.setBounds(0, 116, 869, 440);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		
		String[] columnNames = {
				"Código do Cliente", "Nome", "Sobrenome", "CPF", "Data de Nascimento", "Idade", "Sexo"
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo do Cliente", "Nome", "Sobrenome", "CPF", "Data de Nascimento", "Idade", "Sexo"
			}
		));
		panel.setViewportView(table);
		
		JButton txtPesquisaPorNome = new JButton("Pesquisa por nome");
		txtPesquisaPorNome.setForeground(Color.BLACK);
		txtPesquisaPorNome.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtPesquisaPorNome.setFocusPainted(false);
		txtPesquisaPorNome.setBorder(null);
		txtPesquisaPorNome.setBackground(Color.WHITE);
		txtPesquisaPorNome.setBounds(12, 13, 258, 25);
		contentPane.add(txtPesquisaPorNome);
		
		JButton txtPesquisaPorCPF = new JButton("Pesquisa por CPF");
		txtPesquisaPorCPF.setForeground(Color.BLACK);
		txtPesquisaPorCPF.setFont(new Font("Segoe Print", Font.BOLD, 18));
		txtPesquisaPorCPF.setFocusPainted(false);
		txtPesquisaPorCPF.setBorder(null);
		txtPesquisaPorCPF.setBackground(Color.WHITE);
		txtPesquisaPorCPF.setBounds(521, 13, 258, 25);
		contentPane.add(txtPesquisaPorCPF);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void txtPesquisaPorNomeKeyTyped(java.awt.event.KeyEvent evt) {
				String sql = "SELECT * FROM tb_cadastro WHERE nome LIKE '%" 
		                + txtPesquisaPorNome.getText() 
		                + "%' OR sobrenome LIKE '%"
		                + txtPesquisaPorNome.getText()
		                + "%'"
		                + " ORDER BY id_tb_cadastro DESC";
				
				povoarJTable(sql);
				
			}
			
			private void txtPesquisaPorCPFKeyTyped(java.awt.event.KeyEvent evt) {
		        // pesquisa pelo cpf
		        String sql = "SELECT * FROM tb_cadastro WHERE cpf LIKE '%" 
		                + txtPesquisaPorCPF.getText()
		                + "%'"
		                + " ORDER BY id_tb_cadastro DESC";
		        
		        povoarJTable(sql);
		    }
		});
		textField.setToolTipText("Digite seu nome");
		textField.setFont(new Font("Segoe Print", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(39, 51, 209, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Digite seu nome");
		textField_1.setFont(new Font("Segoe Print", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(549, 51, 217, 28);
		contentPane.add(textField_1);

		/**jTableCliente.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTableCliente.setForeground(Color.WHITE);
		jTableCliente.setBackground(Color.DARK_GRAY);
		jTableCliente.setBorder(null);
		jTableCliente.setFont(new Font("Segoe Print", Font.BOLD, 14));
		jTableCliente.setLayout(new BorderLayout());
		
		jTableCliente.getColumnModel().getColumn(0).setPreferredWidth(132);
		jTableCliente.getColumnModel().getColumn(2).setPreferredWidth(133);
		jTableCliente.getColumnModel().getColumn(4).setPreferredWidth(131);
		panel.setLayout(new BorderLayout());
		jTableCliente.setBounds(0, 50, 869, 506);
		panel.add(jTableCliente);
		**/
	
		
	}
}
