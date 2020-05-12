package test.java.cn.bruski.kata;

import org.junit.Before;
import org.junit.Test;

import main.java.cn.bruski.kata.Schema;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchemaTest {
    private Schema schema;
    @Test
    public void should_create_schema_out_of_text() {
        setUp();
        assertThat(schema.size(), is(3));
    }

    @Before
    public void setUp() {
        String schemaAsText = "l:boolean p:integer d:string";
        schema = new Schema(schemaAsText);
    }

    @Test
    public void should_get_correct_type_of_argument() {
        assertThat(schema.typeOf("l"), is("boolean"));
    }


}
