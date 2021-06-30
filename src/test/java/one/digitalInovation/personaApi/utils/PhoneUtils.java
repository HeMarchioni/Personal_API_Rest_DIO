package one.digitalInovation.personaApi.utils;

import one.digitalInovation.personaApi.model.dto.request.PhoneDTO;
import one.digitalInovation.personaApi.model.enums.PhoneType;
import one.digitalInovation.personaApi.model.entity.phone.Phone;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .cd_Phone(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}