package ru.kulagin.track;

public class Track {
    String name = "";
    String author = "";
    String album = "";
    private boolean inAlbum = false;

    public Track(String name, String[] authors, Album album){
        this.name = name;
        this.author += album.author;
        for (String el : authors) {
            if (el != this.author) {
                this.author += ", " + el;
            }
        }
        if (album != null) {
            inAlbum = true;
        }
    }

    @Override
    public String toString(){
        return name + ", авторы: " + author;
    }
}
