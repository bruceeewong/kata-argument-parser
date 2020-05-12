package test.java.cn.bruski.kata;

import main.java.cn.bruski.kata.Parser;
import main.java.cn.bruski.kata.Schema;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParserTest {
    Parser parser;

    @Before
    public void setUp() {
        String[] argumentsAsText = {"-l", "true", "-d", "/usr/data", "-p", "8080"};
        String schemaAsText = "l:boolean d:string p:integer";
        Schema schema = new Schema(schemaAsText);
        parser = new Parser(schema, argumentsAsText);
    }

    @Test
    public void should_be_able_to_parse_key_value_out_of_string() {
        assertThat(parser.size(), is(3));
    }

    @Test
    public void should_get_value_of_key_with_correct_type() {
        assertThat(parser.valueOf("d"), is("/usr/data"));
        assertThat(parser.valueOf("l"), is(true));
        assertThat(parser.valueOf("p"), is(8080));
    }
}
