package Projeto001.model;

import Projeto001.conexao.ConexaoMydb;
import Projeto001.views.TelaPrincipal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginConexao {

	

	public void InserirUsuario() {

		Connection conn = null;

		String sql = "INSERT INTO tb_login (usuario, senha) VALUES (?, ?)";

		conn = ConexaoMydb.getConexao();// conectar com o banco

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, Login.usuario);
			stmt.setString(2, Login.senha);
			stmt.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
		} finally {
			ConexaoMydb.fecharConexao(conn, stmt);
		}
	}

	
	public void verificarUsuario() {

		Connection conn = null;

		String sql = "SELECT * FROM tb_login WHERE usuario = '" + Login.usuario + "'";

		conn = ConexaoMydb.getConexao();// conectar ao banco 

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			rs.next();

			String usuario1 = rs.getString("usuario");
			String senha1 = rs.getString("senha");
			System.out.println(usuario1);
			System.out.println(senha1);

			 
			if (usuario1.equals(Login.usuario) && senha1.equals(Login.senha)) {
				TelaPrincipal tp = new TelaPrincipal();
				tp.setVisible(true);

			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao entrar no banco de dados. Erro: " + ex);
		} finally {
			ConexaoMydb.fecharConexao(conn, stmt);
		}
		
	}
	

}
