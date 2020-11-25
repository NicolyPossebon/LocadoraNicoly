package modal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import modal.bean.Cliente;
import modal.bean.Filme;

public class ClienteDAO {
	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, cpf, email, telefone, endereco) VALUES"
					+ "(?,?,?,?,?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setString(3, c.getEmail());
			stmt.setString(4, c.getTelefone());
			stmt.setString(5, c.getEndereco());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> cliente = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setCpf(rs.getString("cpf"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				
				cliente.add(c);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente");
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return cliente;
	}

}
