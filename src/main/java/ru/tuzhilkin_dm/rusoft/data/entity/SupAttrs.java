package ru.tuzhilkin_dm.rusoft.data.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SupAttrs implements Serializable {
    Map<String, Object> attrs;
}