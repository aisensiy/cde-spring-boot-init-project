package hello;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s";

    @RequestMapping(value = "/greeting", method = GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value = "/greeting", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Greeting createGreeting(@RequestBody GreetingRequest greetingRequest) {
        return new Greeting(counter.incrementAndGet(), String.format(template, greetingRequest.getName()));
    }
}

class GreetingRequest {
    private String name;

    public String getName() {
        return name;
    }
}
