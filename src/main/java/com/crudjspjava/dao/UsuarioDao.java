package com.crudjspjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjspjava.bean.Usuario;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDao {
	
	//cria conexão
	public static Connection getConnection() {
		Connection con = null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//crudjspjava == database, root == user e "" == password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava","root","" );//conexão com banco
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	//cadastra usuário
	public static int salvarUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();//os argumentos da query representam as colunas da table no banco
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario "
					+ "(nome, password, email, sexo, pais) VALUES(?,?,?,?,?)");
			ps.setString(1, u.getNome());//insere os valores nos parâmetros da query
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			status = ps.executeUpdate();//executeUpdate() o método retorna 1 se for inserido e 0 caso ocorra falha
		} catch (Exception e) {
			System.out.println(e);
		}		
		return status;
	}
	
	//retorna usuário por id
	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;
		
		try {
			Connection con = getConnection();              //usa o id inserido no arg do método getRegistroById();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE id=?");
			ps.setInt(1, id);//esse é o parâmetro informado na linha acima
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();//busco as informações do banco através do id do usuário e crio um objeto com os dados
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return usuario;
	}
	
	//atualiza usuário
	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET nome=?, "
					+ "password=?, email=?, sexo=?, pais=? WHERE id=?");
			//esses são os parâmetros informados acima e eles respeitam a ordem que foram inseridos na query
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			ps.setInt(6, u.getId());
			status = ps.executeUpdate();//executeUpdate() o método retorna 1 se for atualizado e 0 caso ocorra falha
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	//retorna todos usuários
	public static List<Usuario> getAllUsuarios(){
		List<Usuario> list = new ArrayList<>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();//armazena o resultado da query
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));//colunas de acordo com o banco
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				list.add(usuario);//adiciona o Usuario a lista
			}
		} catch (Exception e) {
			System.out.println(e);
		}		
		return list;
	}

}
