package com.example.grown_together.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EnumPostEvents {
    POST_CREATED(1, "POST_CREATED", "Post Created"),
    POST_UPDATED_CONTENT(2, "POST_UPDATED_CONTENT", "Post Updated Content"),
    POST_UPDATED_TITLE(3, "POST_UPDATED_TITLE", "Post Updated Title"),
    POST_DELETED(4, "POST_DELETED", "Post Deleted");

    private Integer id;
    private String value;
    private String description;

    public static EnumPostEvents getById(Integer id) {
        for (EnumPostEvents event : EnumPostEvents.values()) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }
    
}
