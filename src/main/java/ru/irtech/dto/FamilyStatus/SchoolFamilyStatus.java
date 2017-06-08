package ru.irtech.dto.FamilyStatus;

import ru.irtech.dto.CoreObjects.SchoolDto;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
 * Class that represents single school family status percentage transport object
 */
public class SchoolFamilyStatus {

    /**
     * full family percentage.
     */
    private final double fullFamilyPercentage;

    /**
     * not full family percentage.
     */
    private final double notFullFamilyPercentage;

    /**
     * Related school.
     */
    private final SchoolDto school;

    /**
     * C-tor.
     *
     * @param fullFamilyPercentage    full family statuses percentage.
     * @param notFullFamilyPercentage not full family statuses percentage.
     * @param school                  school object
     */
    public SchoolFamilyStatus(final double fullFamilyPercentage, final double notFullFamilyPercentage, final SchoolDto school) {
        this.fullFamilyPercentage = fullFamilyPercentage;
        this.notFullFamilyPercentage = notFullFamilyPercentage;
        this.school = school;
    }

    /**
     * Returns related full family percentage.
     *
     * @return percentage.
     */
    public double getFullFamilyPercentage() {
        return fullFamilyPercentage;
    }

    /**
     * Returns related not full family percentage.
     *
     * @return percentage.
     */
    public double getNotFullFamilyPercentage() {
        return notFullFamilyPercentage;
    }

    /**
     * Returns related school object.
     *
     * @return school.
     */
    public SchoolDto getSchool() {
        return school;
    }
}
