package ru.chedmitriy.models;

/**
 * Created by dimsan on 18.09.2016.
 */
public class Comments extends Item {
    public String comments = "there are no comments";

    public Comments(String name, String description,String comments) {
        super(name, description);
        this.comments = comments;
    }

    public Comments(String comments) {
        this.comments = comments;
    }

    public Comments(String name, String description) {
        super(name, description);

    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
