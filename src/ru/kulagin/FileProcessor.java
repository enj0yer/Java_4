package ru.kulagin;


interface OpenFile{
    void open(String fileName);
}

interface ChangeFile{
    void change();
}

interface WriteFile{
    void write(String fileName);
}

public abstract class FileProcessor {

    private OpenFile open;
    private WriteFile write;
    private ChangeFile change;

    public final void process(String fileName){
        open(fileName);
        change();
        write(fileName);

    }

    protected abstract void open(String filename);
    protected abstract void change();
    protected abstract void write(String filename);

}
