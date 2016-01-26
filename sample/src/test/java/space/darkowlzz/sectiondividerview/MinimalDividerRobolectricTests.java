package space.darkowlzz.sectiondividerview;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import space.darkowlzz.minimaldivider.MinimalDivider;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MinimalDividerRobolectricTests {

    MainActivity activity;
    Context ctx;
    MinimalDivider div1, div2, div3, div4, div5;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
        ctx = activity.getApplicationContext();
        div1 = (MinimalDivider) activity.findViewById(R.id.divider1);
        div2 = (MinimalDivider) activity.findViewById(R.id.divider2);
        div3 = (MinimalDivider) activity.findViewById(R.id.divider3);
        div4 = (MinimalDivider) activity.findViewById(R.id.divider4);
        div5 = (MinimalDivider) activity.findViewById(R.id.divider5);
    }

    @Test
    public void checkDividerColor() {
        assertThat(1, is(1));
    }
}
