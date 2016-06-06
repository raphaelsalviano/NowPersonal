package br.com.ufpb.nowpersonal.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by rapha on 02/06/2016.
 */
@DatabaseTable(tableName = "usuario")
public class Usuario implements Serializable {

    @DatabaseField(generatedId = true, dataType = DataType.LONG)
    private long id;
    @DatabaseField(dataType = DataType.BOOLEAN)
    private boolean isStatus;
    @DatabaseField(dataType = DataType.STRING)
    private String nome;
    @DatabaseField(dataType = DataType.STRING)
    private String sobrenome;
    @DatabaseField(dataType = DataType.STRING)
    private String dataNascimento;
    @DatabaseField(dataType = DataType.STRING)
    private String telefone;
    @DatabaseField(dataType = DataType.STRING)
    private String email;
    @DatabaseField(dataType = DataType.STRING)
    private String senha;
    @DatabaseField(dataType = DataType.BOOLEAN)
    private boolean isPersonal;
    @DatabaseField(dataType = DataType.STRING)
    private String localTrabalho;
    @DatabaseField(dataType = DataType.STRING)
    private String horaComeco;
    @DatabaseField(dataType = DataType.STRING)
    private String horaFim;
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Endereco endereco;
    @DatabaseField(dataType = DataType.STRING)
    private String preco;
    @DatabaseField(dataType = DataType.INTEGER)
    private int cref;
    @DatabaseField(dataType = DataType.INTEGER)
    private int pin;

    public Usuario() {
    }

    public Usuario(String nome, String sobrenome, String dataNascimento, String telefone, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(boolean isStatus, String nome, String sobrenome, String dataNascimento, String telefone, String email, String senha, boolean isPersonal, String localTrabalho, String horaComeco, String horaFim, Endereco endereco, String preco, int cref, int pin) {
        this.isStatus = isStatus;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.isPersonal = isPersonal;
        this.localTrabalho = localTrabalho;
        this.horaComeco = horaComeco;
        this.horaFim = horaFim;
        this.endereco = endereco;
        this.preco = preco;
        this.cref = cref;
        this.pin = pin;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public String getHoraComeco() {
        return horaComeco;
    }

    public void setHoraComeco(String horaComeco) {
        this.horaComeco = horaComeco;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPersonal() {
        return isPersonal;
    }

    public void setPersonal(boolean personal) {
        isPersonal = personal;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getCref() {
        return cref;
    }

    public void setCref(int cref) {
        this.cref = cref;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
