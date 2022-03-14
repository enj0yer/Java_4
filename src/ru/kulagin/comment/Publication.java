package ru.kulagin.comment;

public class Publication {
    private String header;
    private String text;
    private String[] tags;
    private Comment[] comments;
    private int rating;

    public Publication(String header, String text, String[] tags, Comment[] comments, int rating){
        this.header = header;
        this.text = text;
        this.tags = tags.clone();
        this.comments = comments.clone();
        this.rating = rating;
    }
    public Publication(String header, String text, String[] tags, int rating){
        this.header = header;
        this.text = text;
        this.tags = tags.clone();
        this.rating = rating;
    }
    @Override
    public String toString(){
        String output = "(" + rating + ") "+ header + "\nтэги: ";
        for (String el : tags){
            output += " " + el + " ";
        }
        output += "\n" + text + "\nКомментарии:\n";
        for (Comment el : comments){
            el.toString();
        }
        return output;
    }
    public void ratingUp(){
        rating++;
    }
    public void ratingDown(){
        rating--;
    }
    public void addComments(Comment... comments){
        this.comments = comments.clone();
    }
    public String getHeader(){
        return header;
    }
    public boolean changeText(String text){
        if (comments == null){
            this.text = text;
            return true;
        }
        return false;
    }
}
