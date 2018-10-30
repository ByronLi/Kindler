package csci310.plshireus.org.kindler;

import android.text.Editable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUnitTest {

    private Login l;
    private Mockito m;

    @Before
    public void setUp(){
        l = mock(Login.class);
    }

    @Test
    public void TestAttemptLoginSuccess(){

        AutoCompleteTextView mEmailView = mock(AutoCompleteTextView.class);
        EditText mPasswordView = mock(EditText.class);
        Editable editEmail = mock(Editable.class);
        Editable editPass = mock(Editable.class);

        //mock calls
        when(mEmailView.getText()).thenReturn(editEmail);
        when(editEmail.toString()).thenReturn("a@a.com");

        when(mPasswordView.getText()).thenReturn(editPass);
        when(editPass.toString()).thenReturn("abc123");

        //Resolve null pointer calls
        doNothing().when(mEmailView).setError(null);
        doNothing().when(mPasswordView).setError(null);

        when(l.getFirebaseUser()).thenCallRealMethod();

        //TODO: Will eventually have to refactor, too much coupling
        doCallRealMethod().when(l).attemptLogin();

    }

    @Test
    public void TestEmailCheckSuccess(){

        //setup real call
        when(l.isEmailValid(Mockito.anyString())).thenCallRealMethod();

        assert(l.isEmailValid("a@a.com"));
    }

    @Test
    public void TestPasswordCheckSuccess(){

        //setup real call
        when(l.isPasswordValid(Mockito.anyString())).thenCallRealMethod();

        assert(l.isPasswordValid("abc123"));
    }
}