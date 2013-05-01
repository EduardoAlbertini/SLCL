package br.com.entitys;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Miray
 */
@Entity
public enum Bibliografia {
    @Enumerated(EnumType.ORDINAL)
    BASICA,COMPLEMENTAR;
}
