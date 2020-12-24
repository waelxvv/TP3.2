package com.example.recettes;

import java.io.Serializable;

class Recette implements Serializable {
    String title;
    String desc;

    public Recette() {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
