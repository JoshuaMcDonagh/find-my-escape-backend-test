package com.tamworth.find_my_escape_backend.service;

public interface EmailMessageService {
    void sendWelcomeEmail(String userEmailAddress, String userName);
    void sendChangeOfDetailsEmail(String userEmailAddress, String userName);
    void sendAccountDeletionEmail(String userEmailAddress, String userName);
}
