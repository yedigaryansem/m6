package service;

import model.User;

public class UserCreator {

    public static final String TEST_DATA_USER_NAME = "testdata.user.name";
    public static final String TEST_DATA_USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(testDataReader.getTestData(TEST_DATA_USER_NAME),
                testDataReader.getTestData(TEST_DATA_USER_PASSWORD));
    }
}
