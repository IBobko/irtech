package ru.irtech.domain;

import javax.persistence.*;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Entity
@Table(name = "recommendation")
public class RecommendationDomain {
    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * Text of recommendation.
     */
    private String data;
    /**
     * Type of advice.
     * 1 - informational
     * 2 - educational
     * 3 - advertisement
     * 4 - interesting fact
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(final Integer type) {
        this.type = type;
    }
}
