package io.bootique.cayenne.test;

import io.bootique.BQRuntime;
import io.bootique.jdbc.test.Column;
import io.bootique.jdbc.test.Table;
import io.bootique.test.junit.BQTestFactory;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CayenneModelUtilsIT {

    @Rule
    public BQTestFactory testFactory = new BQTestFactory();

    @Test
    public void testCreateTableModel() {
        BQRuntime runtime = testFactory.app("-c", "classpath:config1.yml")
                .autoLoadModules()
                .createRuntime();

        Table t1 = CayenneModelUtils.createTableModel(runtime, "db_entity");

        assertNotNull(t1);

        List<Column> columns = t1.getColumns();
        assertEquals(3, columns.size());
        assertEquals("a", columns.get(0).getName());
        assertEquals("b", columns.get(1).getName());
        assertEquals("id", columns.get(2).getName());
    }
}
