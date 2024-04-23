package org.myproject.ebiblio.Entities.Enum;

import jakarta.persistence.Enumerated;


public enum BookStatus {
    BORROWED,
    SOLD,
    AVAILABLE,
    OUT_OF_STOCK
}
