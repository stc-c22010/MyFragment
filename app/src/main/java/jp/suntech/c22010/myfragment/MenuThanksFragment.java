package jp.suntech.c22010.myfragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuThanksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuThanksFragment extends Fragment {

    public MenuThanksFragment(){
        super(R.layout.fragment_menu_thanks);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NotNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        Bundle extras = getArguments();

        String menuName = "";
        String menuPrice = "";


        if(extras != null){
            menuName = extras.getString("menuName");
            menuPrice = extras.getString("menuPrice");
        }

        TextView tvMenuName = view.findViewById(R.id.tvMenuName);
        TextView tvMenuPrice = view.findViewById(R.id.tvMenuPrice);

        tvMenuName.setText(menuName);
        tvMenuPrice.setText(menuPrice);

        Button btBackButton = view.findViewById(R.id.btThxBack);

        btBackButton.setOnClickListener(new ButtonClickListener());
    }

    private class ButtonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            FragmentManager manager = getParentFragmentManager();

            Activity parentActivity = getActivity();

            View fragmentMainContainer = parentActivity.findViewById(R.id.fragmentMainContainer);

            View fragmentThanksContainer = parentActivity.findViewById(R.id.fragmentThanksContainer);

            if(fragmentMainContainer != null){
                manager.popBackStack();
            }
            else if(fragmentThanksContainer != null){
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.setReorderingAllowed(true);

                transaction.remove(MenuThanksFragment.this);

                transaction.commit();
            }
        }
    }
}