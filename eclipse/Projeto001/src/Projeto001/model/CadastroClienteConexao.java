package Projeto001.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Projeto001.conexao.ConexaoMydb;

public class CadastroClienteConexao {

	public void InserirCliente() {

		Connection conn = null;

		String sql = "INSERT INTO tb_cadastro (nome, sobrenome, idade, data_nascimento, sexo, cpf, codigo_cliente)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";

		conn = ConexaoMydb.getConexao();

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, CadastroCliente.nome_cliente);
			stmt.setString(2, CadastroCliente.sobrenome_cliente);
			stmt.setInt(3, CadastroCliente.idade_cliente);
			stmt.setDate(4, CadastroCliente.data_nascimento_cliente);
			stmt.setString(5, CadastroCliente.sexo_cliente);
			stmt.setString(6, CadastroCliente.cpf_cliente);
			stmt.setString(7, CadastroCliente.codigo_cliente);
			stmt.executeUpdate();

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados. Erro: " + ex);
		} finally {
			ConexaoMydb.fecharConexao(conn, stmt);
		}
	}

}
