package fakes;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.doThrow;

/**
 * Created by ideadapt on 29.10.16.
 */
public class MockitoDefaultReturnValuesTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private MockitoDefaultReturnValues sut;

    @Test
    public void returnBooleanMockedReturnsFalse(){
        assertFalse(sut.returnBoolean());
    }

    @Test
    public void returnIntegerMockedReturns0(){
        assertEquals((Integer) 0, sut.returnInteger());
    }

    @Test
    public void returnIntMockedReturns0(){
        assertEquals((int) 0, sut.returnInt());
    }

    @Test
    public void returnUserMockedReturnsNull(){
        assertEquals(null, sut.returnUser());
    }

    @Test
    public void returnUserListMockedReturnsEmptyList(){
        assertEquals(0, sut.returnUserList().size());
    }

    @Test(expected = Exception.class)
    public void throwsExceptionOnStubbedVoidMethodCall(){
        doThrow(new Exception()).when(sut).returnVoid();
        sut.returnVoid();
    }
}
