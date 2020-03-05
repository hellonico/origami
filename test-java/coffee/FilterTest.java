package coffee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import origami.Filter;
import origami.Filters;
import origami.Origami;

@RunWith(JUnit4.class)
public class FilterTest {
    @Test
    public void loadOne() {
        Filter f = Origami.StringToFilter("{:class coffee.NoOPFilter}");
        Assert.assertTrue(f.getClass().equals(NoOPFilter.class));
    }

    @Test
    public void loadMany() {
        Filter f = Origami.StringToFilter("[{:class coffee.NoOPFilter} {:class coffee.NoOPFilter}]");
        Assert.assertTrue(f.getClass().equals(Filters.class));
    }

}
