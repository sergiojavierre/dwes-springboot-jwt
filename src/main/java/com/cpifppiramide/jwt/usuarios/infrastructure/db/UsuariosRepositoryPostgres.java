package com.cpifppiramide.jwt.usuarios.infrastructure.db;

import com.cpifppiramide.jwt.context.db.PostgreSQLConnector;
import com.cpifppiramide.jwt.usuarios.domain.Usuario;
import com.cpifppiramide.jwt.usuarios.domain.UsuarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuariosRepositoryPostgres implements UsuarioRepository {
    @Override
    public Boolean registro(Usuario usuario) {
        String query = "insert into usuarios values (?,?)";
        PreparedStatement statement = null;
        try {
            statement = PostgreSQLConnector.getInstance().prepareStatement(query);
            statement.setString(1,usuario.getEmail());
            statement.setString(2,usuario.getPassword());
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Usuario login(Usuario usuario) {
        String query = "select * from usuarios where email = ?";
        PreparedStatement statement = null;
        try {
            statement = PostgreSQLConnector.getInstance().prepareStatement(query);
            statement.setString(1,usuario.getEmail());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
