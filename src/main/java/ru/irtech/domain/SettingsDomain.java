package ru.irtech.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Entity
@Table(name = "settings", schema = "public", catalog = "irtech")
public class SettingsDomain {
    /**
     * Key.
     */
    private String key;
    /**
     * Value.
     */

    private String value;

    @Id
    @Column(name = "key", nullable = false)
    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SettingsDomain)) {
            return false;
        }
        SettingsDomain that = (SettingsDomain) o;
        return Objects.equals(getKey(), that.getKey())
                && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }
}
