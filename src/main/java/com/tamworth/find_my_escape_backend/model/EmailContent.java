package com.tamworth.find_my_escape_backend.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmailContent {
    private String userName = "user";

    private String welcomeSubject = "Welcome to Find My Escape";
    private String welcomeBody = "Dear " + userName + ",\n\nWelcome to Find My Escape!" +
            " We are excited to have you along with us!\n" +
            "\nYou can change any details or look through your favourites in the app.\n\nIf you have any questions " +
            "or need further assistance, feel free to reach out to us.\n\nBest regards,\n\nThe Support Team\n\nFind my " +
            "Escape\nhelp@find-my-escape\n";

    private String deletionSubject = "Account Deleted";
    private String deletionBody = "Dear " + userName + ",\n\nWe are sorry to see you go!" +
            "\nYour account has been deleted and you will no longer be able to access your favourites or details.\n" +
            "\nYou can still access the search as a guest but will have to re-register to save any favourites.\n\nIf you have any questions " +
            "or need further assistance, feel free to reach out to us.\n\nBest regards,\n\nThe Support Team\n\nFind my " +
            "Escape\nhelp@find-my-escape\n";

    private String changeOfDetailsSubject = "Change of Details";
    private String changeOfDetailsBody = "Dear " + userName + ",\n\nWe wanted to let you know that your account details have been successfully updated." +
            "\nIf you did not make these changes, please contact our support team immediately.\n\nIf you have any questions " +
            "or need further assistance, feel free to reach out to us.\n\nBest regards,\n\nThe Support Team\n\nFind my " +
            "Escape\nhelp@find-my-escape\n";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWelcomeSubject() {
        return welcomeSubject;
    }

    public String getWelcomeBody() {
        return welcomeBody;
    }

    public String getDeletionSubject() {
        return deletionSubject;
    }

    public String getDeletionBody() {
        return deletionBody;
    }

    public String getChangeOfDetailsSubject() {
        return changeOfDetailsSubject;
    }

    public String getChangeOfDetailsBody() {
        return changeOfDetailsBody;
    }

}
