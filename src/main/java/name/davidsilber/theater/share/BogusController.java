package name.davidsilber.theater.share;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BogusController {

    private static final String template = "Hi, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @GetMapping("/")
//    public String root() {
//        return "<html>\n" +
//                "<head>\n" +
//                "<title>Name of This Page</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "<h1>Title Is Here!</h1>\n" +
//                "<p>Look, here is a paragraph!</p>\n" +
//                "</body>\n" +
//                "</html>\n";
//    }

    @RequestMapping("/page")
    public String page() {
        return "<html>\n" +
                "<head>\n" +
                "<title>Name of That Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Title Is tHere!</h1>\n" +
                "<p>Look, there is a paragraph!</p>\n" +
                "</body>\n" +
                "</html>\n";
    }

    @RequestMapping("/greeting")
    public Greet greeting(@RequestParam(value="name", defaultValue="Y'all") String name) {
        return new Greet(
                counter.incrementAndGet(),
                String.format(template, name)
        );
    }
}