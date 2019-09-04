package com.program.codemobile.itunesapplication.ui.configuration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.program.codemobile.itunesapplication.R;

import java.util.Locale;

public class ConfigurationFragment extends Fragment {

    private ConfigurationViewModel notificationsViewModel;

    private TextView showLG;
    Locale myLocale;
    private Switch switch1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        showLG =(TextView) root.findViewById(R.id.showLG);
        showLG.setText(Locale.getDefault().getDisplayLanguage());
        switch1 = (Switch) root.findViewById(R.id.switch1);

        return root;
    }
}