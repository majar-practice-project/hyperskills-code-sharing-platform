package platform;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping(value = "/code", produces = MediaType.TEXT_HTML_VALUE)
public class CodeController {
    private final APIController api;

    public CodeController(APIController api) {
        this.api = api;
    }

    @GetMapping("/{id}")
    public String getCode(@PathVariable UUID id, Model model) {
        model.addAttribute("snippet", api.findCodeById(id));
        return "code";
    }

    @GetMapping(value = "/new")
    public String createNewCode(Model model) {
        return "newCode";
    }

    @GetMapping("/latest")
    public String getLatestCode(Model model){
        model.addAttribute("codes", api.getLatestCodes().getBody());
        return "latest";
    }
}
