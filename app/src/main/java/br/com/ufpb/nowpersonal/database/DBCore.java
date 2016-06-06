package br.com.ufpb.nowpersonal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.ufpb.nowpersonal.model.Endereco;
import br.com.ufpb.nowpersonal.model.Usuario;

public class DBCore extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "NowPersonalDB";
    private static final int DB_VERSION = 7;

    public DBCore(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource, Endereco.class);
            TableUtils.createTable(connectionSource, Usuario.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try{
            TableUtils.dropTable(connectionSource, Endereco.class, true);
            TableUtils.dropTable(connectionSource, Usuario.class, true);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
