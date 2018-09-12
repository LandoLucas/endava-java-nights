package dependencyInjection;

public class MoeTabern {

    private DuffBrewery brewery = new DuffBrewery(0);
    
    private int beersAvailable;
    
    public void serveBeer() {
        System.out.println("Serving a cold one...");
        if(this.beersAvailable < 1) {
            this.beersAvailable = brewery.distributeBeers();
        }
        this.beersAvailable --;
    }

    public DuffBrewery getBrewery() {
        return brewery;
    }

    public void setBrewery(DuffBrewery brewery) {
        this.brewery = brewery;
    }

    public int getBeersAvailable() {
        return beersAvailable;
    }

    public void setBeersAvailable(int beersAvailable) {
        this.beersAvailable = beersAvailable;
    }
    
    
}
