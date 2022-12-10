package platform.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CodeDTO {
    private String code;
    private String date;

    @JsonCreator
    public CodeDTO(
            @JsonProperty("code") String code,
            @JsonProperty("date") String date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }
}
