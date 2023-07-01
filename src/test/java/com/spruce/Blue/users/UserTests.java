package com.spruce.Blue.users;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserTests {

    @Autowired
    private TestEntityManager entityManager;

    private User user1;

    private User user2;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeEach
    public void setUp() {
        user1 = new User("Greg", "test@test.com", 23);
        user2 = new User();

    }

    @Test
    public void saveUser() {
        User savedUser = this.entityManager.persistAndFlush(user1);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("Greg");
        assertThat(savedUser.getEmail()).isEqualTo("test@test.com");
        assertThat(savedUser.getAge()).isEqualTo(23);

    }

    @Test
    public void validatesNamePresence() throws Exception {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("User email cannot be blank");
        new User("", "test@test.com", 23);
    }

    @Test
    public void validatesEmailPresence() throws Exception {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("User name cannot be blank");
        new User("Greg", "", 23);
    }

    @Test
    public void validatesAgePositive() throws Exception {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("User age must be greater than 0");
        new User("Greg", "test@test.com", 0);
    }
}
