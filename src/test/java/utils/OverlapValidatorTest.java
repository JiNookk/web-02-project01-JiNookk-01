package utils;

import models.MakaoTalk;
import models.Relation.UsersRelation;
import models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OverlapValidatorTest {
    @Test
    void validateUserRelations() {
        OverlapValidator overlapValidator = new OverlapValidator();

        User user1 = new User(1, "ojw0828", "7895123", "오진욱", "01085568965");
        User user2 = new User(2, "ojw0828", "7895123", "오진욱", "01085568965");
        User user3 = new User(3, "ojw0828", "7895123", "오진욱", "01085568965");
        User user4 = new User(4, "ojw0828", "7895123", "오진욱", "01085568965");
        User user5 = new User(5, "ojw0828", "7895123", "오진욱", "01085568965");
        User user6 = new User(6, "ojw0828", "7895123", "오진욱", "01085568965");

        MakaoTalk makaoTalk = new MakaoTalk();

        makaoTalk.login(1);

        makaoTalk.addUsersRelation(new UsersRelation(1,4));
        makaoTalk.addUsersRelation(new UsersRelation(2,3));
        makaoTalk.addUsersRelation(new UsersRelation(1,2));
        makaoTalk.addUsersRelation(new UsersRelation(3,1));
        makaoTalk.addUsersRelation(new UsersRelation(1,6));
        makaoTalk.addUsersRelation(new UsersRelation(2,5));

        assertTrue(overlapValidator.
                validateUserRelations(user2, makaoTalk));
        assertFalse(overlapValidator.
                validateUserRelations(user3, makaoTalk));
        assertTrue(overlapValidator.
                validateUserRelations(user4, makaoTalk));
        assertFalse(overlapValidator.
                validateUserRelations(user5, makaoTalk));
        assertTrue(overlapValidator.
                validateUserRelations(user6, makaoTalk));


    }

}