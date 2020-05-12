package test.java.cn.bruski.kata;

import main.java.cn.bruski.kata.Parser;
import main.java.cn.bruski.kata.Schema;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArgumentsAcceptanceTest {
    @Test
    public void should_be_able_parse_arguements() {
        // 1. create schema out of string
        String schemaAsText = "l:boolean d:string p:integer";
        Schema schema = new Schema(schemaAsText);

        // 2. parse arguments
        String[] argumentsAsStrings = {"-l", "true", "-d", "/usr/data", "-p", "8080"};
        Parser arguments = new Parser(schema, argumentsAsStrings);

        // 3. get parsed value
        assertThat(arguments.valueOf("l"), is(true));
        assertThat(arguments.valueOf("d"), is("/usr/data"));
        assertThat(arguments.valueOf("p"), is(8080));
    }
}
