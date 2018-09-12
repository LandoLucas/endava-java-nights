package model;

public class Bart extends Simpson implements Catchphrase{
    
    private String catchphrase = "Ay Caramba!";
    
    @Override
    public String sayChatchphrase() {
        return this.catchphrase;
    }

    
}
