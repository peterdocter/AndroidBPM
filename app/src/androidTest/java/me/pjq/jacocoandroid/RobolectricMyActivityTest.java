package me.pjq.jacocoandroid;

import android.widget.TextView;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.robolectric.Robolectric;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.lang.Exception;


@RunWith(RobolectricGradleTestRunner.class)
public class RobolectricMyActivityTest {
    MyActivity activity;

    @Before
    public void setup() throws Exception {
        activity = Robolectric.buildActivity(MyActivity.class).create().visible().get();

        assertTrue(null != activity);
    }


    @Test
    public void testShouldHaveApplicationName() throws Exception {
        String name = activity.getResources().getString(R.string.app_name);
        assertThat(name, equalTo("JacocoAndroid"));
    }


    @Test
    public void testLabel() throws Exception {
        TextView label = (TextView) activity.getFragmentManager().findFragmentByTag("tag"+1).getView().findViewById(R.id.section_label);
        assertThat("label1", equalTo(label.getText().toString()));
    }

    @Test
    public void testGetActivityId() throws Exception {
        String id = activity.getActivityId();
        assertThat(id, Matchers.equalTo("aasdfadsf"));
    }

    @After
    public void tearDown() throws Exception {
        activity.finish();
        activity = null;
        assertTrue(null == activity);
    }
}
