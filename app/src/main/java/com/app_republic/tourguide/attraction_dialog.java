package com.app_republic.tourguide;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class attraction_dialog extends DialogFragment {

    @Override
    public void onStart() {

        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            //make dialog full screen
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog;
        dialog = super.onCreateDialog(savedInstanceState);
        //remove title from the dialog
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        getDialog().getWindow().setBackgroundDrawableResource(R.color.cardview_dark_background);

        View view = inflater.inflate(R.layout.attraction, null);

        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);
        ImageView picture = view.findViewById(R.id.picture);
        ImageView showMap = view.findViewById(R.id.map);

        assert getArguments() != null;
        final Attraction attraction = getArguments().getParcelable(getString(R.string.attraction));

        assert attraction != null;
        title.setText(attraction.getName());
        desc.setText(attraction.getDescription());
        picture.setImageResource(attraction.getPicture());

        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //view location on map
                String location = attraction.getLocation().getLat()+","+attraction.getLocation().getLng();
                Uri gmmIntentUri = Uri.parse(getString(R.string.geo) +location+getString(R.string.query)+location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(getString(R.string.maps_package_name));
                startActivity(mapIntent);
            }
        });

        return view;
    }
}
