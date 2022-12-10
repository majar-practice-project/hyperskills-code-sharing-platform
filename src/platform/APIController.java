package platform;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.database.CodeService;
import platform.domain.CodeSnippet;
import platform.dto.CodeDTO;
import platform.dto.CodeRequest;
import platform.dto.DTOMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {
    private final CodeService service;
    private final DTOMapper dtoMapper;

    public APIController(CodeService service, DTOMapper dtoMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping(value = "/code/{id}")
    public ResponseEntity<CodeDTO> getCode(@PathVariable UUID id){
        return ResponseEntity.ok(dtoMapper.toCodeDto(service.getCodeById(id)));
    }

    @PostMapping("/code/new")
    public ResponseEntity<Object> submitNewCode(@RequestBody CodeRequest request){
        CodeSnippet code = new CodeSnippet(request.getCode(), LocalDateTime.now(), request.getTime(), request.getViews());
        code = service.save(code);

        return ResponseEntity.ok(Map.of("id", code.getId().toString()));
    }

    @GetMapping("/code/latest")
    public ResponseEntity<List<CodeDTO>> getLatestCodes(){
        return ResponseEntity.ok(service.getLatest().stream().map(dtoMapper::toCodeDto).collect(Collectors.toList()));
    }

    public CodeDTO findCodeById(UUID id){
        return dtoMapper.toRenderCodeDto(service.getCodeById(id));
    }
}
