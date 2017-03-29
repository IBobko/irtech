package ru.irtech.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author Igor Bobko <limit-speed@yandex.ru>.
 */
@Entity
@Table(name = "hostname_stat")
public class HostnameStatDomain {
    /**
     * Primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_hostnamestat", allocationSize = 1)
    private Integer id;
    /**
     * Referer which send us request.
     */
    private String hostname;
    /**
     * Time when request was send.
     */
    private Calendar time;
    /**
     * User IP address which send request.
     */
    @Column(name = "user_ip")
    private String userIp;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(final Calendar time) {
        this.time = time;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(final String userIp) {
        this.userIp = userIp;
    }
}

