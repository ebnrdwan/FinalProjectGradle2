import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.JokeAsync;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Abdulrhman on 12/06/2017.
 */

@RunWith(AndroidJUnit4.class)
public class AsyncTest {

    @Test
    public void testDoInBackground() throws Exception {
        try {
            MainActivity mainActivity = new MainActivity();
            JokeAsync JokeAsync = new JokeAsync(mainActivity);
            JokeAsync.execute();
            String result = JokeAsync.get(30, TimeUnit.SECONDS);
            assertNotNull(result);  // it could be done by Google Guava checkNotNull() method
            assertTrue(result.length() > 0);

        } catch (Exception e) {
            Log.e("AsyncTest", "testDoInBackground: Timed out");
        }
    }
}
