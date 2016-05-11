package gal.agasol.librecon.fragments;

import android.app.Fragment;
import android.content.Intent;

import gal.agasol.librecon.LoginPagerActivity;
import gal.agasol.librecon.domains.AssistantDomain;
import gal.agasol.librecon.domains.AssistantMeetingDomain;
import gal.agasol.librecon.domains.LastModifiedDomain;
import gal.agasol.librecon.domains.MeDomain;
import gal.agasol.librecon.domains.MeetingsDomain;

/**
 * Created by Asier Fernandez on 06/10/14.
 */
public class BaseFragment extends Fragment {

    public void logout() {
        MeDomain.clear(getActivity());
        LastModifiedDomain.clearLastModified(getActivity());
        MeetingsDomain.clearMeetings(getActivity());
        AssistantDomain.clearAssistants(getActivity());
        AssistantMeetingDomain.clearAssistantMeetings(getActivity());
        Intent intent = new Intent(getActivity(), LoginPagerActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
