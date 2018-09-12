package dependencyInjection;

public class DuffBrewery {

    private int beers;

    public int getBeers() {
        return beers;
    }

    public void setBeers(int beers) {
        this.beers = beers;
    }

    public DuffBrewery(int beers) {
        super();
        this.beers = beers;
    }
    
    public int distributeBeers() {
        throw new RuntimeException("We've moved to Albuquerque");
    }
    
}
