package ru.irtech.dto.FamilyStatus;

import ru.irtech.dto.ControllerResponse;

/**
 * Created by Iggytoto on 06.06.2017.
 * <p>
 * Class that represents transport object for array of data that represents schools family status statistics
 */
public class FamilyStatusToSchoolsRelationResponse extends ControllerResponse {

    /**
     * Packed data;
     */
    private final SchoolFamilyStatus[] schoolStatuses;

    /**
     * C-tor.
     *
     * @param schoolStatuses
     */
    public FamilyStatusToSchoolsRelationResponse(SchoolFamilyStatus[] schoolStatuses) {
        super(OK_MESSAGE);
        this.schoolStatuses = schoolStatuses;
    }

    /**
     * Gets the statuses.
     *
     * @return
     */
    public SchoolFamilyStatus[] getSchoolStatuses() {
        return schoolStatuses;
    }
}
