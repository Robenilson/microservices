package com.ms.email.record;

import java.util.UUID;

public record EmailRecordDTO(UUID userID, String emailTO, String subject,String text) {
}
