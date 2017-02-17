package com.example.arthur.demoqc4;

import java.util.List;

/**
 * Created by arthur on 2017/2/13.
 */

public class UISettingsResponse {
    private MainTabBarLayout MainTabBarLayout;

    public MainTabBarLayout getMainTabBarLayout() {
        return MainTabBarLayout;
    }

    public void setMainTabBarLayout(UISettingsResponse.MainTabBarLayout mainTabBarLayout) {
        MainTabBarLayout = mainTabBarLayout;
    }

    public class MainTabBarLayout{
        int DefaultShowIndex;
        List<MainTabBars> MainTabBars;
        public class MainTabBars{
            String ViewId;
            String Name;
            String IconUrl;
            String SelectedIconUrl;

            public String getViewId() {
                return ViewId;
            }

            public void setViewId(String viewId) {
                ViewId = viewId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String name) {
                Name = name;
            }

            public String getIconUrl() {
                return IconUrl;
            }

            public void setIconUrl(String iconUrl) {
                IconUrl = iconUrl;
            }

            public String getSelectedIconUrl() {
                return SelectedIconUrl;
            }

            public void setSelectedIconUrl(String selectedIconUrl) {
                SelectedIconUrl = selectedIconUrl;
            }
        }

        public int getDefaultShowIndex() {
            return DefaultShowIndex;
        }

        public void setDefaultShowIndex(int defaultShowIndex) {
            DefaultShowIndex = defaultShowIndex;
        }

        public List<MainTabBars> getMainTabBars() {
            return MainTabBars;
        }

        public void setMainTabBars(List<MainTabBars> mainTabBars) {
            MainTabBars = mainTabBars;
        }
    }
}
