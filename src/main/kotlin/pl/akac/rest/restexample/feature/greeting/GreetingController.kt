package pl.akac.rest.restexample.feature.greeting

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import pl.akac.rest.restexample.feature.greeting.model.Greeting


@RestController
@RequestMapping("/greeting")
class GreetingController {

    val logger = LoggerFactory.getLogger(GreetingController::class.java)

    companion object {

        private val template = "Hello, %s!"
    }

    private val counter = AtomicLong()

    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(),
                String.format(template, name))
    }

    @PostMapping("/message")
    fun message(@RequestBody msg: String){

        logger.info(msg)
        logger.trace(msg)
    }
}