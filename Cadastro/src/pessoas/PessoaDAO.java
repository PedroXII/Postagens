package pessoas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConexaoMySQL;

public class PessoaDAO {
	// CRUD - Create Read Update Delete
	
	public void createTable() {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //iniciar conexão
		PreparedStatement stmt = null; //objeto statement para trabalhar com SQL
		
		try {
			stmt = conexao.prepareStatement("create table if not exists pessoas (nome varchar(100), idade int(3), sexo varchar(10), cpf int(15) primary key) default charset utf8;");
			stmt.executeUpdate();
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

	public void create(Pessoa pessoa) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //iniciar conexão
		PreparedStatement stmt = null; //objeto statement para trabalhar com SQL
		
		try {
			stmt = conexao.prepareStatement("INSERT INTO pessoas VALUES (?, ?, ?, ?)");
			stmt.setString(1, pessoa.getNome());
			stmt.setInt(2, pessoa.getIdade());
			stmt.setString(3, pessoa.getSexo());
			stmt.setInt(4, pessoa.getCpf());

			stmt.executeUpdate();
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

	public ArrayList<Pessoa> read(){
		Connection conexao = ConexaoMySQL.iniciarConexao(); // Abrir conexão com BD
		PreparedStatement stmt = null; // Cria um Statement
		ResultSet rs = null; //Cria um ResultSet
		ArrayList<Pessoa> listapessoas = new ArrayList<>(); //Cria uma ArrayList que vai armazenar o retorno do ResultSet
		
		try {
			stmt = conexao.prepareStatement("SELECT * FROM pessoas"); //SQL
			rs = stmt.executeQuery(); //Armazenar o retorno do SQL dentro do ResultSet
			//replicando os dados do ResultSet p/ o ArrayList
			while (rs.next()) {
				Pessoa pessoa = new Pessoa(); //Cria o objeto que irá compor o ArrayList
				pessoa.setNome(rs.getString("nome"));
				pessoa.setIdade(rs.getInt("idade"));
				pessoa.setSexo(rs.getString("sexo"));
				pessoa.setCpf(rs.getInt("cpf"));
				listapessoas.add(pessoa);
			}
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt, rs);
		}
		return listapessoas;
	}

	public void update(Pessoa pessoa) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //iniciar conexão
		PreparedStatement stmt = null; //objeto statement para trabalhar com SQL
		
		try {
			stmt =
			conexao.prepareStatement("UPDATE pessoas SET nome = ?, idade = ?, sexo = ? WHERE cpf = ?");
			stmt.setString(1, pessoa.getNome());
			stmt.setInt(2, pessoa.getIdade());
			stmt.setString(3, pessoa.getSexo());
			stmt.setInt(4, pessoa.getCpf());
			
			stmt.executeUpdate();
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}

	public void delete(Pessoa pessoa) {
		Connection conexao = ConexaoMySQL.iniciarConexao(); //iniciar conexão
		PreparedStatement stmt = null; //objeto statement para trabalhar com SQL
		
		try {
			stmt =
			conexao.prepareStatement("DELETE FROM pessoas WHERE cpf = ?");
			stmt.setInt(1, pessoa.getCpf());
			
			stmt.executeUpdate();
		} catch (SQLException erro){
			erro.printStackTrace();
		} finally {
			ConexaoMySQL.encerrarConexao(conexao, stmt);
		}
	}
}