package ru.itmo.wm4.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NoticeCredentials {
    @NotEmpty
    @Size(min = 1, max = 4000)
    private String text;

    @Size(min = 1, max = 4000)
    @Pattern(regexp = "[a-z\\s]+", message = "Expected lowercase latin letters")
    private String tags;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
