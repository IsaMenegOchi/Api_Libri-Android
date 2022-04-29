package com.cristianomoraes.libri_retorfit.model;

public class Item {

    private int type; // tipos de livro de acordo com os números
    //classe mais alta do java, ela serve como uma variavel mutavel, recebendo varios tipos de classes
    private Object object;

    public Item() {
    }

    public Item(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
