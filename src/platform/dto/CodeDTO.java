package platform.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CodeDTO {
    private String code;
    private String date;

    private Long time;
    private Long views;

    @JsonCreator
    public CodeDTO(
            @JsonProperty("code") String code,
            @JsonProperty("date") String date,
            @JsonProperty("time") Long time,
            @JsonProperty("views") Long views) {
        this.code = code;
        this.date = date;
        this.time = time;
        this.views = views;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public Long getTime() {
        return time;
    }

    public Long getViews() {
        return views;
    }
}
