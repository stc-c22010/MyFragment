package jp.suntech.c22010.myfragment;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuListFragment extends Fragment {
    public MenuListFragment() {
        super(R.layout.fragment_menu_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NotNull Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        ListView lvMenu = view.findViewById(R.id.lvMenu);

        //SimpleAdapterで使用するListオブジェクトを用意
        List<Map<String, String>> menuList = new ArrayList<>();
        //[唐揚げ定食]のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        Map<String, String> menu = new HashMap<>();
        menu.put("name", "唐揚げ定食");
        menu.put("price", "800円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", "750円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", "900円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "ミンチカツ定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "青椒肉絲定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "八宝菜定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "酢豚定食");
        menu.put("price", "850円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "豚の角煮定食");
        menu.put("price", "950円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "焼き鳥定食");
        menu.put("price", "800円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", "800円");
        menuList.add(menu);
        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", "900円");
        menuList.add(menu);


        Activity parentActivity = getActivity();
        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);
        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>) parent.getItemAtPosition(position);

            String menuName = item.get("name");
            String menuPrice = item.get("price");

            Bundle bundle = new Bundle();

            bundle.putString("menuName", menuName);
            bundle.putString("menuPrice", menuPrice);

            FragmentManager manager = getParentFragmentManager();

            FragmentTransaction transaction = manager.beginTransaction();

            transaction.setReorderingAllowed(true);

            transaction.addToBackStack("Only List");

            transaction.replace(R.id.fragmentMainContainer, MenuThanksFragment.class, bundle);

            transaction.commit();
        }
    }
}

