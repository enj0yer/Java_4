package ru.kulagin.comment;

import java.util.ArrayList;

public class Comment {

    String text = "";
    int rating = 0;
    Comment parentComment = null;
    int level = 0;
    ArrayList<Comment> nestedComments = new ArrayList<Comment>(0);

    public Comment(String text, int rating){
        this.text = text;
        this.rating = rating;
    }
    public void addComment(Comment newComment){
        newComment.parentComment = this;
        newComment.level = this.level + 1;
        nestedComments.add(newComment);
    }


    @Override
    public String toString(){
        String output = "";

        for (int i = 0; i < level; i++){
            output += "\t";
        }

        output += "(" + rating + ") " + text + "\n";

        for(Comment el : nestedComments){
            output += el.toString();
        }

        return output;
    }
}
