package br.com.ufpb.nowpersonal.database;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

import br.com.ufpb.nowpersonal.model.Endereco;

/**
 * Created by rapha on 03/06/2016.
 */
public class EnderecoDao extends BaseDaoImpl<Endereco, Long> {

    public EnderecoDao(ConnectionSource connectionSource) throws SQLException{
        super(connectionSource, Endereco.class);
        initialize();
    }

    @Override
    public QueryBuilder<Endereco, Long> queryBuilder() {
        return super.queryBuilder();
    }
    //Com este método, você pode fazer os selects específicos utilizando as clausulas construídas
    //utilizando o queryBuilder
    @Override
    public List<Endereco> query(PreparedQuery<Endereco> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }

}
