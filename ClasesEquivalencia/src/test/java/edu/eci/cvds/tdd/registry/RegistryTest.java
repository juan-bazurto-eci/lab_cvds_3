package edu.eci.cvds.tdd.registry;
import org.junit.Assert;
import org.junit.Test;
public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("CR", 7, 37, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateRegistryResultDead() {
        Person person = new Person("Dario Gomez", 1, 70, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateRegistryResultInvalidAge() {
        Person person = new Person("Norbey", 2, 1000, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateRegistryResultUnderage() {
        Person person = new Person("MI", 3, 12, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateRegistryResultDuplicated() {
        Person person1 = new Person("Omaira", 4, 37, Gender.FEMALE, true);
        Person person2 = new Person("Omairo", 4, 64, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person1);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }
}
