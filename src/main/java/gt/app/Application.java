package gt.app;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

    @SneakyThrows
    public static void main(String[] args) {
        log.info("Application started , params: {}", args);
    }

}
