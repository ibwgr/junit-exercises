package fakes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

public class MockitoDefaultValuesTest {
  private MockitoDefaultValues sut;

  @BeforeEach
  void beforeEach() {
    sut = Mockito.mock(MockitoDefaultValues.class);
  }

  @Test
  public void returnBooleanMockedReturnsFalse() {
    assertFalse(sut.returnBoolean());
  }

  @Test
  public void returnIntegerMockedReturns0() {
    assertEquals((Integer) 0, sut.returnInteger());
  }

  @Test
  public void returnIntMockedReturns0() {
    assertEquals(0, sut.returnInt());
  }

  @Test
  public void returnUserMockedReturnsNull() {
    assertEquals(null, sut.returnUser());
  }

  @Test
  public void returnUserListMockedReturnsEmptyList() {
    assertEquals(0, sut.returnUserList().size());
  }

  @Test
  public void throwsExceptionOnStubbedVoidMethodCall() {
    assertThrows(Exception.class, () -> {
      doThrow(new Exception()).when(sut).returnVoid();
      sut.returnVoid();
    });
  }
}
