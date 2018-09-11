package model;

public class Homero extends Simpson implements Catchphrase {

    private boolean isDrunk;
    private String job;
    
    @Override
    public String sayChatchphrase() {
        return "Anda la osa";
    }

    public boolean isDrunk() {
        return isDrunk;
    }

    public void setDrunk(Boolean isDrunk) {
        this.isDrunk = isDrunk;
    }
    
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Homero(Boolean isDrunk) {
        super();
        this.isDrunk = isDrunk;
        this.job = "tecnico nuclear";
    }

}
