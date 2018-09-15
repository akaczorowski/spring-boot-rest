package pl.akac.rest.restexample.feature.greeting

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RestController
import pl.akac.rest.restexample.feature.greeting.model.Greeting


@RestController
@RequestMapping("/greeting")
class GreetingController {

    companion object {

        private val template = "Hello, %s!"
    }

    private val counter = AtomicLong()

    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        return Greeting(counter.incrementAndGet(),
                String.format(template, name))
    }
}