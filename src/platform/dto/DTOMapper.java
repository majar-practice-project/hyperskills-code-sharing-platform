package platform.dto;

import org.springframework.stereotype.Component;
import platform.domain.CodeSnippet;

import java.time.format.DateTimeFormatter;

@Component
public class DTOMapper {
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public CodeDTO toDto(CodeSnippet code){
        return new CodeDTO(code.getCode(), code.getDate().format(DATE_TIME_FORMATTER));
    }
}
