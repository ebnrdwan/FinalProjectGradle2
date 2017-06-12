import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.jokeAsync;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

/**
 * udacity-builditbigger
 * Created on 31/08/2016 by Espace de travail.
 */


@RunWith(AndroidJUnit4.class)
public class AsyncTest {
    
    @Test
    public void testDoInBackground() throws Exception{
        try {
            MainActivity mainActivity = new MainActivity();
            jokeAsync endpointsAsyncTask = new jokeAsync(mainActivity);
            endpointsAsyncTask.execute();
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);


            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
            Log.e("AsyncTest", "testDoInBackground: Timed out");
        }
    }
}
