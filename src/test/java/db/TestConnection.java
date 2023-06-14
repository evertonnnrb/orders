package db;

import br.com.orders.db.DB;
import org.junit.Assert;
import org.junit.Test;

public class TestConnection{

    @Test
    public void testConnection(){
        Assert.assertNotNull(DB.getConnection());
    }
}
