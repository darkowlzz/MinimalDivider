package space.darkowlzz.sectiondividerview;

import android.content.Context;
import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import space.darkowlzz.minimaldivider.MinimalDivider;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MinimalDividerRobolectricTests {

    MainActivity activity;
    Context ctx;
    MinimalDivider div1, div2, div3, div4, div5;

    private int getDimensionResource(int res) {
        return ctx.getResources().getDimensionPixelSize(res);
    }

    private int getColorResource(int res) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ctx.getResources().getColor(res, ctx.getTheme());
        } else {
            return ctx.getResources().getColor(res);
        }
    }

    private CharSequence getTextResource(int res) {
        return ctx.getResources().getText(res);
    }

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
        assertThat(div1.getDividerLineColor(), is(getColorResource(android.R.color.holo_orange_dark)));
        assertThat(div2.getDividerLineColor(), is(getColorResource(android.R.color.holo_green_dark)));
        assertThat(div3.getDividerLineColor(), is(getColorResource(R.color.dividerLineColor_default)));
        assertThat(div4.getDividerLineColor(), is(getColorResource(R.color.dividerLineColor4)));
        assertThat(div5.getDividerLineColor(), is(getColorResource(android.R.color.white)));
    }

    @Test
    public void checkTopTextEnabled() {
        assertThat(div1.isTopTextEnabled(), is(false));
        assertThat(div2.isTopTextEnabled(), is(true));
        assertThat(div3.isTopTextEnabled(), is(true));
        assertThat(div4.isTopTextEnabled(), is(true));
        assertThat(div5.isTopTextEnabled(), is(false));
    }

    @Test
    public void checkBottomTextEnabled() {
        assertThat(div1.isBottomTextEnabled(), is(false));
        assertThat(div2.isBottomTextEnabled(), is(true));
        assertThat(div3.isBottomTextEnabled(), is(true));
        assertThat(div4.isBottomTextEnabled(), is(true));
        assertThat(div5.isBottomTextEnabled(), is(false));
    }

    @Test
    public void checkTopTextValue() {
        assertThat(div1.getTopTextValue(), is(nullValue()));
        assertThat(div2.getTopTextValue(), is(getTextResource(R.string.topText_value2)));
        assertThat(div3.getTopTextValue(), is(getTextResource(R.string.topText_value3)));
        assertThat(div4.getTopTextValue(), is(getTextResource(R.string.topText_value4)));
        assertThat(div5.getTopTextValue(), is(nullValue()));
    }

    @Test
    public void checkBottomTextValue() {
        assertThat(div1.getBottomTextValue(), is(nullValue()));
        assertThat(div2.getBottomTextValue(), is(getTextResource(R.string.bottomText_value2)));
        assertThat(div3.getBottomTextValue(), is(getTextResource(R.string.bottomText_value3)));
        assertThat(div4.getBottomTextValue(), is(getTextResource(R.string.bottomText_value4)));
        assertThat(div5.getBottomTextValue(), is(nullValue()));
    }

    @Test
    public void checkTopTextStyle() {
        assertThat(div2.getTopTextStyle(), is(android.R.style.TextAppearance_Large));
    }

    @Test
    public void checkBottomTextStyle() {
        assertThat(div2.getBottomTextStyle(), is(android.R.style.TextAppearance_Small));
    }
}
