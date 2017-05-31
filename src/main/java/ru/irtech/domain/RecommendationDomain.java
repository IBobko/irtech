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
    /**
     * Links to other resources.
     * empty for advices of type 1 and 4.
     */
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(final String link) {
        this.link = link;
    }
}
