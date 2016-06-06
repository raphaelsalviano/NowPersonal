package br.com.ufpb.nowpersonal.model;

import java.util.List;

/**
 * Created by rapha on 05/06/2016.
 */
public class ItemSettings {

    private int id;
    private String name;
    private int icoDrawable;
    private List<String> subItens;

    public ItemSettings(int id, String name, int icoDrawable, List<String> subItens) {
        this.id = id;
        this.name = name;
        this.icoDrawable = icoDrawable;
        this.subItens = subItens;
    }

    public ItemSettings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcoDrawable() {
        return icoDrawable;
    }

    public void setIcoDrawable(int icoDrawable) {
        this.icoDrawable = icoDrawable;
    }

    public List<String> getSubItens() {
        return subItens;
    }

    public void setSubItens(List<String> subItens) {
        this.subItens = subItens;
    }
}
