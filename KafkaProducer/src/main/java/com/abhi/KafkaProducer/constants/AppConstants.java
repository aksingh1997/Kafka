package com.abhi.KafkaProducer.constants;

import lombok.Getter;

@Getter
public enum AppConstants {

    Pune( 1),
    Mumbai( 2);

    AppConstants(int code) {
        this.code = code;
    }
    final int code;
}
