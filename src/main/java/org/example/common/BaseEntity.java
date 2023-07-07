package org.example.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseEntity<ID> {
    private ID id;
    private LocalDateTime update;
    private LocalDateTime created;

}
