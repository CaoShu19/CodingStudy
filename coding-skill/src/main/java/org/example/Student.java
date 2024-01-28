package org.example;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    String name;
    String id;
}
