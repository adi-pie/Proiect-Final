package ro.sda.finalproject.service;

    public class UserNotFoundException extends Throwable {
        public UserNotFoundException(String detailMessage) {
            super(detailMessage);
        }
    }

