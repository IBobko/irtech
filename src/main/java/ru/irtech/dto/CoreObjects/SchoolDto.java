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
     * C-tor.
     *
     * @param name SchoolName
     */
    public SchoolDto(String name) {
        this.name = name;
    }

    /**
     * Gets School name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }
}
