package com.iqmsoft.boot.kafka.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Message implements Serializable {
    String greeting;
}
