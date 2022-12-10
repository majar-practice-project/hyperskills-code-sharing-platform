package platform.dto;

import org.springframework.stereotype.Component;
import platform.domain.CodeSnippet;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DTOMapper {
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public CodeDTO toCodeDto(CodeSnippet code){
        return new CodeDTO(code.getCode(),
                code.getDate().format(DATE_TIME_FORMATTER),
                code.getExpiryDate()!=null ? Duration.between(LocalDateTime.now(), code.getExpiryDate()).getSeconds() : 0,
                code.getAvailableViews()!=null ? code.getAvailableViews() : 0);
    }

    public CodeDTO toRenderCodeDto(CodeSnippet code){
        return new CodeDTO(code.getCode(),
                code.getDate().format(DATE_TIME_FORMATTER),
                code.getExpiryDate()!=null ? Duration.between(LocalDateTime.now(), code.getExpiryDate()).getSeconds() : null,
                code.getAvailableViews()!=null ? code.getAvailableViews() : null);
    }
}
