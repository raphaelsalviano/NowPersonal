package br.com.ufpb.nowpersonal.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by rapha on 03/06/2016.
 */
@DatabaseTable(tableName = "endereco")
public class Endereco implements Serializable {

    @DatabaseField(generatedId = true, dataType = DataType.LONG)
    private long id;
    @DatabaseField (dataType = DataType.DOUBLE)
    private double latitude;
    @DatabaseField (dataType = DataType.DOUBLE)
    private double longitude;
    @DatabaseField (dataType = DataType.STRING)
    private String endereco;
    @DatabaseField (dataType = DataType.STRING)
    private String pais;
    @DatabaseField (dataType = DataType.STRING)
    private String locale;
    @DatabaseField (dataType = DataType.STRING)
    private String cep;
    @DatabaseField (dataType = DataType.STRING)
    private String url;

    public Endereco() {
    }

    public Endereco(double latitude, double longitude, String endereco, String pais, String locale, String cep, String url) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
        this.pais = pais;
        this.locale = locale;
        this.cep = cep;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
