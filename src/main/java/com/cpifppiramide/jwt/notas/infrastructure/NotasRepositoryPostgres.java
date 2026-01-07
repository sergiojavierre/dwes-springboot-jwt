package com.cpifppiramide.jwt.notas.infrastructure;

import com.cpifppiramide.jwt.context.db.PostgreSQLConnector;
import com.cpifppiramide.jwt.notas.domain.Nota;
import com.cpifppiramide.jwt.notas.domain.NotaRepository;
import com.cpifppiramide.jwt.usuarios.domain.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NotasRepositoryPostgres implements NotaRepository {

    @Override
    public List<Nota> list(Usuario usuario) {
        List<Nota> notas = new ArrayList<>();
        try{
            String query = "select * from notas where usuario = ?";
            PreparedStatement statement = PostgreSQLConnector.getInstance().prepareStatement(query);
            statement.setString(1,usuario.getEmail());
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Nota nota = new Nota(
                        rs.getInt("id"),
                        rs.getString("texto"),
                        rs.getTimestamp("timestamp")
                );
                notas.add(nota);
            }
        }
        catch (SQLException e){
            return null;
        }
        return notas;
    }

    @Override
    public Nota save(Nota nota, Usuario usuario) {
        String query = "insert into notas (texto, usuario, timestamp) values (?,?, now()) returning id, timestamp";
        PreparedStatement statement = null;
        try {
            statement = PostgreSQLConnector.getInstance().prepareStatement(query);
            statement.setString(1,nota.getTexto());
            statement.setString(2,usuario.getEmail());
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Integer id = rs.getInt("id");
                Timestamp timestamp = rs.getTimestamp("timestamp");
                nota.setId(id);
                nota.setTimestamp(timestamp);
                return nota;
            }
            else return null;
        } catch (SQLException e) {
            return null;
        }
    }
}
