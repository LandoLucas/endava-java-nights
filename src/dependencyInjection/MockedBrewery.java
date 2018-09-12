package dependencyInjection;

public class MockedBrewery extends DuffBrewery{

    @Override
    public int distributeBeers() {
        System.out.println("We have never left Springfield!");
        return this.getBeers();
    }

    public MockedBrewery(int beers) {
        super(beers);
    }

    
    
}
