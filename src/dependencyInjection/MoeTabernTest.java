package dependencyInjection;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

public class MoeTabernTest {

    private MoeTabern tabern;
    
    @Test
    public void serveBeer()throws Exception {
        tabern = new MoeTabern();
        
//        Field field = tabern.getClass().getDeclaredField("brewery");
//        field.setAccessible(true);
//        field.set(tabern, new MockedBrewery(10));
        
        tabern.serveBeer();
        assertEquals(9, tabern.getBeersAvailable());
    }
    
}
