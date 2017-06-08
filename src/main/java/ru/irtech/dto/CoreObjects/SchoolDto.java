package ru.irtech.dto.CoreObjects;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
 * Transport object that represents school.
 * //TODO to be updated
 */
public class SchoolDto {

    /**
     * School name.
     */
    private final String name;

    /**
     * School id.
     */
    private final Integer schoolid;

    /**
     * C-tor.
     *
     * @param name     SchoolName
     * @param schoolid schoolid
     */
    public SchoolDto(final String name, final Integer schoolid) {
        this.name = name;
        this.schoolid = schoolid;
    }

    /**
     * Gets School name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets school id.
     *
     * @return id.
     */
    public Integer getSchoolid() {
        return schoolid;
    }
}
