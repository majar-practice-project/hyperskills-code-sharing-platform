package platform.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeRequest {
    private String code;
    private long time;
    private long views;

    @JsonCreator
    public CodeRequest(@JsonProperty("code") String code,
                       @JsonProperty("time") long time,
                       @JsonProperty("views") long views) {
        this.code = code;
        this.time = time;
        this.views = views;
    }

    public String getCode() {
        return code;
    }

    public long getTime() {
        return time;
    }

    public long getViews() {
        return views;
    }
}
