package gal.agasol.librecon;

import android.app.Activity;
import android.content.Intent;

import gal.agasol.librecon.domains.AssistantDomain;
import gal.agasol.librecon.domains.AssistantMeetingDomain;
import gal.agasol.librecon.domains.LastModifiedDomain;
import gal.agasol.librecon.domains.MeDomain;
import gal.agasol.librecon.domains.MeetingsDomain;

/**
 * Created by Asier Fernandez on 06/10/14.
 */
public class BaseActivity extends Activity {

    public void logout() {
        MeDomain.clear(this);
        LastModifiedDomain.clearLastModified(this);
        MeetingsDomain.clearMeetings(this);
        AssistantDomain.clearAssistants(this);
        AssistantMeetingDomain.clearAssistantMeetings(this);
        Intent intent = new Intent(this, LoginPagerActivity.class);
        startActivity(intent);
        finish();
    }
}
