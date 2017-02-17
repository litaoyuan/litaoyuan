package com.example.arthur.demoqc4;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arthur on 2017/2/13.
 */

public class NewsPaperGroupResponse {
    @SerializedName("Name")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("UISettings")
    UISettingsResponse UISettings
            ;

    public UISettingsResponse getUISettings() {
        return UISettings;
    }
}
