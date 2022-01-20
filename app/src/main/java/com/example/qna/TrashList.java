package com.example.qna;

public class TrashList {
    String trash;
    String recycle;

    public TrashList(String trash, String recycle) {
        this.trash = trash;
        this.recycle= recycle;
    }

    public String getRecycle() {
        return recycle;
    }

    public String getTrash() {
        return trash;
    }

    public void setRecycle(String recycle) {
        this.recycle = recycle;
    }

    public void setTrash(String trash) {
        this.trash = trash;
    }
}
