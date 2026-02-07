package gt.app;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class Application {

    @SneakyThrows
    static void main(String[] args) {
        log.info("Application started , params: {}", (Object) args);

        readGitProperties();

        PojoA p;
        if (args.length == 0) {
            p = new PojoA("Ganesh", 24);
        } else if (args.length == 1) {
            p = new PojoA(args[0], 24);
        } else { //length >1
            p = new PojoA(args[0], Integer.parseInt(args[1]));
        }

        p.country = "Nepal";

        log.info("PojoA: {}", p);

    }

    public static void readGitProperties() {
        log.info("Reading git.properties");
        try (InputStream input = Application.class.getClassLoader()
            .getResourceAsStream("git.properties")) {

            if (input != null) {
                Properties props = new Properties();
                props.load(input);

                props.forEach((key, value) ->
                    log.info("{} = {}", key, value)
                );
            } else {
                log.error("git.properties not found!");
            }
        } catch (IOException e) {
            log.error("Failed to read git.properties - {}", e.getMessage(), e);
        }
    }
}
