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
     * @param fullFamilyPercentage
     * @param notFullFamilyPercentage
     * @param school
     */
    public SchoolFamilyStatus(double fullFamilyPercentage, double notFullFamilyPercentage, SchoolDto school) {
        this.fullFamilyPercentage = fullFamilyPercentage;
        this.notFullFamilyPercentage = notFullFamilyPercentage;
        this.school = school;
    }

    /**
     * Returns related full family percentage.
     *
     * @return
     */
    public double getFullFamilyPercentage() {
        return fullFamilyPercentage;
    }

    /**
     * Returns related not full family percentage.
     *
     * @return
     */
    public double getNotFullFamilyPercentage() {
        return notFullFamilyPercentage;
    }

    /**
     * Returns related school object.
     *
     * @return
     */
    public SchoolDto getSchool() {
        return school;
    }
}
